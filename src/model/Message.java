/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Long Coi
 */
public class Message implements Serializable{
    private String type;
    private byte[] mess;
    private String userNameOfReceiver;
    private String userNameOfSender;

    public Message() {
        userNameOfReceiver="";
    }

    public Message(String type, byte[] mess, String userNameOfReceiver) {
        this.type = type;
        this.mess = mess;
        this.userNameOfReceiver = userNameOfReceiver;
    }

    public String getUserNameOfSender() {
        return userNameOfSender;
    }

    public void setUserNameOfSender(String userNameOfSender) {
        this.userNameOfSender = userNameOfSender;
    }

    public String getUserNameOfReceiver() {
        return userNameOfReceiver;
    }

    public void setUserNameOfReceiver(String userNameOfReceiver) {
        this.userNameOfReceiver = userNameOfReceiver;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getMess() {
        return mess;
    }

    public void setMess(byte[] mess) {
        this.mess = mess;
    }

    @Override
    public String toString() {
        return type;
    }
}
