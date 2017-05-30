/**
 * Represents Tst-1234, as described in ticket #____
 * (In actuality, no ticket number, this is an email request
 * For a job interview process)
 *
 * @since May 30, 2017
 * @author Elly Post
 */

package com.mf.qa.epost;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tst1234 {

    private WebDriver driver;
    private final String PATH_CHROMEDRIVER = "/Users/elly/dev/selenium/chromedriver";

    /**
     * Creates the initial data
     */
    public Tst1234()
    {
        driver = createDriver();
    }

    /**
     * Runs the test
     */
    public void run()
    {
        // Given: we are already at "http://www.plumtreegroup.net"

        // And now use this to visit Google
        driver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
    }

    public WebDriver createDriver()
    {
        System.setProperty("webdriver.chrome.driver", PATH_CHROMEDRIVER);
        return new ChromeDriver();
    }
}
