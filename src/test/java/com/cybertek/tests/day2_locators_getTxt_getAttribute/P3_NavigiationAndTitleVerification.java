package com.cybertek.tests.day2_locators_getTxt_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_NavigiationAndTitleVerification {

    public static void main(String[] args) {

        //TC #3: Back and forth navigation
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();

        //open browser
        WebDriver driver = new ChromeDriver();

        //2 - GO to: https://google.com
        driver.get("https://google.com");

        //3 - Click to Gmail from top right
        driver.findElement(By.linkText("Gmail")).click();

        //4-verify title contains
        //Expected: Gmail
        String expectedInTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedInTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }


        //5-GO back to Google by using the .back();
        driver.navigate().back();

        // 6- Verify title equals:
        //Expected: Google

        String expectedTitle = "Google";
        String actualGoogleTitle = driver.getTitle();

        if(actualGoogleTitle.equals(expectedTitle)){
            System.out.println("Google title verification PASSED!");
        }else{
            System.out.println("Google title verification FAILED!!!");
        }

    }
}
