    package org.example.model;
    import java.util.*;

    public class Mazzo {

        private List<Carte> deck = new ArrayList<>(40);
        private String[] seme = new String[4];

        {
            seme[0] = "Denari";
            seme[1] = "Bastoni";
            seme[2] = "Spade";
            seme[3] = "Coppe";
        }

        public Mazzo(){
            List<Carte> newDeck = new ArrayList<Carte>();
            for(int i = 0; i <10; i++){
                for (int j = 0; j < 4; j++){
                    newDeck.add(new Carte(i+1, seme[j]));
                }
            }
            Collections.shuffle(newDeck);
            deck = newDeck;
        }

        public List<Carte> getDeck() {
            return deck;
        }

        public void printDeck(){
            for(int i = 0; i < deck.size(); i++){
                System.out.println(deck.get(i));
            }
        }

        public Carte giveCard(){
            Carte cardFrist = deck.get(0);
            deck.remove(0);
            return cardFrist;
        }



        public double controlsGame(List<Carte> cards){
            double valore = 0, count = 0;
            for(Carte c : cards){
                if(c.getNumber() == 10 && c.getSeme() == "Denari"){
                    System.out.println("E' la matta");
                    valore = chooseValueCard(c);
                } else if (c.getNumber() == 10 ||c.getNumber() == 9 || c.getNumber() == 8) {
                    valore = 0.5;
                }else{
                    valore = c.getNumber();
                }
                count += valore;
            }
            if (count > 7.5){
                System.out.println("Hai sballato");
                System.out.println("Somma: " + count);
            }
            return count;
        }

        public double chooseValueCard(Carte carte){
            Scanner input = new Scanner(System.in);
            System.out.print("Che valore vuoi che prenda: ");
            double risposa = input.nextDouble();
            if (risposa > 7 || risposa == 1.5 || risposa == 2.5 || risposa == 3.5 || risposa == 4.5 || risposa == 5.5 || risposa == 6.5){
                System.out.print("Valore non valido: [0.5 | 1-7]: ");
                risposa = input.nextDouble();
                carte.setNumber((int) risposa);
            }else{
                carte.setNumber((int) risposa);
            }
            return risposa;
        }



       public void controlsWinner(List<Player> players){
            double winner = 0.0;
            for (int i = 0; i < players.size(); i++){
                if (players.get(i).getBanco() != true){
                    if (players.get(i).getPunto() > winner){
                        winner = players.get(i).getPunto();
                        if (puneggioBanco(players) >= winner){
                            System.out.println("Il banco ha vinto");
                        }else{
                            System.out.println("");
                            System.out.println(players.get(i).getNome() + " ha vinto con: " + players.get(i).getPunto());
                        }
                    }
                }
            }
        }

        public double puneggioBanco(List<Player> players){
            double punteggioBanco = 0.0;
            for (int i = 0; i < players.size(); i++){
                if (players.get(i).getBanco() == true){
                    punteggioBanco = players.get(i).getPunto();
                }
            }
            return punteggioBanco;
        }

    }
