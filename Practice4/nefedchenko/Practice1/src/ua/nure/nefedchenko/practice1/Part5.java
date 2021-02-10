package ua.nure.nefedchenko.practice1;

public class Part5 {
    public static void main(String[] args){
        int num = Integer.parseInt(args[0]);
        int sum = 0;
        while(num != 0){
            sum += (num % 10);
            num/=10;
        }
        System.out.println(sum);
    }
}
