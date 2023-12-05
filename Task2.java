import java.util.*;

class GuessingGame {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        int guess = 0;
        int tries = 0;
	System.out.println("\n\t\t\t\t  Lets Play!\n");
        System.out.println("\t\t\t\tGuess the Number\n");
        System.out.println("\t\t\tGuess a number between 1 and 100.\n");

        while (guess != number) {
	
            System.out.print("Enter your guess: ");

            guess = input.nextInt();
            tries++;

            if (guess < number) {
                System.out.println("\t\t\t\tToo low, try again.\n");
            } 
	    else if (guess > number) {
                System.out.println("\t\t\t\tToo high, try again.\n");
            }
	    else {
                System.out.println("\n\t\tCongratulations, you guessed the number in " + tries + " tries!\n");
            }
        }
    }
}