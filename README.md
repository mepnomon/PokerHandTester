Poker Hand Tester:

About:
This program can be used to compare Poker Hands, following the Texas Hold 'em rules.

The PokerHand Class handles user input and takes the user's hand as a parameter as well as the opposing player's hand.
A  general assumption here is that users will NOT cheat and will only supply valid hands and cards (happy-path).
E.g. a user will not pass 5 Aces in as parameters.
Allowed cards include values: 2,3,4,5,6,7,8,9,T,J,Q,K
and suits: h(earts), d(iamonds), c(lubs), s(pades). THese will need to be supplied as a string to the PokerHand class.
Example: ""Ah As Ac Td 7s" - further examples can be seen in the PokerHandTest class.

The PokerHand integrates the RankFactory class and compares the hands.
Public accessors in this class are getHighestCard (public for testing purposes only), compareWith which takes the
opponent's hand as a parameter, getRank: allowing for external access to a player's hand and getHand which returns
a String implementation of a player's hand.

A Card Enum assigns a specific numerical value to a card, allowing for a value comparison between individual cards.
This was implemented to resolve "high-card", "two pairs" and "three of a kind" stalemate scenarios.
In the case of two pairs, the sum of two pairs will be deemed the winning hand. The highest valued card will lead to win
in the other mentioned scenarios.
This enum also entails a public method value(), which can be called to retrieve the numerical value.

A Rank Enum provides a rank for a given poker hand, also allowing for value comparisons between hands.
The RankFactory class contains a single public method getRank, which returns the rank of the supplied hand.
The logic for

Direct user input was not part of the specification, therefore it is assumed that the unit tests provided are sufficient.
However, a simple main method instantiating the PokerHand object can be added to test it.

Importing it:
The application can be imported and built into an ide of your choice, using maven and was written using a TDD-approach
(therefore all classes have unit test coverage). Unit testing is achieved by using JUnit5.
