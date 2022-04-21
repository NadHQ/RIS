package com.main.Service;

public class MainEntityDuplicate {

    private final String fio;
    private final String phnumber;
    private final String fnumber;

    public MainEntityDuplicate(String fio, String phnumber, String fnumber) {
        this.fio = fio;
        this.phnumber = phnumber;
        this.fnumber = fnumber;
    }

    public String getFio() {
        return fio;
    }

    public String getPhnumber() {
        return phnumber;
    }

    public String getFnumber() {
        return fnumber;
    }

}
