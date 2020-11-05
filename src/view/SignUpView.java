/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.User;

public class SignUpView extends javax.swing.JFrame {
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    /**
     * Creates new form LoginView
     * @param s
     */
    public SignUpView(Socket s, ObjectInputStream oi, ObjectOutputStream oo) {
        super("Sign up View");
        initComponents();
        this.socket = s;
        this.ois = oi;
        this.oos = oo;
        setLocationRelativeTo(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSignUpView = new javax.swing.JLabel();
        lbLastName = new javax.swing.JLabel();
        btnSignUp = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        cbPassword = new javax.swing.JCheckBox();
        txtName = new javax.swing.JTextField();
        lbUsername = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lbConfirmPassword = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        cbConfirmPassword = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbSignUpView.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbSignUpView.setText("SignUpView");

        lbLastName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbLastName.setText("Your Name:");

        btnSignUp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSignUp.setText("Sign up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        cbPassword.setText("Show Password");
        cbPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPasswordActionPerformed(evt);
            }
        });

        lbUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbUsername.setText("Username:");

        lbPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbPassword.setText("Password:");

        lbConfirmPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbConfirmPassword.setText("Confirm Password:");

        cbConfirmPassword.setText("Show Password");
        cbConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConfirmPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLastName)
                            .addComponent(lbUsername)
                            .addComponent(lbPassword)
                            .addComponent(lbConfirmPassword))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbPassword)
                                    .addComponent(cbConfirmPassword, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(btnSignUp))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(lbSignUpView)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lbSignUpView, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLastName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbConfirmPassword)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbConfirmPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnSignUp)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPasswordActionPerformed
        // TODO add your handling code here:
        if(cbPassword.isSelected()){
            txtPassword.setEchoChar((char)0);
        }else{
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_cbPasswordActionPerformed

    private void cbConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConfirmPasswordActionPerformed
        // TODO add your handling code here:
        if(cbConfirmPassword.isSelected()){
            txtConfirmPassword.setEchoChar((char)0);
        }else{
            txtConfirmPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_cbConfirmPasswordActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();
        if(name.isEmpty() ||  username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            JOptionPane.showMessageDialog(this, "Information must be filled out completely!");
            return;
        }
        if(!password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(this, "Password confirmation failed!");
            return;
        }else if(password.equals(confirmPassword)){
            User user = new User(name, username, password);
            try {
                oos.writeObject(user);
                String str = (String) ois.readObject();
                if(str.equalsIgnoreCase("signupsuccess")){
                    System.out.println("success");
                    new ClientView(user, socket, ois, oos).setVisible(true);
                    this.dispose();
                }else if(str.equalsIgnoreCase("signupfailed")){
                    JOptionPane.showMessageDialog(null, "User này đã tồn tại!");
                }
            } catch (IOException ex) {
                Logger.getLogger(SignUpView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SignUpView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSignUpActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignUp;
    private javax.swing.JCheckBox cbConfirmPassword;
    private javax.swing.JCheckBox cbPassword;
    private javax.swing.JLabel lbConfirmPassword;
    private javax.swing.JLabel lbLastName;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbSignUpView;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
