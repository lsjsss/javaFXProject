package java_Unit19;

import java.util.ArrayList;

public class select {
    public static void main(String[] args) {
        //集合中 11 个题目
        ArrayList<String> al = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            al.add("19." + i);
        }

        String[] s = new String[11];
        for (int i = 0; i < 11; i++) {
            s[i] = "组长" + (i+1);
        }


        ArrayList<String> selected = new ArrayList<>();
        int i = 1;
        while (true) {
            String t = "19." + (int) (Math.random() * 11 + 1);
            if (selected.contains(t)) {
                continue;
            } else {
                selected.add(t);
                System.out.println(s[i] + "-->" + t);
            }
        }




//
//        for (int i = 0; i < 11; i++) {
//            String t = "19." + (int)(Math.random() * 11 + 1);
//            System.out.println(s[i] + "-->" + t);
//        }
//        System.out.println();

        //s[0] --> 19.n



    }
}
