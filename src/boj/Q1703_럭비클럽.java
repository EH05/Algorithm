package boj;

import java.util.Scanner;

public class Q1703_럭비클럽 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true){
            String name = in.next();
            int age = in.nextInt();
            int weight = in.nextInt();

            if(name.equals("#")) {break;}
            if(age > 17 || weight>=80 ) {
                System.out.println(name + " " + "Senior");
            } else System.out.println(name + " "+ "Junior");
        }
    }
}
