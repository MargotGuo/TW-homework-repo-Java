package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardMachine {
  public List<Card> drawCard(int number) {
    List<Card> allCards = getAllCards();
    List<Card> outputCards = new ArrayList<>();
    for(int i = 0; i < number; i++) {
      int index = getRandomIndex(allCards.size());
      outputCards.add(allCards.get(index));
      allCards.remove(index);
    }
    return outputCards;
  }

  private List<Card> getAllCards() {
    List<Card> allCards = new ArrayList<>();
    for(Suit suit : Suit.values()) {
      for (int cardPoint = 1; cardPoint < 14; cardPoint++) {
        allCards.add(new Card(cardPoint, suit.getType()));
      }
    }
    return allCards;
  }

  private int getRandomIndex(int numberOfRestCard) {
    Random random = new Random();
    return random.nextInt(numberOfRestCard);
  }
}
