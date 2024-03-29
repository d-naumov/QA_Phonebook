package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

  //precondition : user should be log out
  // if login link not present
  //click on the Login link

  //enter email
  //enter password
  //click on the Registration button
  //assert: Sign out button is present

  @BeforeMethod
  public void ensurePrecondition() {

    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }


  @Test
  public void registerExistedUserNegativeTest() {

    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegisterForm(new User()
        .setMail("ssd@gm.com")
        .setPassword( "Ssdir123$"));
    app.getUser().clickOnRegisterButton();

    Assert.assertTrue(app.getUser().isAlertAppears());
  }

}
