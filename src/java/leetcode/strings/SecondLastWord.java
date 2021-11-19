package leetcode.strings;

import java.util.Collections;
import java.util.Locale;
import java.util.PriorityQueue;

public class SecondLastWord {
    public static void main(String[] args) {
        String[] words = {"cat", "bat", "rat", "king", "queen", "wise", "long", "zoom", "ZOOMON","VMware"};

        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int i = 0; i < 2; i++) {
            pq.add(words[i]);
        }

        for (int i = 2; i < words.length; i++) {
            if(pq.peek().toLowerCase(Locale.ROOT).compareTo(words[i].toLowerCase(Locale.ROOT)) < 1){
                pq.poll();
                pq.add(words[i]);
            }
        }

        System.out.println(pq.peek());
    }
}
