package com.poker;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.poker.PokerHand.Result;
import org.mockito.Mockito;

/**
 * Unit test for simple App.
 */
public class PokerHandTest {

	RankFactory rankFactory;
	@Before
	public void setupTest(){
		rankFactory = Mockito.mock(RankFactory.class);
	}

	@Test (expected = IllegalArgumentException.class)
	public void newHandTestNull() {
		new PokerHand(null, rankFactory);
	}
	
	@Test
	public void highCardWin() {
		PokerHand hand1 = new PokerHand("As 2h 5c Jd Td", rankFactory);
		PokerHand hand2 = new PokerHand("Kc 2s 5h Jh Tc", rankFactory);

		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}

	@Test
	public void some_test(){

	}
}
