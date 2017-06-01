package com.mf.qa.epost;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The unit tests for Tst1234
 */
public class Tst1234Test {

    private Tst1234 tester;

    /**
     * Expected value for Step 4
     */
    private final String EV_STEP4 = "https://loyolachicagoetl.github.io/";

    @Before
    /**
     * Instantiates our web driver, so we do not need to rebuild this each test
     */
    public void setUp() throws Exception
    {
        tester = new Tst1234();
    }

    @Test
    /**
     * Tests our steps. Using a single test to ensure order of execution follows the steps listed in Tst1234
     */
    public void run() throws Exception
    {
        assertEquals(tester.getUrl(), Tst1234.PRECOND_START_URL); // ensure we are at the starting point

        // run steps without checking for expected values
        tester.step1();
        tester.step2();
        tester.step3();

        // finally, the remaining steps have expected values
        tester.step4();
        assertEquals(EV_STEP4, tester.getUrl());

        tester.step5();
        assertEquals(Tst1234.LUC_URL, tester.getUrl());
    }


    @After
    /**
     * Quit Selenium -- if implementing additional tests consider using @AfterClass
     */
    public void tearDown() throws Exception
    {
        tester.quitDriver();
    }
}