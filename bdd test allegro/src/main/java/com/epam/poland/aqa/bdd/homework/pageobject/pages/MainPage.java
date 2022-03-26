package com.epam.poland.aqa.bdd.homework.pageobject.pages;

import com.epam.poland.aqa.bdd.homework.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@data-dropdown-id=\"user_dropdown\"]//img[@data-role=\"header-dropdown-icon\"]")
    private WebElement dropDownAccountMenuButton;

   public MainPage(WebDriver webDriver){
        super(webDriver);
    }

    public MainPage open(){
       webDriver.get("https://allegro.pl/");
       return this;
    }

    public LoginPage goToLogin() {
       dropDownAccountMenuButton.click();

       WebElement loginButton = new WebDriverWait(webDriver,Duration.ofSeconds(10))
               .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),\"Zaloguj się\")][@data-role=\"login-button\"]")));
       loginButton.click();
       return new LoginPage(webDriver);
    }
}
