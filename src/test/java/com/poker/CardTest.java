package com.poker;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    @ParameterizedTest
    @CsvSource({"2,TWO","3,THREE","4,FOUR","5,FIVE","6,SIX","7,SEVEN","8,EIGHT","9,NINE"})
    public void number_to_card(String value, Card expectedResult){
        assertEquals(expectedResult, Card.stringToCard(value));
    }


    @ParameterizedTest
    @CsvSource({"T,TEN","J,JACK", "Q,QUEEN","K,KING", "A,ACE"})
    public void letter_to_card(String value, Card expectedResult){
        assertEquals(expectedResult, Card.stringToCard(value));
    }
}