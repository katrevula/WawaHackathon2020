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
}