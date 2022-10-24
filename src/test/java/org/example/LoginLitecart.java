package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginLitecart {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void loginLitecart() {
        driver.navigate().to("http://localhost/litecart/admin/");
        WebElement login = driver.findElement(By.name("username"));
        login.sendKeys("admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin");
        driver.findElement(By.xpath("//button[contains(@name, 'login')]")).click();
    }

    @Test
    public void homework() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector("td [name = username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("td [name = password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("div.footer [name = login]")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='box-apps-menu']//li"));
        // elements.size() кол-во элементов в списке пунктов меню.
        for (int i = 1; i <= elements.size() ; i++) {
            driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li["+i+"]")).click();
            List<WebElement> element = driver.findElements(By.xpath("//ul[@class='docs']/li"));
            for (int j = 1; j < element.size() + 1; j++){
                driver.findElement(By.xpath("//ul[@class='docs']//li["+j+"]")).click();
            }
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
