/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Message;
import view.ClientView;

/**
 *
 * @author Long Coi
 */
public class ReadMessage extends Thread{
    private final Socket socket;
    private final ClientView clientView;

    public ReadMessage(Socket s, ClientView clientView) throws IOException {
        this.socket = s;
        this.clientView = clientView;
    }
    
    
    @Override
    public void run(){
        while(true){
            try {
                Message message = (Message) new ObjectInputStream(socket.getInputStream()).readObject();
                System.out.println(message);
                /*nếu là chuỗi thông báo client mới*/
                if(message.getType().equalsIgnoreCase("new")){
                    clientView.clearList();
                    String str = message.getUserNameOfReceiver();
                    System.out.println(str);
                    StringTokenizer st = new StringTokenizer(str,",");
                    while(st.hasMoreTokens()){
                        String key = st.nextToken();
                        if(!key.equalsIgnoreCase(clientView.getUser().getUserName())){
                            clientView.addElement(key);
                        }
                    }
                }
                /*message bình thường*/
                else if(message.getType().equalsIgnoreCase("text")){
                    String m = new String(message.getMess(),StandardCharsets.UTF_8);
                    if(message.getUserNameOfReceiver().equalsIgnoreCase("")){
                        clientView.appendChatBox("<"+message.getUserNameOfSender()+" to ALL>: "+m+"\n");
                    }else
                        clientView.appendChatBox("<"+message.getUserNameOfSender()+" to you>:"+m+"\n");
                }else{
                    clientView.addReceivedFile(message);
                    if(message.getUserNameOfReceiver().equalsIgnoreCase("")){
                        clientView.appendChatBox("<"+message.getUserNameOfSender()+" to ALL>: "+message.getType()+"\n");
                    }else
                        clientView.appendChatBox("<"+message.getUserNameOfSender()+" to you>:"+message.getType()+"\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(ReadMessage.class.getName()).log(Level.SEVERE, null, ex);
                break;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReadMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
