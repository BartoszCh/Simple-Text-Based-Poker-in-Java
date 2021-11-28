
package pl.edu.agh.kis.pz1;
import junit.framework.TestCase;
import org.junit.Test;
import pl.edu.agh.kis.pz1.Card;
import pl.edu.agh.kis.pz1.Deck;
import pl.edu.agh.kis.pz1.Rank;
import pl.edu.agh.kis.pz1.Suit;

import java.util.List;

public class DeckTest extends TestCase {

    @Test
    public void testFactory() {
        List<Card> testCards = Deck.factory();
        Card testCard = new Card(Rank.ACE, Suit.DIAMONDS);
        assertEquals(testCards.get(0).toString(), testCard.toString());
    }

    @Test
    public void testShuffle() {
        List<Card> checker = Deck.factory();
        List<Card> testCards = Deck.factory();
        Deck testDeck = new Deck(testCards);
        List<Card> testShuffle = testDeck.shuffle();
        assertNotSame(checker.get(0), testShuffle.get(0));
    }
}