package com.cybertek.Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class G3A1 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("prependedInput")).sendKeys("user165");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }
    }

}