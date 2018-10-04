package com.poker;

public class PokerHand {

	private final int NUMBER_OF_SUITS = 5;
	StringBuilder rankStore;

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
		rankStore = new StringBuilder();
	}

	public Result compareWith(PokerHand hand) {
		extractRank();
		 return Result.TIE;
	}

	private void extractRank(){
		rankStore.append(hand.charAt(0));
		rankStore.append(hand.charAt(3));
		rankStore.append(hand.charAt(6));
		rankStore.append(hand.charAt(9));
		rankStore.append(hand.charAt(12));

		System.out.println("extracted " + rankStore);
	}

	private void evaluateRank (String hand){

	}

}
