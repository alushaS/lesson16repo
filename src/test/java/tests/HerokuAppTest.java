package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppTest {

    @Test
    public void registerOnHerokuApp() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

        String expectedResult = "Logout";
        String actualResult = driver.findElement(By.xpath("//*[@class=\"icon-2x icon-signout\"]")).getText();
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
