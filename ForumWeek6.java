import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.lang.Math;

public class Main {
    // Problem 1
    static void PrintArray() throws IOException {
        System.out.println("PRINTARRAYS-MACHINE PROBLEM 1---------------");
        boolean check = true;
        int items = 0;
        while(check){
            Scanner inputUser = new Scanner(System.in);
            System.out.print("Enter the number of items: ");
            items = inputUser.nextInt();
            if(items <= 0){
                System.out.println("Must be non negative and not a zero");
            }
            else{
                check = false;
            }
        }

        int[] NUM_ITEMS = new int[items];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the value of all items (separated by space): ");

        String[] stringArr = reader.readLine().split(" ");
        for(int i = 0; i < NUM_ITEMS.length; i++){
            NUM_ITEMS[i] = Integer.parseInt(stringArr[i]);
        }

        System.out.print("The values are: [");
        for(int i = 0; i < NUM_ITEMS.length; i++){
            if(i != NUM_ITEMS.length -1){
                System.out.print(NUM_ITEMS[i]+",");

            }
            else{
                System.out.print(NUM_ITEMS[i]);
            }
        }
        System.out.print("]");

    }
    // Problem 2
    static void printArrayInStarts() throws IOException {
        System.out.println("PRINTARRAYINSTARS-MACHINE PROBLEM 2---------------");
        boolean check = true;
        int items = 0;
        while(check){
            Scanner inputUser = new Scanner(System.in);
            System.out.print("Enter the number of items: ");
            items = inputUser.nextInt();
            if(items <= 0){
                System.out.println("Must be non negative and not a zero");
            }
            else{
                check = false;
            }
        }

        int[] NUM_ITEMS = new int[items];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the value of all items (separated by space): ");

        String[] stringArr = reader.readLine().split(" ");
        for(int i = 0; i < NUM_ITEMS.length; i++){
            NUM_ITEMS[i] = Math.abs(Integer.parseInt(stringArr[i]));
        }
        for(int i = 0; i < NUM_ITEMS.length ; i++){
            System.out.print(i + ": ");
            String result;
            for(int j = 0; j < NUM_ITEMS[i];j++){
                System.out.print("*");
            }
            System.out.println("(" + NUM_ITEMS[i] + ")");
        }
    }
    // Problem 3
    static void gradeCalc(){
        System.out.println("GRADECALC-MACHINE PROBLEM 3---------------");
        boolean check = true;
        int numStudents = 0;
        int sum = 0, max = 0, min = 0;
        double avg = 0;
        while(check){
            Scanner inputUser = new Scanner(System.in);
            System.out.print("Enter the number of students: ");
            numStudents = inputUser.nextInt();
            if(numStudents <= 0){
                System.out.println("Must be non negative and not a zero");
            }
            else{
                check = false;
            }
        }
        int[] grades = new int[numStudents];
        for(int i = 0; i < grades.length; i++){
            int indicator = i+1;
            Scanner inputGrade = new Scanner(System.in);
            System.out.print("Enter the grade for student " + indicator + ": ");
            grades[i] = inputGrade.nextInt();
            sum += grades[i];
            min = grades[i];
            if(grades[i] > max){
                max = grades[i];
            }
            if(grades[i] < min){
                min = grades[i];
            }
        }
        avg = (double) sum/numStudents;
        System.out.printf("The average is: %.2f \n", avg);
        System.out.println("The minimum is: " + min);
        System.out.println("The maximum is: " + max);
    }

    public static void main(String[] args) throws IOException {
        PrintArray();
        printArrayInStarts();
        gradeCalc();
    }
}
