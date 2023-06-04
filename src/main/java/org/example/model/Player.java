package org.example.model;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private String nome;

    private boolean banco = false;
    private List<Carte> cards = new ArrayList<Carte>();
    private boolean stoned = false;

    private double punto;

    public Player(String nome){
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public List<Carte> getCards() {
        return cards;
    }

    public void setCards(List<Carte> cards) {
        this.cards = cards;
    }

    public void addCard(Carte card){
        cards.add(card);
    }

    public boolean getBanco() {
        return banco;
    }
    public void setBanco(boolean banco) {
        this.banco = banco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPunto() {
        return punto;
    }

    public void setPunto(double punto) {
        this.punto = punto;
    }

    public void setStoned(boolean stoned) {
        this.stoned = stoned;
    }

    public boolean getStoned(){
        return stoned;
    }

    public String toString(){
        return "Il giocatore: " + getNome() + ", banco: " + getBanco() + " ha queste carte: " + getCards();
    }

}
