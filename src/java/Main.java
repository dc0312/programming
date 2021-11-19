import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(logic());
    }

    private static int logic() {
        try{
            System.out.println("dc");
            return 1;
        }catch (Exception e){
            System.out.println("ex");
            return -1;
        }finally {
            System.out.println("finally");
            return 0;
        }
    }


}
