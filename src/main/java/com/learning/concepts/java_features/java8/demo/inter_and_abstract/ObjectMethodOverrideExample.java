package com.learning.concepts.java_features.java8.demo.inter_and_abstract;

/**
 * Demonstrates Object-method behavior differences.
 * <p>
 * Interfaces cannot provide default implementations for Object methods such as
 * {@code toString()}, {@code equals()}, or {@code hashCode()}. Abstract classes can
 * override these methods normally.
 */
public class ObjectMethodOverrideExample {

    interface Displayable {
        default String describe() {
            return "Displayable.describe() from interface";
        }

        // NOTE: A default toString() here would not compile because interfaces
        // cannot provide default implementations for java.lang.Object methods.
    }

    static abstract class AbstractEntity implements Displayable {
        private final String id;

        protected AbstractEntity(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "AbstractEntity{id='" + id + "'}";
        }
    }

    static class UserEntity extends AbstractEntity {
        UserEntity(String id) {
            super(id);
        }
    }

    /**
     * Prints an interface default method and an abstract-class Object override.
     */
    public static void demonstrate() {
        UserEntity entity = new UserEntity("U-100");
        System.out.println("[Object methods] Interface default method = " + entity.describe());
        System.out.println("[Object methods] Abstract class overrides toString = " + entity.toString());
    }
}

