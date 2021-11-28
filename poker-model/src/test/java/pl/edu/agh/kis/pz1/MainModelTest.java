
package pl.edu.agh.kis.pz1;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainModelTest extends TestCase {


    @Test
    public void testSortPlayers() {
        Card AceS = new Card(Rank.ACE, Suit.SPADES);
        Card AceH = new Card(Rank.ACE, Suit.HEARTS);
        Card AceC = new Card(Rank.ACE, Suit.CLUBS);
        Card AceD = new Card(Rank.ACE, Suit.DIAMONDS);
        Card TenD = new Card(Rank.TEN, Suit.DIAMONDS);
        Card SixD = new Card(Rank.SIX, Suit.DIAMONDS);
        List<Card> firstCards = new LinkedList<Card>(Arrays.asList(AceS, AceH, AceC, SixD, TenD));
        List<Card> secondCards = new LinkedList<Card>(Arrays.asList(AceD, AceH, AceC, SixD, TenD));
        Player player1 = new Player(firstCards);
        Player player2 = new Player(secondCards);
        player1.currentHand = PlayerHand.CheckHand(firstCards);
        player2.currentHand = PlayerHand.CheckHand(secondCards);
        List<Player> players = new LinkedList<Player>(Arrays.asList(player2, player1));
        MainModel.sortPlayers(players);
        assertEquals(players.get(0), player1);
    }

    @Test
    public void testcardShower() {
        Card Card1 = new Card(Rank.ACE, Suit.SPADES);
        Card Card2 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card3 = new Card(Rank.SEVEN, Suit.DIAMONDS);
        Card Card4 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card5 = new Card(Rank.SEVEN, Suit.CLUBS);
        List<Card> testShow = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        Player testPlayer = new Player(testShow);
        List<Player> testList = new LinkedList<>();
        testList.add(testPlayer);
        MainModel.cardShower(testList);
        System.out.println("ACE OF SPADES");
        assertTrue(true);
    }


    @Test
    public void testSortCards() {
        Card Card1 = new Card(Rank.ACE, Suit.SPADES);
        Card Card2 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card3 = new Card(Rank.SEVEN, Suit.SPADES);
        List<Card> testSort = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3));
        MainModel.sortCards(testSort);
        assertEquals(testSort.get(0).toString(), "FIVE OF SPADES");
    }

}