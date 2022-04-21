package com.main.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lab3", schema = "public")
public class MainEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "phnumber")
    private String phnumber;

    @Column(name = "fnumber")
    private String fnumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String name) {
        this.fio = name;
    }

    public String getCode() {
        return phnumber;
    }

    public void setCode(String phnumber) {
        this.phnumber = phnumber;
    }

    public String getLimit() {
        return fnumber;
    }

    public void setLimit(String fnumber) {
        this.fnumber = fnumber;
    }
}
