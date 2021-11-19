package recursion;

import java.util.ArrayList;

public class GetAllSubsequence {
    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        ans = gss("abc");
        System.out.println("Result "+ans);
    }

    private static ArrayList<String> gss(String str) {
        if (str.length() == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add(str);
            return res;
        }

        char ch = str.charAt(0);
        String subSTr = str.substring(1);
        ArrayList<String> res = gss(subSTr);
        ArrayList<String> ans = new ArrayList<>();
        for(String r : res){
            ans.add(r);
        }
        for(String r : res){
            ans.add(ch+r);
        }

        return ans;

    }
}
