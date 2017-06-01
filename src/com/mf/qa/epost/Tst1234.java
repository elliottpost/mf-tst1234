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

    /**
     * @var the driver
     */
    private WebDriver driver;

    /**
     * Driver path, update on your system to test
     */
    private final String PATH_CHROMEDRIVER = "/Users/elly/dev/selenium/chromedriver";

    /**
     * Pre-conditions
     * trailing slash required
     */
    public static final String PRECOND_START_URL = "http://www.plumtreegroup.net/";

    /**
     * @var the URL for Loyola
     * trailing slash required
     */
    public static final String LUC_URL = "http://www.luc.edu/";

    /**
     * Sets up the testing dependencies
     */
    public Tst1234()
    {
        setUp();
    }

    /**
     * Initializes the driver and sets the preconditions
     */
    private void setUp()
    {
        driver = createDriver();

        // Precondition: we are already at "http://www.plumtreegroup.net/"
        driver.get(PRECOND_START_URL);
    }

    /**
     * Gets the current URL of the web driver
     * @return the URL
     */
    public String getUrl()
    {
        return driver.getCurrentUrl();
    }

    /**
     * Runs the test
     */
    public void run() throws Exception
    {
        step1();
        step2();
        step3();
        step4();
        step5();

        quitDriver();
    }

    /**
     * Tst-1234-1
     * Navigate to www.luc.edu
     */
    public void step1()
    {
        driver.get(Tst1234.LUC_URL);
    }

    /**
     * Tst-1234-2
     * Search for "Computer Science" using search box in top right corner
     */
    public void step2()
    {
        WebElement s = driver.findElement(By.name("criteria"));
        s.sendKeys("Computer Science");
        s.submit();


//        driver.get(link.getAttribute("href"));
    }

    /**
     * Click on "Computer Science Department"
     */
    public void step3()
    {

        driver.findElement(By.linkText("Computer Science Department")).click();
    }

    /**
     * Click on ‘Emerging Technologies Laboratory’ from the 'RESEARCH' drop down
     */
    public void step4()
    {
        // This method is the best, if we know the positioning of the link should never change
//        WebElement link = driver.findElement(By.xpath("//*[@id=\"main-nav\"]/li[6]/ul/li[4]/a"));

        // but without that assumption, this method, which is slightly slower, will always work
        WebElement link = driver.findElement(
                By.xpath(
                        "//*[@id='main-nav']/li/a[text() = 'Research']/ancestor::li/ul/li/a[contains(text(), 'Emerging Technologies')]"
                )
        );

        // account for small resolutions switching to mobile menu
        if (link.isDisplayed())
            link.click();
        else
            driver.get(link.getAttribute("href"));
    }

    /**
     * Go to the home page
     */
    public void step5()
    {
        driver.get(Tst1234.LUC_URL);
    }

    /**
     * Creates the Chrome Webdriver
     * @return chrome webdriver
     */
    private WebDriver createDriver()
    {
        System.setProperty("webdriver.chrome.driver", PATH_CHROMEDRIVER);
        return new ChromeDriver();
    }

    /**
     * Exits Selenium
     */
    public void quitDriver()
    {
        driver.quit();
    }
}
