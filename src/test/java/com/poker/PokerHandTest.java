package com.poker;

import com.poker.PokerHand.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Unit test for simple App.
 */
public class PokerHandTest {

	RankFactory rankFactory;
	@BeforeEach
	public void setupTest(){
		rankFactory = new RankFactory();
	}

	@Test //(expected = IllegalArgumentException.class)
	public void new_hand_test_null() {
		new PokerHand(null, rankFactory);
	}
	
	@Test
	public void high_card_win() {
		String cards1 = "As 2h 5c Jd Td";
		String cards2 = "Kc 2s 5h Jh Tc";
		PokerHand hand1 = new PokerHand(cards1, rankFactory);
		PokerHand hand2 = new PokerHand(cards2, rankFactory);
		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}

	@Test
	public void get_highest_card_ace(){
		String cards1 = "As 2h 5c Jd Td";
		PokerHand hand1 = new PokerHand(cards1, rankFactory);
		assertEquals(Card.ACE, hand1.getHighestCard());
	}

	@Test
	public void royal_flush_win() {
		String royalFlush = "Th Jh Qh Kh Ah";
		String straightFlush = "3s 4s 5s 6s 7s";
		PokerHand hand1 = new PokerHand(royalFlush, rankFactory);
		PokerHand hand2 = new PokerHand(straightFlush, rankFactory);
		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}

	@Test
	public void royal_flush_tie(){
		String royalFlush = "Th Jh Qh Kh Ah";
		String straightFlush = "Th Jh Qh Kh Ah";
		PokerHand hand1 = new PokerHand(royalFlush, rankFactory);
		PokerHand hand2 = new PokerHand(straightFlush, rankFactory);
		assertEquals(Result.TIE, hand1.compareWith(hand2));
		assertEquals(Result.TIE, hand2.compareWith(hand1));
	}

	@Test
	public void straight_flush_higher_win(){
		String straightFlushLower  =  "3s 4s 5s 6s 7s";
		String straightFlushHigher =  "4s 5s 6s 7s 8s";
		PokerHand hand1 = new PokerHand(straightFlushLower, rankFactory);
		PokerHand hand2 = new PokerHand(straightFlushHigher, rankFactory);
		assertEquals(Result.LOSS, hand1.compareWith(hand2));
		assertEquals(Result.WIN, hand2.compareWith(hand1));
	}

	@Test
	public void four_of_a_kind_higher_win(){
		String fourOfAKindHigher  =  "10h 10s 10c 10d 7s";
		String fourOfAKindLower =  "9h 9s 9c 9d 8s";
		PokerHand hand1 = new PokerHand(fourOfAKindHigher, rankFactory);
		PokerHand hand2 = new PokerHand(fourOfAKindLower, rankFactory);
		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}

	@Test
	public void four_of_a_kind_wins(){
		String fourOfAKind  =  "10h 10s 10c 10d 7s";
		String threeOfAKind = "7h 7s 7c 9d 3s";
		PokerHand hand1 = new PokerHand(fourOfAKind, rankFactory);
		PokerHand hand2 = new PokerHand(threeOfAKind, rankFactory);
		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}

	@Test
	public void three_of_a_kind_wins(){
		String threeOfAKind  =  "Ah As Ac 10d 7s";
		String onePair = "7h 7s 5c 9d 3s";
		PokerHand hand1 = new PokerHand(threeOfAKind, rankFactory);
		PokerHand hand2 = new PokerHand(onePair, rankFactory);
		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}

	@Test
	public void two_pairs_wins(){
		String twoPairs = "7h 7s Ah As 3s";
		String onePair  = "3h 3s 7d Ac Td";
		PokerHand hand1 = new PokerHand(twoPairs, rankFactory);
		PokerHand hand2 = new PokerHand(onePair, rankFactory);
		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}
	// flush and straight
	@Test
	public void flush_wins(){
		String flush = "2h 6h 9h Qh Kh";
		String straight = "3d 4h 5s 6c 7d";
		PokerHand hand1 = new PokerHand(flush, rankFactory);
		PokerHand hand2 = new PokerHand(straight, rankFactory);
		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}

	@Test
	public void higher_flush_wins(){
		String higherFlush = "2h 6h 9h Qh Ah";
		String lowerFlush = "2d 5d 6d 8d Kd";
		PokerHand hand1 = new PokerHand(higherFlush, rankFactory);
		PokerHand hand2 = new PokerHand(lowerFlush, rankFactory);
		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}

	@Test
	public void straight_wins(){
		String straight = "3d 4h 5s 6c 7d";
		String highCard = "As 2h 5c Jd Td";
		PokerHand hand1 = new PokerHand(straight, rankFactory);
		PokerHand hand2 = new PokerHand(highCard, rankFactory);
		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}
}
