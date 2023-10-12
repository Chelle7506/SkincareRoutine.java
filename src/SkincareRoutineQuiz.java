// **************************************************************************************************
// Major Project Assignment - CMIS 202
// Name:   Michelle Lui
// Description:  The code will ask the user questions to create a personalized skincare routine
// ***********************************************************************************************

import java.util.ArrayList;
import java.util.Scanner;

public class SkincareRoutineQuiz {

    public static void main(String[] args) {
        SkincareRoutineQuiz quiz = new SkincareRoutineQuiz();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skincare Routine Quiz");
        System.out.println("Answer the following questions to get your personalized skincare routine.");
        System.out.println();

        // Example array to be sorted using merge sort
        /*
        - quiz start

        - scale of 1 - 10 on skin concerns
        - scale dependent on ratings of importantance
        - Questions:
        - what is your skin type?
        - what concerns do you have for your skin
          - on a scale of 1 - 10 how bad is your acne
          - on a scale of 1 - 10 how bad is your hyperpigmentation
          - on a scale of 1 - 10 how severe is your redness
          - on a scale of 1 - 10 how severe is your wrinkles and fine lines
          - Based on your results, we will prioritize "x" as your concern, here are some recommendations
        -......

        -sort depending on ratings
        -suggest products depending on most important concerns

         */

        //ArrayList<ArrayList<Integer>> twoDArrayList = new ArrayList<>();

        Scanner scanner1 = new Scanner(System.in);
        ArrayList[][] prefrences = new ArrayList[2][4];

        System.out.println("Welcome heres some questions");
        System.out.println("whats ur skin type? A, b, c, d");


        System.out.println("whats ur hair type? A, b, c, d");


        System.out.println("whats ur face type? A, b, c, d");

        int score = 0;

        System.out.println("Question 1: What is your skin type?");
        System.out.println("a) Oily");
        System.out.println("b) Dry");
        System.out.println("c) Combination");
        System.out.println("d) Normal");
        System.out.print("Your answer: ");
        char answer1 = Character.toLowerCase(scanner.next().charAt(0));

        if (answer1 == 'a') {
            score += 1;
        } else if (answer1 == 'b') {
            score += 2;
        } else if (answer1 == 'c') {
            score += 3;
        } else if (answer1 == 'd') {
            score += 4;
        } else {
            System.out.println("Invalid input. Please enter a valid option.");
        }

        System.out.println("Question 2: What are your main skincare concerns?");
        System.out.println("a) Acne");
        System.out.println("b) Hyperpigmentation");
        System.out.println("c) Redness");
        System.out.println("d) Fine lines/wrinkles");
        System.out.println("e) None of the above");
        System.out.print("Your answer: ");
        char answer2 = Character.toLowerCase(scanner.next().charAt(0));

        if (answer2 == 'a') {
            score += 2;
        } else if (answer2 == 'b') {
            score += 3;
        } else if (answer2 == 'c') {
            score += 2;
        } else if (answer2 == 'd') {
            score += 3;
        } else if (answer2 == 'e') {
            score += 0;
        } else {
            System.out.println("Invalid input. Please enter a valid option.");
        }

        // Add more questions and scoring logic for other questions

        System.out.println();

        // Based on the user's total score, provide skincare routine recommendations
        if (score >= 8) {
            System.out.println("Your personalized skincare routine for dry skin with concerns is...");
        } else if (score >= 6) {
            System.out.println("Your personalized skincare routine for combination skin with concerns is...");
        } else if (score >= 4) {
            System.out.println("Your personalized skincare routine for normal skin with concerns is...");
        } else {
            System.out.println("Your personalized skincare routine for oily skin with concerns is...");
        }

        scanner.close();



    }
}
