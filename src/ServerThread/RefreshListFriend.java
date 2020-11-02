/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerThread;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.ServerView;

/**
 *
 * @author Long Coi
 */
public class RefreshListFriend extends Thread{
    private final ServerView serverView;

    public RefreshListFriend(ServerView serverView) {
        this.serverView = serverView;
    }
    
    @Override
    public void run(){
        String strUserName = "";
        
        /*nối các username trong list client thành 1 chuỗi gửi về client*/
        Set setUserName = serverView.getClientCollection().keySet();
        Iterator itorator = setUserName.iterator();
        while(itorator.hasNext()){
            String userName = (String) itorator.next();
            strUserName+=userName+",";
        }
        
        /*loại bỏ dấu , ở cuối*/
        if(strUserName.length() != 0){
            strUserName = strUserName.substring(0, strUserName.length()-1);
        }
        
        /*gửi cho từng client trong list chuỗi strUserName*/
        itorator = setUserName.iterator();
        while(itorator.hasNext()){
            String userName = (String) itorator.next();
            try {
                new DataOutputStream(((Socket)serverView.getClientCollection().get(userName)).getOutputStream()).writeUTF("new:="+strUserName);
            } catch (IOException ex) {
                Logger.getLogger(RefreshListFriend.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
