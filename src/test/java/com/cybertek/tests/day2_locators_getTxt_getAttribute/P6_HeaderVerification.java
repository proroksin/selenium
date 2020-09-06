package com.cybertek.tests.day2_locators_getTxt_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_HeaderVerification {

    public static void main(String[] args) {

        //TC #6: Zero Bank header verification
        //1. open chrome web browser
        WebDriverManager.chromedriver().setup();

        //open browser
        WebDriver driver = new ChromeDriver();

        //2. go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3. verify header text
        // Expected: "Log in to ZeroBank"

        //locate the header
        // get the text of the header

        //WebElement header = driver.findElement(By.tagName("h3")); // find element returns WebElement


        String actualText = driver.findElement(By.tagName("h3")).getText();// returns string
        String expectedText = "Log in to ZeroBank";

        if(actualText.equals(expectedText)){
            System.out.println("Header verification Passed");
        }else{
            System.out.println("Header verification Failed");
        }


    }
}
