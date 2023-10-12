// **************************************************************************************************
// Major Project Assignment - CMIS 202
// Name:   Michelle Lui
// Description:  The code will ask the user questions to create a personalized skincare routine
// ***********************************************************************************************

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SkincareRoutineQuiz {

    public static void main(String[] args) {
        SkincareRoutineQuiz quiz = new SkincareRoutineQuiz();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skincare Routine Quiz");
        System.out.println("Answer the following questions to get your personalized skincare routine.");
        System.out.println();

        ArrayList<SkincareProduct> skincareProducts = new ArrayList<>();

        //Cleansers
        skincareProducts.add(new SkincareProduct("First Aid Beauty: Pure Skin Face Cleanser", "Cleanser"));
        skincareProducts.add(new SkincareProduct("innisfree: Green Tea Hyaluronic Acid Face Cleanser", "Cleanser"));
        skincareProducts.add(new SkincareProduct("Beauty of Joseon: Ginseng Cleansing Oil", "Cleanser"));
        skincareProducts.add(new SkincareProduct("COSRX: Low pH Good Morning Gel Cleanser", "Cleanser"));
        skincareProducts.add(new SkincareProduct("The INKEY List: Oat Makeup Removing Cleansing Balm", "Cleanser"));


        //Essence/Toners
        skincareProducts.add(new SkincareProduct("COSRX: Advanced Snail 96 Mucin Power Essence", "Essense/Toners"));
        skincareProducts.add(new SkincareProduct("COSRX: Full Fit Propolis Synergy Toner", "Essense/Toners"));
        skincareProducts.add(new SkincareProduct("Haruharu Wonder: Black Rice Hyaluronic Toner", "Essense/Toners"));
        skincareProducts.add(new SkincareProduct("Beauty of Joseon: Ginseng Essence Water", "Essense/Toners"));


        //Serums
        skincareProducts.add(new SkincareProduct("COSRX: Full Fit Propolis Light Ampoule", "Serum"));
        skincareProducts.add(new SkincareProduct("Beauty of Joseon: Glow Serum : Propolis + Niacinamide", "Serum"));
        skincareProducts.add(new SkincareProduct("Beauty of Joseon: Calming serum : Green tea + Panthenol", "Serum"));
        skincareProducts.add(new SkincareProduct("Beauty of Joseon: Glow Deep Serum : Rice + Alpha Arbutin", "Serum"));
        skincareProducts.add(new SkincareProduct("Beauty of Joseon: Revive Serum : Ginseng + Snail Mucin", "Serum"));


        //Moisturizer
        skincareProducts.add(new SkincareProduct("innisfree: Dewy Glow Moisturizer with Cherry Blossom & Niacinamide", "Moisturizer"));
        skincareProducts.add(new SkincareProduct("COSRX: Advanced Snail 92 All In One Cream", "Moisturizer"));
        skincareProducts.add(new SkincareProduct("COSRX: Full Fit Propolis Light Cream with Honey & Royal Jelly Extract", "Moisturizer"));
        skincareProducts.add(new SkincareProduct("COSRX: Hydrium Green Tea Aqua Soothing Gel Cream", "Moisturizer"));
        skincareProducts.add(new SkincareProduct("ETUDE: SoonJung 2x Barrier Intensive Cream", "Moisturizer"));


        //Sunscreen
        skincareProducts.add(new SkincareProduct("Beauty of Joseon Relief Sun: Rice + Probiotics", "Sunscreen"));
        skincareProducts.add(new SkincareProduct("innisfree: Daily UV Defense Invisible Broad Spectrum SPF 36 Sunscreen", "Sunscreen"));
        skincareProducts.add(new SkincareProduct("TOCOBO: Bio Watery Sun Cream SPF50+ PA++++", "Sunscreen"));
        skincareProducts.add(new SkincareProduct("Beauty of Joseon: Relief Sun:Matte Sun Stick : Mugwort + Camelia (SPF50+ PA++++)", "Sunscreen"));

        skincareProducts.sort(Comparator.comparing(SkincareProduct::getCategory));

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

        System.out.println();

        System.out.println("Question 2: What are your main skincare concerns?");
        System.out.println("a) Acne");
        System.out.println("b) Hyperpigmentation");
        System.out.println("c) Redness");
        System.out.println("d) Fine lines/wrinkles");
        System.out.println("e) None of the above");
        System.out.print("Your answer: ");
        char answer2 = Character.toLowerCase(scanner.next().charAt(0));


        System.out.println();

        // Based on the user's total score, provide skincare routine recommendations
        if (score == 2) {
            System.out.println("Your personalized skincare routine for dry skin with concerns is ");
        } else if (score == 3) {
            System.out.println("Your personalized skincare routine for combination skin with concerns is...");
        } else if (score == 4) {
            System.out.println("Your personalized skincare routine for normal skin with concerns is...");
        } else if (score == 1){
            System.out.println("Your personalized skincare routine for oily skin with concerns is...");
        } else {
            System.out.println("Invalid input. Please enter a valid option.");
        }

        scanner.close();


    }
}
