/**
 * Wrapper for the Tst1234 main class
 *
 * @since May 30, 2017
 * @author Elly Post
 */

package com.mf.qa.epost;

public class Main {
    public static void main(String[] args) {
        try {
            (new Tst1234()).run();
        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        }
    }
}