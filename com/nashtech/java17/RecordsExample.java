package nashtech.java17;

import java.util.logging.Logger;


public class RecordsExample {
    private static final Logger logger = Logger.getLogger(RecordsExample.class.getName());

    public static void main(String[] args) {
        RecordsExample example = new RecordsExample();

        logger.info("Java 11:");
        example.beforeJava17();

        logger.info("Java 17:");
        example.usingJava17();
    }

    public void beforeJava17() {
        Person person = new Person("Alice", 30);
        logger.info("Name: " + person.getName());
        logger.info("Age: " + person.getAge());
    }

    // Java 11
    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        // hashCode, equals, toString methods would need to be manually implemented
    }

    // Java 17 (Stream API)
    public void usingJava17() {
        Person1 person = new Person1("Alice", 30);
        logger.info("Name: " + person.name());
        logger.info("Age: " + person.age());
    }

    public record Person1(String name, int age) {
        // Additional methods and constructors can be added if needed
        public Person1 {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
        }
    }
}
