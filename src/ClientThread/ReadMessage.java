/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientThread;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                String response = new DataInputStream(socket.getInputStream()).readUTF();
                System.out.println(response);
                /*nếu là chuỗi thông báo client mới*/
                if(response.contains("new:=")){
                    response = response.substring(5);
                    clientView.clearList();
                    
                    /*tách chuỗi nhận được: response(client) = new:=strUserName(server)*/
                    StringTokenizer st = new StringTokenizer(response,",");
                    while(st.hasMoreTokens()){
                        String userName = st.nextToken();
                        if(!userName.equalsIgnoreCase(clientView.getUser().getUserName())){
                            clientView.addElement(userName);
                        }
                    }
                }
                /*message bình thường*/
                else{
                    clientView.appendChatBox(response+"\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(ReadMessage.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }
    }
}
