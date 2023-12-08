package com.phonebook.tests;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    if (!isElementPresent(By.cssSelector("[href='/login']"))) {
      driver.findElement(By.xpath("//button[.='Sign Out']")).click();
    }

  }

  @Test
  public void registerExistetNegativeTest() {
    //click on the Login link
    driver.findElement(By.cssSelector("[href='/login']")).click();

//enter email
    //email -> By.name
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("ssd@gm.com");
    // enter password
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Ssdir123$");
    //click on the Registration button
    driver.findElement(By.name("registration")).click();
    Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

    //assert: Sign out button is present
    Assert.assertTrue(isAlertAppears());

  }

  public boolean isAlertAppears() {
    Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
        .until(ExpectedConditions.alertIsPresent());
    if (alert == null) {
      return false;
    } else {
      return true;
    }
  }

}
