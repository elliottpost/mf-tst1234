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
     * Preconditions
     */
    private final String PRECOND_START_URL = "http://www.plumtreegroup.net";

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

        // Precondition: we are already at "http://www.plumtreegroup.net"
        driver.get(PRECOND_START_URL);
    }

    /**
     * Runs the test
     */
    public void run() throws Exception
    {

        step1();
        step2();
        step3();
        String s4 = step4();
        // @todo unit test
        if (! s4.equals("https://loyolachicagoetl.github.io/"))
            throw new Exception("Wrong URL: " + s4);

        String s5 = step5();
        // @todo unit test
        if (! s5.equals("http://www.luc.edu/"))
            throw new Exception("Wrong URL: " + s5);

        driver.quit();
    }

    /**
     * Tst-1234-1
     * Navigate to www.luc.edu
     */
    private void step1()
    {
        driver.get("http://www.luc.edu");
    }

    /**
     * Tst-1234-2
     * Search for "Computer Science" using search box in top right corner
     */
    private void step2()
    {
        WebElement s = driver.findElement(By.name("criteria"));
        s.sendKeys("Computer Science");
        s.submit();


//        driver.get(link.getAttribute("href"));
    }

    /**
     * Click on "Computer Science Department"
     */
    private void step3()
    {
        driver.findElement(By.linkText("Computer Science Department")).click();
    }

    /**
     * Click on ‘Emerging Technologies Laboratory’ from the 'RESEARCH' drop down
     * @return the URL of the page we navigate to
     */
    private String step4()
    {
        // @todo: consider changing this to find link by text, rather than location, to ensure
        // we are visiting the link provided it's in the drop down and not requiring it to be in a
        // specific place
        WebElement link = driver.findElement(By.xpath("//*[@id=\"main-nav\"]/li[6]/ul/li[4]/a"));
        // account for small resolutions switching to mobile menu
        if (link.isDisplayed())
            link.click();
        else
            driver.get(link.getAttribute("href"));

        System.out.println()
        return driver.getCurrentUrl();
    }

    /**
     * Go to the home page
     * @return String the URL of the page we navigate to
     */
    private String step5()
    {
        driver.get("http://www.luc.edu");
        return driver.getCurrentUrl();
    }

    private WebDriver createDriver()
    {
        System.setProperty("webdriver.chrome.driver", PATH_CHROMEDRIVER);
        return new ChromeDriver();
    }
}
