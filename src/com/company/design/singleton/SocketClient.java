package com.company.design.singleton;

public class SocketClient {

    //생성자
    private static SocketClient socketClient=null;

    private SocketClient() {

    }

    //어디서든 여기 접근 가능
    public static SocketClient getInstance(){
        if(socketClient ==null){
            socketClient=new SocketClient();
        }
        return socketClient;
    }

    public void connect(){
        System.out.println("connect");
    }
}
