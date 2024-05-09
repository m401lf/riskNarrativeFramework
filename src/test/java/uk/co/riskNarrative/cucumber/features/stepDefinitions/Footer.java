package uk.co.riskNarrative.cucumber.features.stepDefinitions;

import base.BasePage;
import base.BaseTest;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;


public class Footer extends BaseTest {
    BasePage page = PageFactory.initElements(driver, BasePage.class);

    @When("^I click the Terms and Conditions link in the bottom footer$")
    public void i_click_the_Terms_and_Conditions_link_in_the_bottom_footer() throws Throwable {
        //page.clickTermsAndConditionsGuestRadioButton();
    }

}


