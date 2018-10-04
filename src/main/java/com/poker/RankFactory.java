package com.poker;

import java.util.HashMap;
import java.util.Map;

public class RankFactory {

    public Rank getRank(String hand){

        String[] splitHand = hand.split(" ");
        HashMap<Character, Integer> cards = getCharacterIntegerHashMap(splitHand);

        if(isStraightFlush(splitHand)){
            return Rank.STRAIGHT_FLUSH;
        }

        if(isFourOfAKind(cards)){
            return Rank.FOUR_OF_A_KIND;
        }

        if(isFullHouse(cards)){
            return Rank.FULL_HOUSE;
        }

        if(isRoyalFlush(splitHand)){
            return Rank.ROYAL_FLIUSH;
        }

        if(isStraight(splitHand)){
            return Rank.STRAIGHT;
        }

        if(isFlush(splitHand)){
            return Rank.FLUSH;
        }

        if(isThreeOfAKind(cards)){
            return Rank.THREE_OF_A_KIND;
        }

        if(isTwoPairs(cards)){
            return Rank.TWO_PAIRS;
        }

        if(isPair(cards)){
            return Rank.ONE_PAIR;
        }
        return Rank.HIGH_CARD;
    }

    private boolean isTwoPairs(HashMap<Character, Integer> cards) {
        int pairCount = 0;
        for (Map.Entry<Character, Integer> characterIntegerEntry : cards.entrySet()) {
            if(characterIntegerEntry.getValue() == 2){
                ++pairCount;
            }
        }
        if(pairCount != 2) {
            return false;
        }

        return true;
    }

    private boolean isPair(HashMap<Character, Integer> cards) {

        for (Map.Entry<Character, Integer> characterIntegerEntry : cards.entrySet()) {
            if(characterIntegerEntry.getValue() == 2){
                return true;
            }
        }
        return false;
    }

    private boolean isThreeOfAKind(HashMap<Character, Integer> cards) {

        boolean hasThree = false;
        for (Map.Entry<Character, Integer> characterIntegerEntry : cards.entrySet()) {

            if(characterIntegerEntry.getValue() == 3){
                hasThree = true;
            }
        }
        return hasThree;
    }

    private boolean isStraight(String[] splitHand) {
        for (int i = 1; i < splitHand.length; i++) {

            if((splitHand[i-1].charAt(0)+1) != (splitHand[i].charAt(0))){
                return false;
            }
        }
        return true;
    }

    private boolean isRoyalFlush(String[] splitHand) {
        final String[] ROYAL_FLUSH = {"T","J","Q","K","A"};
        if(!isFlush(splitHand)){
            return false;
        }
        for (int i = 0; i < splitHand.length; i++) {
            if(splitHand[i].charAt(0) != ROYAL_FLUSH[i].charAt(0)){
                return false;
            }

        }
        return true;
    }

    private boolean isFlush(String[] splitHand) {
        for (int i = 1; i < splitHand.length; i++) {
            if(splitHand[i].charAt(1) != splitHand[i-1].charAt(1)){
                return false;
            }
        }
        return true;
    }
    
    private boolean isStraightFlush(String[] splitHand) {
        return (isFlush(splitHand) && isStraight(splitHand));
    }

    private boolean isFullHouse(HashMap<Character, Integer> cards){

        boolean hasThree= false;

        for (Map.Entry<Character, Integer> characterIntegerEntry : cards.entrySet()) {

            if(characterIntegerEntry.getValue() == 3){
                hasThree = true;
            }
        }
        return isPair(cards) && hasThree; //&& is(hasThree && hasTwo);
    }

    private boolean isFourOfAKind(HashMap<Character, Integer> cards){

        for (Map.Entry<Character, Integer> characterIntegerEntry : cards.entrySet()) {
            if(characterIntegerEntry.getValue() == 4){
                return true;
            }
        }
        return false;
    }

    private HashMap<Character, Integer> getCharacterIntegerHashMap(String[] splitHand) {
        HashMap<Character, Integer> cards = new HashMap<>();

        for (String s : splitHand) {
            if(!cards.containsKey(s.charAt(0))){
                cards.put(s.charAt(0),1);
            } else {
                Integer value = cards.get(s.charAt(0));
                cards.put(s.charAt(0),value+1);
            }
        }
        return cards;
    }
}
