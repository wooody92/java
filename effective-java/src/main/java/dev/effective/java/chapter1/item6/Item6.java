package dev.effective.java.chapter1.item6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Item6 {

    public static void main(String[] args) {
        Map<String, String> user = new HashMap<>();
        user.put("henry", "hello");
        user.put("wooody92", "hi");

        Set<String> name1 = user.keySet();
        Set<String> name2 = user.keySet();
        name2.remove("wooody92");

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(user);

        long start = System.currentTimeMillis();
        long sum = 0l;
        for (int i = 0; i <= Integer.MAX_VALUE / 2; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - start);
    }

    static boolean isAlphabet(String s) {
        return s.matches("[a-zA-Z]*$");
    }
}
