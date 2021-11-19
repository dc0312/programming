package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetStairsPath {
    public static void main(String[] args) {
        List<String> ans = getStairsPath(7);
        System.out.println(ans);
    }

    private static List<String> getStairsPath(int n) {

        if(n==0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }else if(n<-1){
            ArrayList<String> ans = new ArrayList<>();
            return ans;
        }

        List<String> paths1 = getStairsPath(n-1);
        List<String> paths2 = getStairsPath(n-2);
        List<String> paths3 = getStairsPath(n-3);

        List<String> paths = new ArrayList<>();

        for(String p1 : paths1){
            paths.add(p1+"1");
        }

        for(String p2 : paths2){
            paths.add(p2+"2");
        }

        for(String p3 : paths3){
            paths.add(p3+"3");
        }

        return paths;
    }
}
