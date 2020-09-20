package com.cybertek.tests.day6_dropdown_review_javafaker;
import com.cybertek.utilities.SmartBearUtilitys;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class SmartBearTest {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        //maximize the page
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get the page
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilitys.loginToSmartBear(driver);

    }


    @Test
    public void task1_login_page_links_print_test(){
        //Enter username : "Tester"
        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        usernameInput.sendKeys("Tester");

        //4. Enter password: "test"
        WebElement passwordInput = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordInput.sendKeys("test");

        //5.Click to Log in BUTTON
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();

        //6. Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        System.out.println("Count of all the links on the page = " + allLinks.size());

        //7. Print out each link text on this page

        for(WebElement eachLink : allLinks){
            System.out.println("each link = "+ eachLink.getText());
        }

    }

    @Test
    public void task2_create_order_with_javafaker(){
        //6. Click on Order
        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();

        //7. Select familyAlbum from product, set quantity to 2
        Select productDropDown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropDown.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityInput.sendKeys(Keys.BACK_SPACE + "2");

        //8. Click to "Calculate" button
        WebElement calculateButton = driver.findElement(By.xpath("/input[@value=‘Calculate’]"));
        calculateButton.click();

        //locating all of the web elements using id
        WebElement nameInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement streetInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement cityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement stateInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zipInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        //9. Fill address Info with JavaFaker
        Faker faker = new Faker();
        //• Generate: name, street, city, state, zip code
        nameInput.sendKeys(faker.name().fullName());

        streetInput.sendKeys(faker.address().streetAddress());

        cityInput.sendKeys(faker.address().city());

        stateInput.sendKeys(faker.address().state());

        zipInput.sendKeys(faker.address().zipCode());

        //10. Click on "visa" radio button
        //11. Generate card number using JavaFaker
        //12. Click on "Process"
        //13.Verify success message "New order has been successfully added."
    }



}
