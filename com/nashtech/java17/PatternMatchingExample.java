package nashtech.java17;

import java.util.logging.Logger;

/*
Pattern Matching: In the pattern matching example, instanceof pattern matching is used to check if obj is an instance of String and if its length is greater than 5.
The switch statement uses pattern matching to handle different types (String and Integer) more concisely and efficiently than traditional instanceof checks and casts.
*/
public class PatternMatchingExample {

    private static final Logger logger = Logger.getLogger(PatternMatchingExample.class.getName());

    public static void main(String[] args) {
        Object obj = "Hello";

        // instanceof pattern matching
        if (obj instanceof String s && s.length() > 5) {
            logger.info("String length is greater than 5");
        } else {
            logger.info("Not a string or length is not greater than 5");
        }

        // switch statement pattern matching
        switch (obj) {
            case String s -> logger.info("String: " + s);
            case Integer i -> logger.info("Integer: " + i);
            default -> logger.info("Unknown type");
        }
    }
}
