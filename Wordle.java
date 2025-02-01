
import java.util.*;

public class Wordle {
    public static void main(String[] args){
        try {if (!(args[0].toUpperCase()).matches("[A-Z]*")|| args[0].length() != 5){
            System.out.println("Invalid input please enter 5-letter secret word");
            System.exit(0);
            }
        }
        catch (Exception e) {
            System.out.println("Invalid input please enter 5-letter secret word");
            System.exit(0);
        }
        String secretWord = args[0].toUpperCase();                //it contains secret word
        Scanner input = new Scanner(System.in);                 //it gets user input
        Set<Character> right = new HashSet<>();             //it makes a set with right word below with wrong word
        Set<Character> wrong = new HashSet<>();
        ArrayList<Character> rightAnswer = new ArrayList<>(Arrays.asList('_','_','_','_','_'));   //it holds correct guess
        ArrayList<Character> secretList = new ArrayList<>(); //this hold secret word list
        for (int j=0;j <5;j++){
            secretList.add(secretWord.charAt(j));
        }

        String userInput;

        System.out.println("--- WORDLE --- \nFeedback: _____\nChances: ******");

        for (int i=1;i<7;i++) {
            do {
                System.out.print("\nEnter your guess (5-letter word): ");
                userInput = input.nextLine().toUpperCase();
            } while ((!userInput.matches("[A-Z]*")) || (userInput.length() != 5));     //this get user input and again if wrong
            if (userInput.equals(secretWord)){
                System.out.println("GREAT! Number of Guess:"+ i);
                System.out.println("--- END ---");
                System.exit(0);
            }
            else {
                for (int j=0;j<5;j++){
                    Character current = userInput.charAt(j);
                    if (secretWord.contains(String.valueOf(current))){  //it checks if the secret word has that letter if yes then go to next if and if not then put in wrong
                        if (current.equals(secretWord.charAt(j))){            //it checks the location if yes then add into rightAnswer if not then add into right
                            rightAnswer.set(j,current);
                            if (Collections.frequency(rightAnswer,current) == Collections.frequency(secretList,current)){   //check if all are guessed to remove
                                right.remove(current);
                            }
                        }
                        else {
                            right.add(current);
                        }
                    }
                    else{
                        wrong.add(current);
                    }
                }
            }
            System.out.print("Attempts Remaining: ");        //it print result
            for (int k=0;k<6-i;k++){
                System.out.print("*");
            }
            System.out.print("\nFeedback: ");
            for (int j=0;j<5;j++){
                System.out.print(rightAnswer.get(j));
            }
            System.out.print("\nCharacters in the wordle: ");
            System.out.print(right);
            System.out.print("\nCharacter not in the wordle: ");
            System.out.print(wrong);
            System.out.println();
        }
        System.out.print("Correct word: ");
        System.out.print(secretWord);
        System.out.println("\n--- END ---");
        System.exit(0);






    }
}
