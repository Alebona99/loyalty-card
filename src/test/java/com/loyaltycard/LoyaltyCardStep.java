package com.loyaltycard;

import customexception.CardLenghtException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import loyaltycard.LoyaltyCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

public class LoyaltyCardStep {

    private static LoyaltyCard card;

    static {
        try {
            card = new LoyaltyCard("978014102662");
        } catch (CardLenghtException e) {
            e.printStackTrace();
        }
    }

    @Given("user have a Loyalty Card")
    public void userHaveALoyaltyCard() {
    }

    @When("insert the number of Card {string}")
    public void userInsertTheNumberOfCard(String arg0) throws CardLenghtException{
        Assertions.assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                card.setNumberCard(arg0);
            }
        });
    }


    @Then("the user see the {int}")
    public void theUserSeeThe(int arg0) {
        Assertions.assertEquals(arg0 ,card.checkDigit());
    }



    @Then("the user control and see if the card is valid")
    public void theUserControlAndSeeIfTheCardIsValid() {
        Assertions.assertTrue(card.checkValidity());
    }
}
