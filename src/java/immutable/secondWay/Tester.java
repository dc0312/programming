package immutable.secondWay;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;

public class Tester {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Immutable immutable = new Immutable(2);
        System.out.println(immutable);

//        Class clazz = immutable.getClass();
//        Field idField = clazz.getDeclaredField("id");
//        idField.setAccessible(true);
//        idField.set(immutable,3);
//
//        System.out.println(immutable.getId());
//        Immutable newObject = (Immutable) clazz.getConstructor(Integer.class).newInstance();
//        System.out.println(newObject);

        String serFile1 = "file.ser";

        try (FileOutputStream fileOutputStream = new FileOutputStream(serFile1);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(serFile1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
