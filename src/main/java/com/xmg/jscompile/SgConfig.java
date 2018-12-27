package com.xmg.jscompile;

public class SgConfig implements Config{

    private int maxOnline = 1500;

    private String server = "127.0.0.1";



    @Override
    public void validate() {

    }


    public int getMaxOnline() {
        return maxOnline;
    }

    public void setMaxOnline(int maxOnline) {
        this.maxOnline = maxOnline;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
