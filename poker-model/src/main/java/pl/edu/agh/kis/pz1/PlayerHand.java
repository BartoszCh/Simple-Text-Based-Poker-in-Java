package pl.edu.agh.kis.pz1;

import java.util.List;

public class PlayerHand {

    public static boolean CheckStraight(List<Card> cards){
        for(int i=0; i<cards.size()-1; i++){
            if(cards.get(i).rank.value != cards.get(i+1).rank.value-1) return false;
        }
        return true;
    }

    public static boolean CheckFlush(List<Card> cards){
        if((cards.get(0).suit.equals(cards.get(1).suit) && cards.get(0).suit.equals(cards.get(2).suit) && cards.get(0).suit.equals(cards.get(3).suit)&& cards.get(0).suit.equals(cards.get(4).suit))) return true;
        return false;
    }

    public static int HighestCard(List<Card> cards){
        int highestRank = 0;
        for(Card c: cards){
            if(c.rank.value*10+c.suit.value > highestRank) highestRank = c.rank.value*10+c.suit.value;
        }
        return highestRank;
    }

    public static boolean CheckFour(List<Card> cards){
        if((cards.get(0).rank.equals(cards.get(1).rank) && cards.get(0).rank.equals(cards.get(2).rank) && cards.get(0).rank.equals(cards.get(3).rank)) ||
                cards.get(1).rank.equals(cards.get(2).rank) && cards.get(1).rank.equals(cards.get(3).rank) && cards.get(1).rank.equals(cards.get(4).rank)) return true;
        return false;
    }

    public static boolean CheckThree(List<Card> cards){
        if((cards.get(0).rank.equals(cards.get(1).rank) && cards.get(0).rank.equals(cards.get(2).rank)) ||
                cards.get(1).rank.equals(cards.get(2).rank) && cards.get(1).rank.equals(cards.get(3).rank) ||
                cards.get(2).rank.equals(cards.get(3).rank) && cards.get(2).rank.equals(cards.get(4).rank)) return true;
        return false;
    }

    public static boolean CheckTwoPair(List<Card> cards){
        if(cards.get(0).rank.equals(cards.get(1).rank) && cards.get(2).rank.equals(cards.get(3).rank) ||
                cards.get(0).rank.equals(cards.get(1).rank) && cards.get(3).rank.equals(cards.get(4).rank) ||
                cards.get(1).rank.equals(cards.get(2).rank) && cards.get(3).rank.equals(cards.get(4).rank)) return true;
        return false;
    }

    public static boolean CheckPair(List<Card> cards){
        if((cards.get(0).rank.equals(cards.get(1).rank) ||
                cards.get(1).rank.equals(cards.get(2).rank) || cards.get(2).rank.equals(cards.get(3).rank) ||
                cards.get(3).rank.equals(cards.get(4).rank))) return true;
        return false;
    }

    public static int  CheckHouse(List<Card> cards){
        if(cards.get(0).rank.equals(cards.get(1).rank) && cards.get(0).rank.equals(cards.get(2).rank) && cards.get(3).rank.equals(cards.get(4).rank)) return cards.get(4).rank.value;
        else if (cards.get(0).rank.equals(cards.get(1).rank) && cards.get(2).rank.equals(cards.get(3).rank) && cards.get(2).rank.equals(cards.get(4).rank)) return cards.get(0).rank.value;
        return 0;
    }

    public static Hand CheckHand(List<Card> cards){
        if (CheckStraight(cards) && CheckFlush(cards)){
            if (HighestCard(cards) >= 140) return Hand.ROYAL_FLUSH;
            else return Hand.STRAIGHT_FLUSH;
        }
        else if (CheckFour(cards)){
            return Hand.FOUR_OF_A_KIND;
        }
        else if (CheckHouse(cards) > 0){
            return Hand.FULL_HOUSE;
        }
        else if (CheckFlush(cards)){
            return Hand.FLUSH;
        }
        else if(CheckStraight(cards)){
            return Hand.STRAIGHT;
        }
        else if(CheckThree(cards)){
            return Hand.THREE_OF_A_KIND;
        }
        else if (CheckTwoPair(cards)){
            return Hand.TWO_PAIR;
        }
        else if(CheckPair(cards)){
            return Hand.PAIR;
        }
        return Hand.HIGHEST_CARD;
    }
}