package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
        Constructor[] constructor = Singleton.class.getDeclaredConstructors();
        constructor[0].setAccessible(true);
        Singleton instance3 = (Singleton) constructor[0].newInstance();
        System.out.println(instance1 == instance3);
    }
}
