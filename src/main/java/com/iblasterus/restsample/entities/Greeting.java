package com.iblasterus.restsample.entities;

/**
 * Class that represent a greeting
 */
public class Greeting {
    /**
     * Text of greeting
     */
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "greeting='" + greeting + '\'' +
                '}';
    }
}
