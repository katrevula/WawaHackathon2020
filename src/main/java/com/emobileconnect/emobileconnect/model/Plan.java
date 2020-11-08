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


    private int talktime;


    private double data;

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
        return talktime;
    }

    public void setTalktime(int talktime) {
        this.talktime = talktime;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }
}