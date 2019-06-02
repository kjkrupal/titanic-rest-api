package com.titanic.dashboard.entity;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="passenger_id")
    @CsvBindByName(column = "PassengerId")
    private int passengerId;

    @Column(name="survived")
    @CsvBindByName(column = "Survived")
    private int survived;

    @Column(name="pclass")
    @CsvBindByName(column = "Pclass")
    private int pclass;

    @Column(name="name")
    @CsvBindByName(column = "Name")
    private String name;

    @Column(name="sex")
    @CsvBindByName(column = "Sex")
    private String sex;

    @Column(name="age")
    @CsvBindByName(column = "Age")
    private float age;

    @Column(name="sibsp")
    @CsvBindByName(column = "SibSp")
    private int sibsp;

    @Column(name="parch")
    @CsvBindByName(column = "Parch")
    private int parch;

    @Column(name="ticket")
    @CsvBindByName(column = "Ticket")
    private String ticket;

    @Column(name="fare")
    @CsvBindByName(column = "Fare")
    private double fare;

    @Column(name="cabin")
    @CsvBindByName(column = "Cabin")
    private String cabin;

    @Column(name="embarked")
    @CsvBindByName(column = "Embarked")
    private char embarked;

    public Passenger() {

    }

    public Passenger(int id, int passengerId, int survived, int pclass, String name, String sex, float age, int sibsp, int parch, String ticket, double fare, String cabin, char embarked) {
        this.id = id;
        this.passengerId = passengerId;
        this.survived = survived;
        this.pclass = pclass;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sibsp = sibsp;
        this.parch = parch;
        this.ticket = ticket;
        this.fare = fare;
        this.cabin = cabin;
        this.embarked = embarked;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getSurvived() {
        return survived;
    }

    public void setSurvived(int survived) {
        this.survived = survived;
    }

    public int getPclass() {
        return pclass;
    }

    public void setPclass(int pclass) {
        this.pclass = pclass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public int getSibsp() {
        return sibsp;
    }

    public void setSibsp(int sibsp) {
        this.sibsp = sibsp;
    }

    public int getParch() {
        return parch;
    }

    public void setParch(int parch) {
        this.parch = parch;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public char getEmbarked() {
        return embarked;
    }

    public void setEmbarked(char embarked) {
        this.embarked = embarked;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
