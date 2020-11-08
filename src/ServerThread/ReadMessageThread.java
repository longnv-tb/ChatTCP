/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Message;
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
    private ObjectInputStream ois;
    
    public ReadMessageThread(Socket s, ServerView serverView, User sender, ObjectInputStream ois) throws IOException {
        this.socket = s;
        this.serverView = serverView;
        this.sender = sender;
        this.ois = ois;
    }
    
    @Override
    public void run(){
        while(!serverView.getClientCollection().isEmpty()){
            try {
                Message message = (Message) ois.readObject();
                /*yêu cầu gửi cá nhân*/
                if(!"".equals(message.getUserNameOfReceiver())){
                        new ObjectOutputStream(((Socket)serverView.getClientCollection().get(message.getUserNameOfReceiver())).getOutputStream())
                            .writeObject(message);
                }else{
                    Set setUserName = serverView.getClientCollection().keySet(); /*get user name trong collection*/
                    Iterator iterator = setUserName.iterator(); /*duyệt từng username*/
                    while(iterator.hasNext()){
                        String userName = (String) iterator.next();
                        if(!userName.equalsIgnoreCase(sender.getUserName())){
                                new ObjectOutputStream(((Socket)serverView.getClientCollection()
                                    .get(userName)).getOutputStream()).writeObject(message);
                        }
                    }
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ReadMessageThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
