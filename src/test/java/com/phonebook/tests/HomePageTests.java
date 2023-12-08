package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

  @Test
  public void isHomeComponentsPresentTest() {
//    driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1"));
    Assert.assertTrue(isHomeComponentsPresent());
  }

  public boolean isHomeComponentsPresent() {
    return isElementPresent(By.cssSelector("div:nth-child(2)>div>div>h1"));
  }


}
