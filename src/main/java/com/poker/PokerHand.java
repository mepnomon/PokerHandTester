package com.poker;

import java.util.HashMap;
import java.util.Map;
import static java.lang.String.valueOf;

public class PokerHand {

	public enum Result {
		WIN,
		LOSS,
		TIE;
	}

	private String hand;
	private RankFactory rankFactory;

	public PokerHand(String hand) {

		this.rankFactory = new RankFactory();
		this.hand = hand;
	}

	public Result compareWith(PokerHand opponentsHand) {

		if(getRank() == Rank.TWO_PAIRS && opponentsHand.getRank() == Rank.TWO_PAIRS) {
			return getHighestTwoPairs(opponentsHand);
		}

		if(getRank() == Rank.THREE_OF_A_KIND && opponentsHand.getRank() == Rank.THREE_OF_A_KIND){
			return getHigherThreeOfAKind(opponentsHand);
		}
		if(getRank().value() < opponentsHand.getRank().value()){
			return Result.LOSS;
		}

		if(getRank().value() > opponentsHand.getRank().value()){
			return Result.WIN;
		}


		return compareHighCard(opponentsHand);
	}

	private Result getHighestTwoPairs(PokerHand opponentsHand){
		final int OCCURRENCE = 2;
		String[] opponentsCards = cardStringToArray(opponentsHand.getHand());
		String[] myCards = cardStringToArray(getHand());
		HashMap<String, Integer> cardMap = getStringIntegerHashMap(myCards);
		HashMap<String, Integer> oppopentCardMap = getStringIntegerHashMap(opponentsCards);
		Card[] myHighestCard = extractHighestCardsFromMap(cardMap);
		Card[] opponentHighestCard = extractHighestCardsFromMap(oppopentCardMap);
		int mySum = 0;
		int opponentSum = 0;
		for(int i = 0; i < myHighestCard.length; i++){
			mySum += myHighestCard[i].value();
			opponentSum += opponentHighestCard[i].value();
		}

		if (mySum > opponentSum) {
			return Result.WIN;
		}

		if (mySum < opponentSum) {
			return Result.LOSS;
		}

		return Result.TIE;
	}
	private Result getHigherThreeOfAKind(PokerHand opponentsHand){

		final int OCCURRENCE = 3;
		String[] opponentsCards = cardStringToArray(opponentsHand.getHand());
		String[] myCards = cardStringToArray(getHand());
		HashMap<String, Integer> cardMap = getStringIntegerHashMap(myCards);
		HashMap<String, Integer> oppopentCardMap = getStringIntegerHashMap(opponentsCards);
		Card myHighestCard = extractHighestCardFromMap(cardMap,OCCURRENCE);
		Card opponentHighestCard = extractHighestCardFromMap(oppopentCardMap, OCCURRENCE);

		if(myHighestCard.value() < opponentHighestCard.value()){
			return Result.LOSS;
		}

		if(myHighestCard.value() > opponentHighestCard.value()){
			return Result.WIN;
		}

		return Result.TIE;
	}



	private String[] cardStringToArray(String hand){
		return hand.split(" ");
	}

	private Card[] extractHighestCardsFromMap(HashMap<String, Integer> cards){
		Card[] highestCards = new Card[2];
		int count = 0;
		for (Map.Entry<String, Integer> stringIntegerEntry : cards.entrySet()) {
			if (stringIntegerEntry.getValue() == 2 ) {
				highestCards[count] = Card.stringToCard(valueOf(stringIntegerEntry.getKey().charAt(0)));
				count++;
			}
		}
		return highestCards;
	}

	private Card extractHighestCardFromMap(HashMap<String, Integer> cards, int occurrence){
		Card highestCard = null;
		for (Map.Entry<String, Integer> stringIntegerEntry : cards.entrySet()) {
			if (stringIntegerEntry.getValue() == occurrence ) {
				highestCard = Card.stringToCard(valueOf(stringIntegerEntry.getKey().charAt(0)));
			}
		}
		return highestCard;
	}

	private Result compareHighCard(PokerHand opponentsHand) {

			if (getHighestCard().value() < opponentsHand.getHighestCard().value()) {
				return Result.LOSS;
			}

			if (getHighestCard().value() > opponentsHand.getHighestCard().value()){
				return Result.WIN;
			}
		return Result.TIE;
	}

	public Card getHighestCard() {
		String[] splitHand = cardStringToArray(getHand());
		Card highestCard = Card.stringToCard(valueOf(splitHand[0].charAt(0)));

		for (int i = 1; i < splitHand.length; i++) {
			Card card =  Card.stringToCard(valueOf(splitHand[i].charAt(0)));
			if (highestCard.value() < card.value()) {
				highestCard = card;
			}
		}
		return highestCard;
	}

	public String getHand(){
		return hand;
	}


	public Rank getRank(){

		return rankFactory.getRank(hand);
	}

	private HashMap<String, Integer> getStringIntegerHashMap(String[] splitHand) {
		HashMap<String, Integer> cards = new HashMap<>();

		for (String s : splitHand) {
			if(!cards.containsKey(valueOf(s.charAt(0)))){
				cards.put(valueOf(s.charAt(0)),1);
			} else {
				Integer value = cards.get(valueOf((s.charAt(0))));
				cards.put(valueOf(s.charAt(0)),value+1);
			}
		}
		return cards;
	}
}
