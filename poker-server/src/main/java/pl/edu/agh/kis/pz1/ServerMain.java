package pl.edu.agh.kis.pz1;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args){
        try{int playersNumber = 3;

            ServerSocket ss=new ServerSocket(6897);

            List<Socket> sockets = new ArrayList<>();
            for(int i=0; i<playersNumber; i++){
                sockets.add(ss.accept());
            }


            int currSize = Deck.DECK_SIZE;
            List<Card> shuffledDeck = Deck.factory();
            Deck currDeck = new Deck(shuffledDeck);
            shuffledDeck = currDeck.shuffle();
            List<Player> players = new ArrayList<>();

            for(int i=0; i<playersNumber; i++) {
                players.add(new Player(shuffledDeck.subList(currSize - 5, currSize)));
                System.out.println("Player " + (i+1) + ", please enter your nickname:");
                DataInputStream dis=new DataInputStream(sockets.get(i).getInputStream());
                DataOutputStream dout = new DataOutputStream(sockets.get(i).getOutputStream());
                String name = dis.readUTF();
                if(name.equals("")) players.get(i).setGuest(i+1);
                else players.get(i).playerName = name;
                System.out.println("Your name is:" + name);
                currSize = currSize - 5;
                players.get(i).currentHand = PlayerHand.CheckHand(players.get(i).cards);
                dout.writeUTF("Yout current cards are: ");
                for(int j=0; j<5; j++){
                    dout.writeUTF(players.get(i).cards.get(j).toString());
                }
                dout.writeUTF("Your current hand hand is " + players.get(i).currentHand);
            }

            MainModel.cardShower(players);

            Scanner scan = new Scanner(System.in);
            String answer;

            for(int i=0; i<playersNumber; i++){
                DataInputStream dis;
                DataOutputStream dout = new DataOutputStream(sockets.get(i).getOutputStream());

                dout.writeUTF( players.get(i).playerName + ", you can swap up to 4 cards.\n" );
                int swappedCards = 0;
                for(int j=0; j<5; j++){
                    if (swappedCards == 4) break;
                    dout.writeUTF("Do you want to swap " + players.get(i).cards.get(j).toString() + "?");

                    dis=new DataInputStream(sockets.get(i).getInputStream());
                    answer = dis.readUTF();
                    System.out.println(answer);
                    if (answer.equals("Y") ||answer.equals("y") ){
                        players.get(i).cards.set(j, shuffledDeck.get(currSize-1));
                        currSize -= 1;
                        swappedCards += 1;
                        System.out.println("udalo sie");
                    }

                }
                MainModel.sortCards(players.get(i).cards);
                players.get(i).currentHand = PlayerHand.CheckHand(players.get(i).cards);
                dout.writeUTF("Yout current cards are: ");
                for(int j=0; j<5; j++){
                    dout.writeUTF(players.get(i).cards.get(j).toString());
                }
                dout.writeUTF("Your current hand hand is " + players.get(i).currentHand);
            }
            MainModel.cardShower(players);

            List<Player> winningPlayers = players;
            MainModel.sortPlayers(winningPlayers);
            for(int i=0; i<playersNumber; i++){
                DataOutputStream dout = new DataOutputStream(sockets.get(i).getOutputStream());
                dout.writeUTF("The winner is: " + winningPlayers.get(0).playerName + "!");
            }
            ss.close();
        }catch(Exception e){System.out.println(e);}
    }
}