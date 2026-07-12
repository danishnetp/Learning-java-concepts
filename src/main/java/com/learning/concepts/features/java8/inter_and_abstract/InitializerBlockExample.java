package com.learning.concepts.features.java8.inter_and_abstract;

/**
 * Explains initializer-block support in abstract classes.
 * <p>
 * Interfaces cannot declare instance/static initializer blocks. Abstract classes can,
 * which allows shared setup before constructors finish.
 */
public class InitializerBlockExample {

    interface Marker {
        // Interfaces cannot define instance or static initializer blocks.
        String TYPE = "interface-marker";
    }

    static abstract class AbstractWithBlocks {
        private static int staticInitCount;
        private int instanceInitCount;

        static {
            staticInitCount++;
        }

        {
            instanceInitCount++;
        }

        public int getInstanceInitCount() {
            return instanceInitCount;
        }

        public static int getStaticInitCount() {
            return staticInitCount;
        }
    }

    static class BlockChild extends AbstractWithBlocks {
    }

    /**
     * Creates one child instance and prints how static/instance blocks were executed.
     */
    public static void demonstrate() {
        BlockChild child = new BlockChild();
        System.out.println("[Blocks] Interface constant TYPE = " + Marker.TYPE);
        System.out.println("[Blocks] Abstract static block count = " + AbstractWithBlocks.getStaticInitCount());
        System.out.println("[Blocks] Abstract instance block count = " + child.getInstanceInitCount());
    }
}

