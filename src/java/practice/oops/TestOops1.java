package practice.oops;

public class TestOops1 {
    public static void main(String[] args) {
        String s1 = new String("Deepak");
        String s2 = new String("Deepak");
        String s3 = "Deepak";
        String s4 = "Deepak";

        System.out.println("s1==s2 -> " + (s1 == s2));
        System.out.println("s1==s3 ->" + (s1 == s3));
        System.out.println("s3==s4 ->" + (s3 == s4));
        System.out.println("s1.equals(s4) ->" + s1.equals(s4));
        System.out.println("s3.equals(s4) ->" + s3.equals(s4));

        System.out.println("s1.substring(0,0) ->" + s1.substring(0, 0));
        System.out.println("s1.substring(s1.length()) ->" + s1.substring(s1.length()));
        System.out.println("s1.equals(s1.substring(s1.length()))) ->" + s1.equals(s1.substring(s1.length())));

        String s5 = new String("DC").intern();
        String s6 = "DC";

        System.out.println("s5.intern()==s6 ->" + (s5 == s6));

        String s7 = new String("DChat").intern();
        String s8 = new String("DChat").intern();

        System.out.println("s7==s8 ->" + (s7 == s8));
    }
}
