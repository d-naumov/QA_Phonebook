package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {

    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }

    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegisterForm(new User()
        .setMail("ssd@gm.com")
        .setPassword("Ssdir123$"));
    app.getUser().clickOnLoginButton();
    app.getContact().clickOnAddLink();
    app.getContact().fillAddContactForm(
        new Contact().setName("Karl")
            .setLastname("Adam")
            .setPhone("1234567890")
            .setMail("edi@gm.com")
            .setAddress("Berlin")
            .setDescription("Berliner"));
    app.getContact().clickOnSaveMethod();
  }

  @Test
  public void removeContactPositiveTest() {
    //get size of contacts before remove
    int sizeBefore = app.getContact().getOfContacts();
    app.getContact().removeContact();
    app.getContact().pause(1000);
    //get size of contacts after remove
    int sizeAfter = app.getContact().getOfContacts();
    //assert by number of contacts
     Assert.assertEquals(sizeAfter,sizeBefore-1);

  }


}
