package com.poker;

import java.util.HashMap;
import java.util.Map;

/**
 * RankFactory.
 * A factory determining Poker Hand ranks, based on supplied cards.
 * @author D. ressler
 */
public class RankFactory {

    public Rank getRank(String hand){

        String[] splitHand = hand.split(" ");
        HashMap<Character, Integer> cards = getCharacterIntegerHashMap(splitHand);

        if (isRoyalFlush(splitHand)) {
            return Rank.ROYAL_FLUSH;
        }

        if (isStraightFlush(splitHand)) {
            return Rank.STRAIGHT_FLUSH;
        }

        if (isFourOfAKind(cards)) {
            return Rank.FOUR_OF_A_KIND;
        }

        if (isFullHouse(cards)) {
            return Rank.FULL_HOUSE;
        }

        if (isStraight(splitHand)) {
            return Rank.STRAIGHT;
        }

        if (isFlush(splitHand)) {
            return Rank.FLUSH;
        }

        if (isThreeOfAKind(cards)) {
            return Rank.THREE_OF_A_KIND;
        }

        if (isTwoPairs(cards)) {
            return Rank.TWO_PAIRS;
        }

        if (isPair(cards)) {
            return Rank.ONE_PAIR;
        }

        return Rank.HIGH_CARD;
    }

    private boolean isTwoPairs(HashMap<Character, Integer> cards) {
        int pairCount = 0;
        for (Map.Entry<Character, Integer> characterIntegerEntry : cards.entrySet()) {
            if (characterIntegerEntry.getValue() == 2){
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
            if (characterIntegerEntry.getValue() == 2) {
                return true;
            }
        }
        return false;
    }

    private boolean isThreeOfAKind(HashMap<Character, Integer> cards) {
        for (Map.Entry<Character, Integer> characterIntegerEntry : cards.entrySet()) {
            if (characterIntegerEntry.getValue() == 3 ) {
                return true;
            }
        }
        return false;
    }

    private boolean isStraight(String[] splitHand) {
        for (int i = 1; i < splitHand.length; i++) {
            if (next(splitHand[i-1].charAt(0)) != (splitHand[i].charAt(0))) {
                return false;
            }
        }
        return true;
    }

    private boolean isRoyalFlush(String[] splitHand) {
        if (!isStraightFlush(splitHand)) {
            return false;
        }
        if(splitHand[4].charAt(0) == 'A'){
            return true;
        }
        return false;
    }

    private boolean isFlush(String[] splitHand) {
        for (int i = 1; i < splitHand.length; i++) {
            if (splitHand[i].charAt(1) != splitHand[i-1].charAt(1)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isStraightFlush(String[] splitHand) {
        return (isFlush(splitHand) && isStraight(splitHand));
    }

    private boolean isFullHouse(HashMap<Character, Integer> cards){
        return isPair(cards) && isThreeOfAKind(cards);
    }

    private boolean isFourOfAKind(HashMap<Character, Integer> cards){
        for (Map.Entry<Character, Integer> characterIntegerEntry : cards.entrySet()) {
            if (characterIntegerEntry.getValue() == 4) {
                return true;
            }
        }
        return false;
    }

    private HashMap<Character, Integer> getCharacterIntegerHashMap(String[] splitHand) {
        HashMap<Character, Integer> cards = new HashMap<>();
        for (String s : splitHand) {
            if (!cards.containsKey(s.charAt(0))) {
                cards.put(s.charAt(0),1);
            } else {
                Integer value = cards.get(s.charAt(0));
                cards.put(s.charAt(0),value+1);
            }
        }
        return cards;
    }

    private char next(char face){
        switch(face){
            case '9': return 'T';
            case 'T': return 'J';
            case 'J': return 'Q';
            case 'Q': return 'K';
            case 'K': return 'A';
        }
        return (char) (face+1);
    }
}
