package MultiThreading;

import java.util.concurrent.Callable;

public class ThreadsWithLambda {

    public static void getWorking() throws Exception {
        compute(() -> "done");
    }

    private static void compute(Runnable r) {
        System.out.println("Runnable invoked.");
        r.run();
    }

    static <T> T compute(Callable<T> c) throws Exception {
        System.out.println("Callable invoked.");
        return c.call();
    }

    public static void main(String[] args) throws Exception {
        //getWorking();

        Thread innerThead = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Inner");
            }
        });

        innerThead.start();
        System.out.println("main Thread ends.");
    }
}
