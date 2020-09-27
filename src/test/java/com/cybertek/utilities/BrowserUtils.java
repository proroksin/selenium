package com.cybertek.utilities;

import jdk.nashorn.internal.ir.BlockStatement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/*
in this class we will store utility methods that can be applied to any browser content

Any time you feel like you have a good logic that you can use in the future, create a method
of it and store it in this class

Then call it in the future to use it.
 */
public class BrowserUtils {

    /**
    Accepts a list of web Element
    @param list<WebElement>
    @return List<String>
    Method should be returning a list of Strings

     */
    public static List<String> getElementsText(List<WebElement> list){

        List<String> webeelementsAsString = new ArrayList<>();

        for(WebElement each : list){
            webeelementsAsString.add(each.getText());
        }
        return webeelementsAsString;
    }

    /*
    Created a utility method named: wait
    static method
    @param sec
    @return void
    The integer number that i pass as parametr should be accepted as SECONDS
    Handle checked exception with try/catch
     */

    public static void wait(int sec){
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception caught");
        }
    }



}
