package com.poker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.poker.PokerHand.Result;

/**
 * Unit test for simple App.
 */
public class PokerHandTest {
	
	@Test (expected = IllegalArgumentException.class)
	public void newHandTestNull() {
		new PokerHand(null);
	}
	
	@Test
	public void highCardWin() {
		PokerHand hand1 = new PokerHand("As 2h 5c Jd Td");
		PokerHand hand2 = new PokerHand("Kc 2s 5h Jh Tc");

		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}
}
