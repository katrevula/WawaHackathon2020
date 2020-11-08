package com.emobileconnect.emobileconnect.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "plan")
@SequenceGenerator(name = "seq", initialValue = 1)
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private int plan_id;

    @NotNull
    private String plan_Name;

    @NotNull
    private int Talktime;

    @NotNull
    private double Data;

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public String getPlan_Name() {
        return plan_Name;
    }

    public void setPlan_Name(String plan_Name) {
        this.plan_Name = plan_Name;
    }

    public int getTalktime() {
        return Talktime;
    }

    public void setTalktime(int talktime) {
        Talktime = talktime;
    }

    public double getData() {
        return Data;
    }

    public void setData(double data) {
        Data = data;
    }
}