package com.poker;

public class PokerHand {
	
	public enum Result {
		WIN,
		LOSS,
		TIE;
	}

	public PokerHand(String hand) {}

	public Result compareWith(PokerHand hand) {
		/*
		 * Your code here
		 */
		 return Result.TIE;
	}
}
