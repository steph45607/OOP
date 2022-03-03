import java.util.Scanner;

public class Main {
    public static void main(String[] args){

//        7a - 8
//        7b - 2
//        7c - -13
//        7d - 3
//        7e - 2
//        7f - jjjjjjxxx
//        8
        System.out.println("*********       ***         *        *");
        System.out.println("*       *    *       *     ***      * *");
        System.out.println("*       *   *         *   *****    *   *");
        System.out.println("*       *   *         *     *     *     *");
        System.out.println("*       *   *         *     *    *       *");
        System.out.println("*       *   *         *     *     *     *");
        System.out.println("*       *   *         *     *      *   *");
        System.out.println("*       *    *       *      *       * *");
        System.out.println("*********       ***         *        *");
//        9
        Scanner inputC = new Scanner(System.in);
        System.out.println("Enter temperature in celsius: ");
        int tempC = inputC.nextInt();
        int tempF = (tempC * (9/5))-32;
        System.out.println(tempC + " Celsius degrees are "+tempF+" Fahrenheit degrees.");
//        10
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        System.out.println("Enter x1, x2, x3 (each new line): ");
        int x1 = input1.nextInt(), x2 = input2.nextInt(), x3 = input3.nextInt();
        double mean = (x1+x2+x3)/3;
        double variance = (Math.pow((x1-mean),2)+Math.pow((x2-mean),2)+Math.pow((x3-mean),2))/3;
        double sd = Math.sqrt((Math.pow(variance,2)));
        System.out.println("For the values "+ x1+" "+x2+" "+x3+ " has the mean "+ mean+ ", variance "+ variance
                +", standard deviation "+ sd);
//        11
        int x,y,ex;
        x = 10;
        y = 5;
        System.out.println("x is " + x + " y is "+y);
        ex = x;
        x = y;
        y = ex;
        System.out.println("x is " + x + " y is "+y);
//        12
        System.out.println("number\tsquare\tcube");
        for(int i = 0; i < 11; i++){
            System.out.println("\t"+i+"\t"+Math.round(Math.pow(i,2))+"\t\t"+Math.round(Math.pow(i,3)));
        }
//        13
        Scanner inputa = new Scanner(System.in);
        Scanner inputb = new Scanner(System.in);
        Scanner inputc = new Scanner(System.in);
        System.out.println("Enter a, b, c (each new line) :");
        int a = inputa.nextInt(), b = inputb.nextInt(), c = inputc.nextInt();
        if(a == 0 || (Math.pow(2,b)-4*a*c)<0){
            System.out.println("There are no solution");
        }else {
            int posX = (int) (((-1 * b) + (Math.sqrt((Math.pow(2, b) - 4 * a * c)))) / 2 * a);
            int negX = (int) (((-1 * b) - (Math.sqrt((Math.pow(2, b) - 4 * a * c)))) / 2 * a);
            System.out.println("For the values " + a + " " + b + " " + c + " , have the x values " + posX + " and " + negX);
        }
//        14
        Scanner inputSec = new Scanner(System.in);
        System.out.println("Enter seconds to convert : ");
        int seconds = inputSec.nextInt();
        int hour, minute, second= seconds;
        if(second < 3600){
            hour = 0;
        }else{
            hour = second / 3600;
            second -= hour*3600;
        }
        if(second < 60){
            minute = 0;
        }else{
            minute = second / 60;
            second -= minute * 60;
        }
        System.out.println( seconds + " seconds are "+ hour +" hour, " + minute + " minute, and "+ second+" seconds.");
    }

}
