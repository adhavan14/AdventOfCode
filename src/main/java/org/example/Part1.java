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
        for (int i =0; i<input.length; i++) {
            String[] games = input[i].trim().split(":");

            String[] colorSets = games[1].trim().split(";");

            int red = 1;
            int green = 1;
            int blue = 1;
            for (String colorSet : colorSets) {
                String[] colors = colorSet.trim().split(",");

                for(String color: colors) {
                    String[] value = color.trim().split(" ");
                    if (value[1].equals("red") && Integer.parseInt(value[0]) > red) {
                        red = Integer.parseInt(value[0]);
                    }else if (value[1].equals("green") && Integer.parseInt(value[0]) > green) {
                        green = Integer.parseInt(value[0]);
                    }else if (value[1].equals("blue") && Integer.parseInt(value[0]) > blue) {
                        blue = Integer.parseInt(value[0]);
                    }
                }
            }
            sum += red*green*blue;
        }
        System.out.println(sum);
    }
}
