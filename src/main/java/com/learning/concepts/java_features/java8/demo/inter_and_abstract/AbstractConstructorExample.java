package com.learning.concepts.java_features.java8.demo.inter_and_abstract;

/**
 * Shows that abstract classes can define constructors to initialize shared state,
 * while interfaces cannot declare constructors.
 */
public class AbstractConstructorExample {

    /**
     * Contract-only type. Interfaces define behavior signatures, not construction logic.
     */
    interface Task {
        void run();
    }

    /**
     * Constructor captures required state for all subclasses.
     */
    static abstract class AbstractTask {
        private final String taskId;

        protected AbstractTask(String taskId) {
            this.taskId = taskId;
        }

        protected String getTaskId() {
            return taskId;
        }
    }

    static class FileTask extends AbstractTask implements Task {
        FileTask(String taskId) {
            super(taskId);
        }

        @Override
        public void run() {
            System.out.println("[Constructor] Running task with id = " + getTaskId());
        }
    }

    /**
     * Creates a concrete task to prove constructor-based initialization path.
     */
    public static void demonstrate() {
        FileTask task = new FileTask("TASK-001");
        task.run();
    }
}

