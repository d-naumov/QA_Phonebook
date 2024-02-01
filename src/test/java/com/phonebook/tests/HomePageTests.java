package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {


  @BeforeMethod
  public void ensurePrecondition(){
    if (!app.getHomepage().isHomeComponentsPresent()){
      app.getHomepage().clickOnHomeLink();
    }
  }

  @Test
  public void isHomeComponentsPresentTest() {
    Assert.assertTrue(app.getHomepage().isHomeComponentsPresent());
  }

}
