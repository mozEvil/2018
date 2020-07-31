package clash.client;

import clash.items.Item;

import java.util.List;

/**
 * Created by Женя on 21.07.2017.
 */
public class Player {

    private final static int BATTLE_DECK_SIZE = 8;

    private String name;
    private int gold;
    private List<Item> deck;
    private Item[] battleDeck;

    public Player(Item[] battleDeck) {
        this.battleDeck = battleDeck;
    }

    public List<Item> getDeck() {
        return deck;
    }

    public void setDeck(List<Item> deck) {
        this.deck = deck;
    }

    public void addItem(Item item) {
        deck.add(item);
    }

    public Item[] getBattleDeck() {
        return battleDeck;
    }

    public void setBattleDeck(Item[] battleDeck) {
        this.battleDeck = battleDeck;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }


}
