package com.poker;

public class PokerHandInterface {
    final int ALLOWED_NUMBER_OF_CARDS = 10;
    CardValidator cardValidator;

    public PokerHandInterface(CardValidator cardValidator) {

        this.cardValidator = cardValidator;
    }

    public boolean validateUserInput(String cardHand){

        if (cardHand.isEmpty() || !validateNumberOfCards(cardHand) || !validateHand(cardHand)){
            return false;
        }
        return true;
    }

    private boolean validateNumberOfCards(String cardHand){

        String[] splitHands = splitCardHand(cardHand);
        int charCount = 0;
        for (String splitHand : splitHands) {
            charCount += splitHand.length();
        }
        return charCount == ALLOWED_NUMBER_OF_CARDS;
    }

    private String[] splitCardHand(String cardHand){
        return cardHand.split(" ");
    }

    private boolean validateHand(String cardHand){

        return cardValidator.validateCardFace(cardHand);
    }
}
