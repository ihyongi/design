package com.company.design.adapter;

public class SocketAdapter implements Electronic110V{

    //110v->220v
    private Electronic220V electronic220V;

    //기본생성자에 220v
    public SocketAdapter(Electronic220V electronic220V) {
        this.electronic220V = electronic220V;
    }

    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}
