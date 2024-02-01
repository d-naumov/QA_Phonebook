package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

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
  }

  @Test
  public void addContactPositiveTest() {

    app.getContact().clickOnAddLink();
    app.getContact().fillAddContactForm(
        new Contact()
            .setName("Karl")
            .setLastname("Adam")
            .setPhone("1234567890")
            .setMail("edi@gm.com")
            .setAddress("Berlin")
            .setDescription("Berliner"));
    //click on save button
    app.getContact().clickOnSaveMethod();
    // assert: by name of contact
    Assert.assertTrue(app.getContact().isContactCreatedByText("Karl"));

  }

  @AfterMethod
  public void postCondition() {
    app.getContact().removeContact();
  }


  @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
  public void addContactPositiveFromDataProviderTest(String name, String surname, String phone,
      String email,
      String address, String desc) {

    app.getContact().clickOnAddLink();
    app.getContact().fillAddContactForm(
        new Contact()
            .setName(name)
            .setLastname(surname)
            .setPhone(phone)
            .setMail(email)
            .setAddress(address)
            .setDescription(desc));

    app.getContact().clickOnSaveMethod();

    Assert.assertTrue(app.getContact().isContactCreatedByText(name));

  }


  @Test(dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviders.class)
  public void addContactPositiveFromDataProviderWithCSVTest(Contact contact) {

    app.getContact().clickOnAddLink();
    app.getContact().fillAddContactForm(contact);

    app.getContact().clickOnSaveMethod();

    Assert.assertTrue(app.getContact().isContactCreatedByText(contact.getName()));

  }

}
