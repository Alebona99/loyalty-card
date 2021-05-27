package com.loyaltycard;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:report/loyaltyCard.html", "json:report/LoyaltyCard-report.json"},
        features ={"src/test/java/features/LoyaltyCard.feature"})
public class LoyaltyCardRunner {
}
