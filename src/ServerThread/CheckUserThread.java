package ServerThread;

import dao.UserDAO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import view.ServerView;

/**
 *
 * @author Long Coi
 */
public class CheckUserThread extends Thread{
    private final Socket socket;
    private final ServerView serverView;
    private final ObjectInputStream ois;
    private final ObjectOutputStream oos;
    
    public CheckUserThread(Socket socket, ServerView serverView) throws IOException {
        this.socket = socket;
        this.serverView = serverView;
        ois = new ObjectInputStream(socket.getInputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());
    }
    
    @Override
    public void run(){
        while(true){
            try {
                User u = (User) ois.readObject();
                UserDAO userDao = new UserDAO();
                if(u.getName().equals("")){
                    u = userDao.checkLogin(u);
                    if(u!=null){
                        oos.writeObject(u.getName());
                        serverView.getClientCollection().put(u.getUserName(), socket);
                        serverView.appendChatBox(u.getUserName()+" được kết nối!\n");
                        new ReadMessageThread(socket, serverView, u, ois).start();
                        new RefreshListFriend(serverView).start();
                        this.stop();
                    }
                    else{
                        oos.writeObject("loginfailed");
                    }
                }else{
                    if(!userDao.checkUser(u)){
                        userDao.addUser(u);
                        oos.writeObject("signupsuccess");
                        serverView.getClientCollection().put(u.getUserName(), socket);
                        serverView.appendChatBox(u.getUserName()+" được kết nối!\n");
                        new ReadMessageThread(socket, serverView, u,ois).start();
                        new RefreshListFriend(serverView).start();
                        this.stop();
                    }else
                        oos.writeObject("signupfailed");
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CheckUserThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
