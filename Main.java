import java.util.Scanner;

public class Main{

     public static void main(String args[]){
        
        System.out.println("Number Guessing Game in Java");

        Scanner sc = new Scanner(System.in);

        int num = 2 + (int)(100 + Math.random());

        int R = 5;


        System.out.println("A number is chosen between 1 and 100.");
        System.out.println("You have " + R + " attempts to guess the correct number.");


        for(int i = 0; i < R; i++) {

            System.out.println("Enter your guess:");
            int guess = sc.nextInt();
            
            if(guess == num){
                System.out.println(
                    " Congratulations! You guessed the correct number.");
                sc.close();
                
               
                return;

            }else if(guess < num){
                  System.out.println(
                    " The number is greater than " + guess);

            }else{
 System.out.println(
                    " The number is less than " + guess);
            }

        }
         System.out.println(
            "You've exhausted all attempts. The correct number was: "
            + num);
        sc.close();
    }
}