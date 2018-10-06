package com.poker;

public enum Card {

    TWO (2),
    THREE (3),
    FOUR (4),
    FIVE (5),
    SIX (6),
    SEVEN (7),
    EIGHT (8),
    NINE (9),
    TEN (10),
    JACK (11),
    QUEEN (12),
    KING (13),
    ACE (14);

    private int value;
    private Card(int value){
        this.value = value;
    }

    public int value(){
        return value;
    }

    public static Card stringToCard(String faceValue){

        switch(faceValue){
            case "T": return TEN;
            case "J": return JACK;
            case "Q": return QUEEN;
            case "K": return KING;
            case "A": return ACE;
        }

        int value = Integer.parseInt(faceValue);

        for(Card card : Card.values()){
            if(value == card.value){
                return card;
            }
        }
        return TEN;
    }
}
