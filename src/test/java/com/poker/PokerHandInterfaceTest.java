package com.poker;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class PokerHandInterfaceTest {

    PokerHandInterface pokerHandInterface;
    CardValidator cardValidator;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        cardValidator = mock(CardValidator.class);
        pokerHandInterface = new PokerHandInterface(cardValidator);
    }

    @Test
    public void submit_six_cards(){

        String cardHand= "AA BB CC DD EE FF";
        when(cardValidator.validateCardFace(cardHand)).thenReturn(true);
        assertFalse(pokerHandInterface.validateUserInput(cardHand));
    }

    @Test
    public void submit_four_cards(){

        String cardHand= "AA BB CC DD";
        when(cardValidator.validateCardFace(cardHand)).thenReturn(true);
        assertFalse(pokerHandInterface.validateUserInput(cardHand));
    }

    @Test
    public void submit_five_cards(){

        String cardHand= "AA BB CC DD FF";
        when(cardValidator.validateCardFace(cardHand)).thenReturn(true);
        assertTrue(pokerHandInterface.validateUserInput(cardHand));
    }

    @Test
    public void submit_empty_hand(){
        String cardHand = "";
        when(cardValidator.validateCardFace(cardHand)).thenReturn(true);
        assertFalse(pokerHandInterface.validateUserInput(cardHand));
    }

}