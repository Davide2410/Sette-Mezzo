package org.example.model;

public class Carte {

    private int number;
    private  String seme;

    public Carte(int number, String seme){
        this.number = number;
        this.seme = seme;
    }

    public int getNumber() {
        return number;
    }

    public String getSeme() {
        return seme;
    }

    public void setSeme(String seme) {
        this.seme = seme;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String toString(){
        return  this.getNumber() + " " + this.getSeme();
    }
}
