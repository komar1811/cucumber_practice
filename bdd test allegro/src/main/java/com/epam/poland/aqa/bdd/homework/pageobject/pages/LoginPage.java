package com.epam.poland.aqa.bdd.homework.pageobject.pages;

import com.epam.poland.aqa.bdd.homework.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "login")
    private WebElement loginField;
    @FindBy(name = "password")
    private WebElement passWordField;
    @FindBy(xpath = "//button[contains(text(),\"Zaloguj się\")]")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public MainPage login(String login, String passWord){
        loginField.sendKeys(login);
        passWordField.sendKeys(passWord);
        loginButton.click();
        return new MainPage(webDriver);
    }
}
