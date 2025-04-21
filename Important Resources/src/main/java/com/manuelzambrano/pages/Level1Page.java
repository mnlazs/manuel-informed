package com.manuelzambrano.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Level1Page {
    private WebDriver driver;

    @FindBy(id = "randomString")
    private WebElement randomStringElement;

    @FindBy(id = "nameInput")
    private WebElement nameInput;

    @FindBy(css = "button")
    private WebElement submitButton;

    public Level1Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getRandomName() {
        return randomStringElement.getText();
    }

    public void submitName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
        submitButton.click();
    }
}
