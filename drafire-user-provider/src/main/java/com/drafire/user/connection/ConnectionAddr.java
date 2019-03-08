package com.drafire.user.connection;

public enum  ConnectionAddr {
    _128("192.168.109.128"),
    _129("192.168.109.129"),
    _130("192.168.109.130"),
    _131("192.168.109.131");

    ConnectionAddr(String addr) {
        this.addr = addr;
    }
    private String addr;

    public String getAddr() {
        return addr;
    }

}
