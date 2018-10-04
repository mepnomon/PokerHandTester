package com.poker;

public enum Rank {

    ROYAL_FLIUSH(10),
    STRAIGHT_FLUSH(9),
    FOUR_OF_A_KIND(8),
    FULL_HOUSE(7),
    FLUSH(6),
    STRAIGHT(5),
    THREE_OF_A_KIND(4),
    TWO_PAIRS(3),
    ONE_PAIR(2),
    HIGH_CARD(1);


    private int rank;

    private Rank(int rank) {
        this.rank = rank;
    }
}
