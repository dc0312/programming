package slidingwindow;

public class AAA {

    private static Object object = new Object();

    public static void a() {
        synchronized(object) {
            System.out.println("Before " + Thread.currentThread().getId());
            try {
                object.wait();
            } catch (Exception ignore) {}
            System.out.println("After " + Thread.currentThread().getId());
        }
    }

    public static void b() throws InterruptedException {
        synchronized(object) {
            System.out.println("Before Notify");
            object.notifyAll();
            Thread.sleep(5000);
            System.out.println("After b");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> AAA.a()).start();
        new Thread(AAA::a).start();
        System.out.println("sleep");
        b();
    }
}