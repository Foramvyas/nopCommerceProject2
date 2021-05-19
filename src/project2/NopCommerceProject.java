package project2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class NopCommerceProject {

    WebDriver driver;

    @Before

    public void setUp() {
        String baseUrl = "https://demo.nopcommerce.com";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void userShouldRegisterSuccessfully() throws InterruptedException {

        driver.findElement(By.linkText("Register")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='gender-female']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Mahi");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Bhatt");
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).sendKeys("16");
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("May");
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("2010");
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("mahi.bhatt" + randomInt + "@yahoo.com");
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Prime");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Test123");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Test123");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
        Thread.sleep(1000);
        String expectedMessage = "Your registration completed";
        WebElement message = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));

        String actualMessage = message.getText();

        Assert.assertEquals("User is not registered successfully", expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        driver.quit();


    }
}






