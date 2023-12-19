package org.example;

public class Part1 {

    private final Producer producer;
    private final Part2 part2;

    public Part1() {
        producer = new Producer();
        part2 = new Part2();
    }
    public void execute() {
        String[] input = producer.getInput().split("\n");

        int sum = 0;
        for (int i = 0; i< input.length; i++) {

            int j = 0;
            int k = input[i].length()-1;
            int number1 = 0;
            int number2 = 0;
            boolean one = true, two = true;
            while (one || two) {
                int num1 = part2.execute(input[i].substring(0,j));
                int num2 = part2.execute(input[i].substring(k));
                if (one && num1 > -1) {
                    number1 = num1;
                    one = false;
                }
                else if (one && (input[i].charAt(j) >= '0' && input[i].charAt(j) <= '9')) {
                    number1 = input[i].charAt(j)-'0';
                    one = false;
                } else {
                    j++;
                }
                if (two && num2 > -1) {
                    number2 = num2;
                    two = false;
                }
                else if (two && (input[i].charAt(k) >= '0' && input[i].charAt(k) <= '9')) {
                    number2 = input[i].charAt(k)-'0';
                    two = false;
                } else {
                    k--;
                }
            }
            sum += number1*10 + number2;
        }
        System.out.println(sum);
    }
}
