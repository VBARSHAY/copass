package com.jb.copass.exceptions;/*
 *Created by User in 7/24/2022
 */

public enum LayerMsg {
    CONNECTION_POOL("Something went wrong inside Connection Pool"),
    JDBC_UTILS("Something went wrong inside JDBC Utils"),
    DAO("Something went wrong inside DAO Layer");

    private String msg;
    LayerMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
