/**
 * Card Class represents a playing card with a suite and a value.
 */
public class Card {
    private CardSuite suite;
    private CardValue value;

    public Card(CardSuite suite, CardValue value) {
       this.suite = suite;
       this.value = value; 
    }

    public CardSuite getSuite() {
        return this.suite;
    }

    public CardValue getValue() {
        return this.value;
    }

    public void setSuite(CardSuite suite) {
        this.suite = suite;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }
}
