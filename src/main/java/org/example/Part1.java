package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part1 {

    private final Producer producer;
    private final Part2 part2;

    public Part1() {
        producer = new Producer();
        part2 = new Part2();
    }

    private String checkValidCode(String[] input, int j, int i ) {
        String special = "*";
        if (j<input.length-1 && special.indexOf(input[j+1].charAt(i)) >= 0) {
            return j+1 + " " + i;
        }
        if(j>0 && special.indexOf(input[j-1].charAt(i)) >= 0) {
            return j-1+" "+i;
        }
        if (i<input[j].length()-1 && special.indexOf(input[j].charAt(i+1)) >= 0) {
            return j+" "+(i+1);
        }
        if  (i>0 && special.indexOf(input[j].charAt(i-1)) >= 0) {
            return j+" "+(i-1);
        }
        if (j<input.length-1 && i<input[j].length()-1 && special.indexOf(input[j+1].charAt(i+1)) >= 0) {
            return j+1 + " "+(i+1);
        }
        if  (j<input.length-1 && i>0 && special.indexOf(input[j+1].charAt(i-1)) >= 0) {
            return j+1 + " "+(i-1);
        }
        if (j>0 && i<input[j].length()-1 && special.indexOf(input[j-1].charAt(i+1)) >= 0) {
            return j-1 + " "+(i+1);
        }
        if (j>0 && i>0 && special.indexOf(input[j-1].charAt(i-1)) >= 0) {
            return j-1 + " "+(i-1);
        }
        return null;
    }

    public void execute() {

        String[] input = producer.getInput().split("\n");
        Map<String, List<Integer>> temp = new HashMap<>();
        int sum = 0;
        for (int j=0;j<input.length;j++) {
            boolean flag = false;
            int num = 0;
            String key = new String();
            for (int i=0;i<input[j].length();i++) {
                if(input[j].charAt(i) >= '0' && input[j].charAt(i) <= '9') {
                    num = num * 10 + input[j].charAt(i)-'0';

                    if (!flag) {
                        key = checkValidCode(input, j, i);
                        if(key != null) {
                            flag = true;
                            if (!temp.containsKey(key))
                                temp.put(key, new ArrayList<>());
                        }
                    }
                } else {
                    if (flag && !key.isEmpty()) {
                        temp.get(key).add(num);
                    }
                    num=0;
                    flag = false;
                }
            }
            if (key!=null) {
                if (temp.containsKey(key) && num!=0)
                    temp.get(key).add(num);
            }
        }


        for(List<Integer> values : temp.values()) {
            if (values.size() == 2) {
                sum += (values.get(0) * values.get(1));
            }
        }
        System.out.println(sum);
    }
}
