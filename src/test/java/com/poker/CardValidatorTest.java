package com.poker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardValidatorTest {

    CardValidator cardValidator;
    @BeforeEach
    void setUp() {
        cardValidator = new CardValidator();
    }

    @Test
    public void test_invalid_card(){

        String cardFace = "1A";
        Assertions.assertFalse(cardValidator.validateCardFace(cardFace));
    }
}