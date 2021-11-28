
package pl.edu.agh.kis.pz1;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.kis.pz1.*;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;

public class PlayerHandTest extends TestCase {

    @Test
    public void testCheckFour() {
        Card AceS = new Card(Rank.ACE, Suit.SPADES);
        Card AceH = new Card(Rank.ACE, Suit.HEARTS);
        Card AceC = new Card(Rank.ACE, Suit.CLUBS);
        Card AceD = new Card(Rank.ACE, Suit.DIAMONDS);
        Card TenD = new Card(Rank.TEN, Suit.DIAMONDS);
        List<Card> testFour = new LinkedList<>(Arrays.asList(AceS, AceH, AceC, AceD, TenD));
        assertTrue(PlayerHand.CheckFour(testFour));
    }

    @Test
    public void testCheckFour2() {
        Card AceS = new Card(Rank.ACE, Suit.SPADES);
        Card AceH = new Card(Rank.ACE, Suit.HEARTS);
        Card AceC = new Card(Rank.ACE, Suit.CLUBS);
        Card AceD = new Card(Rank.ACE, Suit.DIAMONDS);
        Card TenD = new Card(Rank.TEN, Suit.DIAMONDS);
        List<Card> testFour2 = new LinkedList<>(Arrays.asList(TenD, AceS, AceH, AceC, AceD));
        assertTrue(PlayerHand.CheckFour(testFour2));
    }
    @Test
    public void testCheckFour3() {
        Card AceS = new Card(Rank.ACE, Suit.SPADES);
        Card AceH = new Card(Rank.ACE, Suit.HEARTS);
        Card AceC = new Card(Rank.ACE, Suit.CLUBS);
        Card AceD = new Card(Rank.SIX, Suit.DIAMONDS);
        Card TenD = new Card(Rank.TEN, Suit.DIAMONDS);
        List<Card> testFour3 = new LinkedList<>(Arrays.asList(TenD, AceS, AceH, AceC, AceD));
        assertFalse(PlayerHand.CheckFour(testFour3));
    }

    @Test
    public void testCheckStraight() {
        Card Card1 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card2 = new Card(Rank.SIX, Suit.HEARTS);
        Card Card3 = new Card(Rank.SEVEN, Suit.CLUBS);
        Card Card4 = new Card(Rank.EIGHT, Suit.DIAMONDS);
        Card Card5 = new Card(Rank.NINE, Suit.DIAMONDS);
        List<Card> testStraight = new LinkedList<>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertTrue(PlayerHand.CheckStraight(testStraight));
    }
    @Test
    public void testCheckFlush() {
        Card Card1 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card2 = new Card(Rank.QUEEN, Suit.SPADES);
        Card Card3 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card4 = new Card(Rank.ACE, Suit.SPADES);
        Card Card5 = new Card(Rank.NINE, Suit.SPADES);
        List<Card> testFlush = new LinkedList<>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertTrue(PlayerHand.CheckFlush(testFlush));
    }

    @Test
    public void testCheckFlush2() {
        Card Card1 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card2 = new Card(Rank.QUEEN, Suit.SPADES);
        Card Card3 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card4 = new Card(Rank.ACE, Suit.SPADES);
        Card Card5 = new Card(Rank.NINE, Suit.CLUBS);
        List<Card> testFlush = new LinkedList<>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertFalse(PlayerHand.CheckFlush(testFlush));
    }

    @Test
    public void testHighestCard() {
        Card Card1 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card2 = new Card(Rank.QUEEN, Suit.SPADES);
        Card Card3 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card4 = new Card(Rank.ACE, Suit.SPADES);
        Card Card5 = new Card(Rank.NINE, Suit.SPADES);
        List<Card> testHighest = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertEquals(PlayerHand.HighestCard(testHighest), 144);
    }

    @Test
    public void testCheckThree() {
        Card Card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card4 = new Card(Rank.SIX, Suit.SPADES);
        Card Card5 = new Card(Rank.SEVEN, Suit.SPADES);
        List<Card> testThree = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertTrue(PlayerHand.CheckThree(testThree));
    }
    @Test
    public void testCheckThree3() {
        Card Card1 = new Card(Rank.FOUR, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card4 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card5 = new Card(Rank.SIX, Suit.SPADES);
        List<Card> testThree = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertTrue(PlayerHand.CheckThree(testThree));
    }
    @Test
    public void testCheckThree4() {
        Card Card1 = new Card(Rank.THREE, Suit.HEARTS);
        Card Card2 = new Card(Rank.FOUR, Suit.CLUBS);
        Card Card3 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card4 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card5 = new Card(Rank.FIVE, Suit.CLUBS);
        List<Card> testThree = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertTrue(PlayerHand.CheckThree(testThree));
    }
    @Test
    public void testCheckThree2() {
        Card Card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card2 = new Card(Rank.SIX, Suit.CLUBS);
        Card Card3 = new Card(Rank.NINE, Suit.SPADES);
        Card Card4 = new Card(Rank.QUEEN, Suit.SPADES);
        Card Card5 = new Card(Rank.ACE, Suit.SPADES);
        List<Card> testThree = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertFalse(PlayerHand.CheckThree(testThree));
    }

    @Test
    public void testCheckTwoPair() {
        Card Card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.SIX, Suit.SPADES);
        Card Card4 = new Card(Rank.EIGHT, Suit.SPADES);
        Card Card5 = new Card(Rank.EIGHT, Suit.CLUBS);
        List<Card> testTwoPair = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertTrue(PlayerHand.CheckTwoPair(testTwoPair));
    }
    @Test
    public void testCheckTwoPair2() {
        Card Card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.SIX, Suit.SPADES);
        Card Card4 = new Card(Rank.SIX, Suit.HEARTS);
        Card Card5 = new Card(Rank.EIGHT, Suit.CLUBS);
        List<Card> testTwoPair = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertTrue(PlayerHand.CheckTwoPair(testTwoPair));
    }
    @Test
    public void testCheckTwoPair3() {
        Card Card1 = new Card(Rank.FOUR, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card4 = new Card(Rank.EIGHT, Suit.SPADES);
        Card Card5 = new Card(Rank.EIGHT, Suit.CLUBS);
        List<Card> testTwoPair = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertTrue(PlayerHand.CheckTwoPair(testTwoPair));
    }
    @Test
    public void testCheckTwoPair4() {
        Card Card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.SIX, Suit.SPADES);
        Card Card4 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card5 = new Card(Rank.EIGHT, Suit.CLUBS);
        List<Card> testTwoPair = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertFalse(PlayerHand.CheckTwoPair(testTwoPair));
    }

    @Test
    public void testCheckPair() {
        Card Card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card2 = new Card(Rank.SIX, Suit.CLUBS);
        Card Card3 = new Card(Rank.SIX, Suit.SPADES);
        Card Card4 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card5 = new Card(Rank.EIGHT, Suit.CLUBS);
        List<Card> testPair = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertTrue(PlayerHand.CheckPair(testPair));
    }
    @Test
    public void testCheckPair2() {
        Card Card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card2 = new Card(Rank.SIX, Suit.CLUBS);
        Card Card3 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card4 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card5 = new Card(Rank.EIGHT, Suit.CLUBS);
        List<Card> testPair = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertTrue(PlayerHand.CheckPair(testPair));
    }
    @Test
    public void testCheckPair3() {
        Card Card1 = new Card(Rank.FOUR, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.SIX, Suit.SPADES);
        Card Card4 = new Card(Rank.EIGHT, Suit.SPADES);
        Card Card5 = new Card(Rank.EIGHT, Suit.CLUBS);
        List<Card> testPair = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertTrue(PlayerHand.CheckPair(testPair));
    }
    @Test
    public void testCheckPair4() {
        Card Card1 = new Card(Rank.FOUR, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.SIX, Suit.SPADES);
        Card Card4 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card5 = new Card(Rank.EIGHT, Suit.CLUBS);
        List<Card> testPair = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertFalse(PlayerHand.CheckPair(testPair));
    }
    @Test
    public void testCheckPair5() {
        Card Card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.SIX, Suit.SPADES);
        Card Card4 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card5 = new Card(Rank.EIGHT, Suit.CLUBS);
        List<Card> testPair = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertTrue(PlayerHand.CheckPair(testPair));
    }

    @Test
    public void testCheckHouse2() {
        Card Card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card4 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card5 = new Card(Rank.SEVEN, Suit.CLUBS);
        List<Card> testHouse = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertTrue(PlayerHand.CheckHouse(testHouse) > 0);
    }
    @Test
    public void testCheckHouse3() {
        Card Card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.SIX, Suit.SPADES);
        Card Card4 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card5 = new Card(Rank.EIGHT, Suit.CLUBS);
        List<Card> testHouse = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertFalse(PlayerHand.CheckHouse(testHouse) > 0);
    }
    @Test
    public void testCheckHouse() {
        Card Card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card4 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card5 = new Card(Rank.SEVEN, Suit.CLUBS);
        List<Card> testHouse = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertTrue(PlayerHand.CheckHouse(testHouse) > 0);
    }
    @Test
    public void testCheckHand() {
        Card Card1 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card2 = new Card(Rank.QUEEN, Suit.SPADES);
        Card Card3 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card4 = new Card(Rank.ACE, Suit.SPADES);
        Card Card5 = new Card(Rank.NINE, Suit.SPADES);
        List<Card> testHand = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertEquals(PlayerHand.CheckHand(testHand), Hand.FLUSH);
    }
    @Test
    public void testCheckHand2() {
        Card Card1 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card4 = new Card(Rank.ACE, Suit.SPADES);
        Card Card5 = new Card(Rank.NINE, Suit.SPADES);
        List<Card> testHand = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertEquals(PlayerHand.CheckHand(testHand), Hand.PAIR);
    }
    @Test
    public void testCheckHand3() {
        Card Card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card4 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card5 = new Card(Rank.SEVEN, Suit.CLUBS);
        List<Card> testHand = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertEquals(PlayerHand.CheckHand(testHand), Hand.FULL_HOUSE);
    }
    @Test
    public void testCheckHand4() {
        Card Card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.SIX, Suit.SPADES);
        Card Card4 = new Card(Rank.SEVEN, Suit.SPADES);
        Card Card5 = new Card(Rank.SEVEN, Suit.CLUBS);
        List<Card> testHand = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertEquals(PlayerHand.CheckHand(testHand), Hand.TWO_PAIR);
    }
    @Test
    public void testCheckHand5() {
        Card Card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card Card2 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card3 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card4 = new Card(Rank.SIX, Suit.SPADES);
        Card Card5 = new Card(Rank.SEVEN, Suit.SPADES);
        List<Card> testHand = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertEquals(PlayerHand.CheckHand(testHand), Hand.THREE_OF_A_KIND);
    }
    @Test
    public void testCheckHand6() {
        Card Card1 = new Card(Rank.ACE, Suit.SPADES);
        Card Card2 = new Card(Rank.ACE, Suit.HEARTS);
        Card Card3 = new Card(Rank.ACE, Suit.CLUBS);
        Card Card4 = new Card(Rank.ACE, Suit.DIAMONDS);
        Card Card5 = new Card(Rank.TEN, Suit.DIAMONDS);
        List<Card> testHand = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertEquals(PlayerHand.CheckHand(testHand), Hand.FOUR_OF_A_KIND);
    }

    @Test
    public void testCheckHand7() {
        Card Card1 = new Card(Rank.TEN, Suit.DIAMONDS);
        Card Card2 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card Card3 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card Card4 = new Card(Rank.KING, Suit.DIAMONDS);
        Card Card5 = new Card(Rank.ACE, Suit.DIAMONDS);
        List<Card> testHand = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertEquals(PlayerHand.CheckHand(testHand), Hand.ROYAL_FLUSH);
    }

    @Test
    public void testCheckHand8() {
        Card Card1 = new Card(Rank.THREE, Suit.DIAMONDS);
        Card Card2 = new Card(Rank.FOUR, Suit.DIAMONDS);
        Card Card3 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card Card4 = new Card(Rank.SIX, Suit.DIAMONDS);
        Card Card5 = new Card(Rank.SEVEN, Suit.DIAMONDS);
        List<Card> testHand = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertEquals(PlayerHand.CheckHand(testHand), Hand.STRAIGHT_FLUSH);
    }
    @Test
    public void testCheckHand10() {
        Card Card1 = new Card(Rank.THREE, Suit.DIAMONDS);
        Card Card2 = new Card(Rank.FOUR, Suit.DIAMONDS);
        Card Card3 = new Card(Rank.FIVE, Suit.CLUBS);
        Card Card4 = new Card(Rank.SIX, Suit.DIAMONDS);
        Card Card5 = new Card(Rank.SEVEN, Suit.HEARTS);
        List<Card> testHand = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertEquals(PlayerHand.CheckHand(testHand), Hand.STRAIGHT);
    }
    @Test
    public void testCheckHand9() {
        Card Card1 = new Card(Rank.THREE, Suit.DIAMONDS);
        Card Card2 = new Card(Rank.FOUR, Suit.CLUBS);
        Card Card3 = new Card(Rank.FIVE, Suit.SPADES);
        Card Card4 = new Card(Rank.NINE, Suit.DIAMONDS);
        Card Card5 = new Card(Rank.KING, Suit.CLUBS);
        List<Card> testHand = new LinkedList<Card>(Arrays.asList(Card1, Card2, Card3, Card4, Card5));
        assertEquals(PlayerHand.CheckHand(testHand), Hand.HIGHEST_CARD);
    }
}