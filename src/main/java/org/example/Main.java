package org.example;

import org.example.model.Carte;
import org.example.model.Mazzo;
import org.example.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Mazzo m = new Mazzo();
        List<Player> players = new ArrayList<Player>();


        System.out.println("Quanti sono i giocatori presenti al tavolo?");
        int playersTotal = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < playersTotal; i++) {
            System.out.println("Qual è il nome del giocatore n°" + (i+1) + "?");
            String name = scanner.nextLine();
            players.add(new Player(name));
            Carte card = m.giveCard();
            players.get(i).addCard(card);
            System.out.println("Hai ricevuto la prima carta");
            System.out.println("");
        }

        int banco = (int)(Math.random() * players.size());
        players.get(banco).setBanco(true);
        System.out.println(players.get(banco).getNome() + " è il banco");

        int count = 0;
        for (int i = 0; i < players.size(); i++){
            if (players.get(i).getBanco() != true){
                boolean status = false;
                while (!status){
                    System.out.println("");

                    System.out.println( players.get(i).getNome() + " le tue carte girate: " +  players.get(i).getCards() );
                    System.out.println(players.get(i).getNome() + " vuoi una carta o stai? (s/n)");
                    String risposta = scanner.nextLine();
                    if (risposta.toLowerCase().equals("s")){
                        Carte card = m.giveCard();
                        System.out.println(card);
                        players.get(i).addCard(card);
                        if(m.controlsGame(players.get(i).getCards()) > 7.5){
                            status = true;
                            players.get(i).setStoned(true);
                            count++;
                        } else if (m.controlsGame(players.get(i).getCards()) == 7.5) {
                            System.out.println("Complimenti hai fatto il punteggio massimo");
                            players.get(i).setPunto(m.controlsGame(players.get(i).getCards()));
                            System.out.println(players.get(i).getNome() + " ha fatto: " + players.get(i).getPunto());
                            status = true;
                        } else{
                            m.controlsGame(players.get(i).getCards());
                        }
                    }else {
                        System.out.println("Sto");
                        players.get(i).setPunto(m.controlsGame(players.get(i).getCards()));
                        System.out.println(players.get(i).getNome() + " ha fatto: " + players.get(i).getPunto());
                        status = true;
                    }
                }
            }
        }

        if (count == players.size() - 1){
            System.out.println(players.get(banco).getNome() + " (banco) vince la partita perchè tutti i giocatori hanno perso");
        }else{
            boolean status = false;
            while (!status){
                System.out.println("");
                System.out.println( players.get(banco).getNome() + " le tue carte: " + players.get(banco).getCards());
                System.out.println("Il banco vuole una carta o sta? (s/n)");
                String risposta = scanner.nextLine();
                if (risposta.toLowerCase().equals("s")){
                    Carte card = m.giveCard();
                    System.out.println(card);
                    players.get(banco).addCard(card);
                    if(m.controlsGame(players.get(banco).getCards()) > 7.5){
                        status = true;
                        players.get(banco).setStoned(true);
                    } else if (m.controlsGame(players.get(banco).getCards()) == 7.5) {
                        System.out.println("Complimenti hai fatto il punteggio massimo");
                        players.get(banco).setPunto(m.controlsGame(players.get(banco).getCards()));
                        System.out.println(players.get(banco).getNome() + " ha fatto: " + players.get(banco).getPunto());
                        status = true;
                    } else{
                        m.controlsGame(players.get(banco).getCards());
                    }
                }else {
                    System.out.println("Sto");
                    players.get(banco).setPunto(m.controlsGame(players.get(banco).getCards()));
                    System.out.println(players.get(banco).getNome() + " ha fatto: " + players.get(banco).getPunto());
                    status = true;
                }
            }
            m.controlsWinner(players);
        }
        scanner.close();
    }
}