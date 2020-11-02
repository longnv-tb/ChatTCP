/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import view.ServerView;

/**
 *
 * @author Long Coi
 */
public class ReadMessageThread extends Thread{
    private final Socket socket;
    private final ServerView serverView;
    private final User sender;
    private DataInputStream dis;
    private DataOutputStream dos;
    
    public ReadMessageThread(Socket s, ServerView serverView, User sender) throws IOException {
        this.socket = s;
        this.serverView = serverView;
        this.sender = sender;
        dis = new DataInputStream(s.getInputStream());
    }
    
    @Override
    public void run(){
        while(!serverView.getClientCollection().isEmpty()){
            try {
                String request = dis.readUTF();
                System.out.println(request);
                /*yêu cầu gửi cá nhân*/
                if(request.contains("@@:=")){
                    request = request.substring(4); /*request= userName:message*/
                    StringTokenizer st = new StringTokenizer(request, ":"); 
                    String userNameReceiver = st.nextToken();
                    String message = st.nextToken();
                    new DataOutputStream(((Socket)serverView.getClientCollection().get(userNameReceiver)).getOutputStream())
                            .writeUTF("<"+sender.getUserName()+"> to <"+userNameReceiver+">: "+message);
                }
            } catch (IOException ex) {
                Logger.getLogger(ReadMessageThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
