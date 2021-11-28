package pl.edu.agh.kis.pz1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class MainModel {
    public static void main(String[] args){

    }

    public static void cardShower(List<Player> players){
        for (Player p:players){
            p.showCards();
            System.out.println("Current hand is: " + p.currentHand);
        }
    }


    public static void cardSwapper(List<Player> players, List<Card> shuffledDeck, int currSize){
        Scanner scan = new Scanner(System.in);
        String answer;

        for(Player p: players){
            System.out.println( p.playerName + ", you can swap up to 4 cards.\n" );
            int swappedCards = 0;
            for(int j=0; j<5; j++){
                if (swappedCards == 4) break;
                System.out.println("Do you want to swap " + p.cards.get(j).toString() + "?");
                answer = scan.nextLine();
                if (answer.equals("Y") ||answer.equals("y") ){
                    p.cards.set(j, shuffledDeck.get(currSize-1));
                    currSize -= 1;
                    swappedCards += 1;
                }
            }
            sortCards(p.cards);
            p.currentHand = PlayerHand.CheckHand(p.cards);
        }
    }

    public static void sortPlayers(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.size() - i - 1; j++) {
                if (players.get(j).currentHand.value < players.get(j + 1).currentHand.value ||
                        (players.get(j).currentHand.value == players.get(j + 1).currentHand.value) && PlayerHand.HighestCard(players.get(j).cards) < PlayerHand.HighestCard(players.get(j+1).cards))
                    Collections.swap(players, j, j + 1);
            }
        }
    }

    public static void sortCards(List<Card> cards) {
        for(int i=0; i<cards.size()-1; i++) {
            for (int j = 0; j < cards.size() - i - 1; j++) {
                if (cards.get(j).rank.value > cards.get(j + 1).rank.value) Collections.swap(cards, j, j + 1);
            }
        }
    }
}