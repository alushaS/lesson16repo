package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleAppTest {

    @Test
    public void registerOnSampleApp() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.uitestingplayground.com/sampleapp");
        driver.findElement(By.name("UserName")).sendKeys("alina");
        driver.findElement(By.name("Password")).sendKeys("pwd");
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();

        String expectedResult = "Welcome, alina!";
        String actualResult = driver.findElement(By.xpath("//*[@class=\"text-success\"]")).getText();
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
