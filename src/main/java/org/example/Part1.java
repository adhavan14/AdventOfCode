package org.example;

public class Part1 {

    private final Producer producer;
    private final Part2 part2;

    public Part1() {
        producer = new Producer();
        part2 = new Part2();
    }

    private boolean checkValidCode(String[] input, int j, int i ) {
        String special = "!@#$%^&*()_-+=?/";
        if ((j<input.length-1 && special.indexOf(input[j+1].charAt(i)) > 0)
        || (j>0 && special.indexOf(input[j-1].charAt(i)) > 0)
        || (i<input[j].length()-1 && special.indexOf(input[j].charAt(i+1)) > 0)
        || (i>0 && special.indexOf(input[j].charAt(i-1)) > 0)
        || (j<input.length-1 && i<input[j].length()-1 && special.indexOf(input[j+1].charAt(i+1)) > 0)
        || (j<input.length-1 && i>0 && special.indexOf(input[j+1].charAt(i-1)) > 0)
        || (j>0 && i<input[j].length()-1 && special.indexOf(input[j-1].charAt(i+1)) > 0)
        || (j>0 && i>0 && special.indexOf(input[j-1].charAt(i-1)) > 0)) {
            return true;
        }
        return false;
    }

    public void execute() {

        String[] input = producer.getInput().split("\n");
        int sum = 0;
        for (int j=0;j<input.length;j++) {
            boolean flag = false;
            int num = 0;
            for (int i=0;i<input[j].length();i++) {
                if(input[j].charAt(i) >= '0' && input[j].charAt(i) <= '9') {
                    num = num * 10 + input[j].charAt(i)-'0';
                    if (checkValidCode(input, j, i)) {
                        flag = true;
                    }
                } else {
                    System.out.println(num);
                    if (flag)
                        sum += num;
                    num=0;
                    flag = false;
                }
            }
            sum += num;
        }
        System.out.println(sum);
    }
}
