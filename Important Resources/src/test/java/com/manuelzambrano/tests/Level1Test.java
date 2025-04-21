package com.manuelzambrano.tests;

import com.manuelzambrano.pages.Level1Page;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class Level1Test {

    private WebDriver driver;
    private WebDriverWait wait;
    private Level1Page page;

    @BeforeEach
    public void setup() {
        // Asegúrate de que chromedriver esté en tu PATH
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        page = new Level1Page(driver);
    }

    @Test
    public void testLevel1Success() throws Exception {
        // Ajusta esta ruta al HTML de tu nivel 1
        driver.get("file:///C:/ruta/a/Week%203/Important%20Resources/InFormed/src/test/resources/forms/level-1.html");

        String name = page.getRandomName();
        page.submitName(name);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        Assertions.assertTrue(text.startsWith("SUCCESS"),
                "Se esperaba SUCCESS, pero fue: " + text);
        alert.accept();

        // Guarda screenshot en la carpeta raíz del módulo Maven
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("screenshots/level-1.png"));
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
