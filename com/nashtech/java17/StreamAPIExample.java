package nashtech.java17;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

//Java 17 includes enhancements to the Stream API, such as new methods for efficient and concise stream processing.

public class StreamAPIExample {

    private static final Logger logger = Logger.getLogger(StreamAPIExample.class.getName());


    public static void main(String[] args) {
        StreamAPIExample example = new StreamAPIExample();

        logger.info("Java 11 (Stream API without takeWhile):");
        example.beforeJava17();

        logger.info("Java 17 (Stream API):");
        example.usingJava17();
    }

    // Java 11 (Stream API without takeWhile)
    public void beforeJava17() {
        List<String> fruits = List.of("Apple", "Orange", "Banana", "Grapes");

        List<String> filteredFruits = new ArrayList<>();
        for (String fruit : fruits) {
            if (!fruit.equals("Banana")) {
                filteredFruits.add(fruit);
            } else {
                break;  // Stop processing after encountering "Banana"
            }
        }

        logger.info("Filtered fruits: " + filteredFruits);
    }

    // Java 17 (Stream API)
    public void usingJava17() {
        List<String> fruits = List.of("Apple", "Orange", "Banana", "Grapes");

        // TakeWhile and DropWhile example
        List<String> filteredFruits = fruits.stream()
                .takeWhile(fruit -> !fruit.equals("Banana"))
                .collect(Collectors.toList());

        logger.info("Filtered fruits: " + filteredFruits);
    }
}
