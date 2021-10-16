package singleton;

public class Singleton {

    private static Singleton INSTANCE;

    private Singleton() {
        if (null != INSTANCE) {
            throw new RuntimeException("SingletonException Occurred.");
        }

    }

    public static Singleton getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}
