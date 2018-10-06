package com.poker;

import static java.lang.String.valueOf;

public class PokerHand {

	public enum Result {
		WIN,
		LOSS,
		TIE;
	}


	private RankFactory rankFactory;
	private String hand;

	public PokerHand(String hand, RankFactory rankFactory) {

		this.rankFactory = rankFactory;
		this.hand = hand;
	}

	public Result compareWith(PokerHand opponentsHand) {

		Rank opponentsRank = opponentsHand.getRank();

		if(getRank().value() < opponentsHand.getRank().value()){
			return Result.LOSS;
		}

		if(getRank().value() > opponentsHand.getRank().value()){
			return Result.WIN;
		}
		return compareHighCard(opponentsHand, opponentsRank);
	}

	private Result compareHighCard(PokerHand opponentsHand, Rank opponentsRank) {

			if (getHighestCard().value() < opponentsHand.getHighestCard().value()) {
				return Result.LOSS;
			}

			if (getHighestCard().value() > opponentsHand.getHighestCard().value()){
				return Result.WIN;
			}
		return Result.TIE;
	}

	public Card getHighestCard() {
		String[] splitHand = hand.split(" ");
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
}
