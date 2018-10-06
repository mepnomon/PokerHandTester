package com.poker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankFactoryTest {

    RankFactory rankFactory;
    @BeforeEach
    void setUp() {
        rankFactory = new RankFactory();
    }

    @Test
    public void get_royal_flush(){
        String hand = "Th Jh Qh Kh Ah";
        assertEquals(Rank.ROYAL_FLUSH,rankFactory.getRank(hand));
    }

    @Test
    public void get_straight_flush_true(){
        String hand = "3s 4s 5s 6s 7s";
        assertEquals(Rank.STRAIGHT_FLUSH,rankFactory.getRank(hand));
    }

    @Test
    public void get_four_of_kind_with_tens(){
        String hand = "Td Tc Th Ts 4d";
        assertEquals(Rank.FOUR_OF_A_KIND,rankFactory.getRank(hand));
    }

    @Test
    public void get_four_of_kind_with_9s(){
        String hand = "9d 9c 9h 9s 4d";
        assertEquals(Rank.FOUR_OF_A_KIND,rankFactory.getRank(hand));
    }

    @Test
    void get_full_house() {
        String hand = "Jh Jc 7h 7d 7c";
        assertEquals(Rank.FULL_HOUSE,rankFactory.getRank(hand));
    }

    @Test
    void get_a_flush() {
        String hand = "2h 6h 9h Qh Kh";
        assertEquals(Rank.FLUSH,rankFactory.getRank(hand));
    }

    @Test
    void get_a_straight() {
        String hand = "3s 4h 5c 6d 7d";
        assertEquals(Rank.STRAIGHT,rankFactory.getRank(hand));
    }

    @Test
    void get_three_of_a_kind(){
        String hand = "9s 9h 9c 6d 2d";
        assertEquals(Rank.THREE_OF_A_KIND,rankFactory.getRank(hand));

    }

    @Test
    void get_one_pair(){
        String hand = "6c 6h 3c Qd Td";
        assertEquals(Rank.ONE_PAIR,rankFactory.getRank(hand));

    }

    @Test
    void get_two_pair() {
        String hand = "4s 4h Jc Jd 9d";
        assertEquals(Rank.TWO_PAIRS,rankFactory.getRank(hand));
    }

    @Test
    void get_straight_with_one_letters() {
        String hand = "6s 7h 8c 9d Td";
        assertEquals(Rank.STRAIGHT,rankFactory.getRank(hand));
    }

    @Test
    void straight_with_letters(){
        String hand = "7s 8c 9d Td Jd";
        assertEquals(Rank.STRAIGHT,rankFactory.getRank(hand));
    }

    @Test
    void straight_with_letters_q_boundary(){
        String hand = "8s 9c Td Jd Qd";
        assertEquals(Rank.STRAIGHT,rankFactory.getRank(hand));
    }

    @Test
    void straight_with_letters_k_boundary(){
        String hand = "9c Td Jd Qd Kh";
        assertEquals(Rank.STRAIGHT,rankFactory.getRank(hand));
    }

    @Test
    void test_high_card(){
        String hand = "As Kh 4c 10d 8d";
        assertEquals(Rank.HIGH_CARD,rankFactory.getRank(hand));
    }
}