// **************************************************************************************************
// Major Project Assignment - CMIS 202
// Name:   Michelle Lui
// Description:  The code will ask the user questions to create a personalized skincare routine
// ***********************************************************************************************

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkincareRoutineQuiz {

    public static void main(String[] args) {
        SkincareRoutineQuiz program = new SkincareRoutineQuiz();
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
        skincareProducts.add(new SkincareProduct("Beauty of Joseon: Relief Sun: Rice + Probiotics", "Sunscreen"));
        skincareProducts.add(new SkincareProduct("innisfree: Daily UV Defense Invisible Broad Spectrum SPF 36 Sunscreen", "Sunscreen"));
        skincareProducts.add(new SkincareProduct("TOCOBO: Bio Watery Sun Cream SPF50+ PA++++", "Sunscreen"));
        skincareProducts.add(new SkincareProduct("Beauty of Joseon: Relief Sun:Matte Sun Stick : Mugwort + Camelia (SPF50+ PA++++)", "Sunscreen"));

        skincareProducts.sort(Comparator.comparing(SkincareProduct::getCategory));

        SkincareHashTable skincareHashTable = new SkincareHashTable();

        // Adding skincare products to the hash table
        skincareHashTable.put("Cleanser", new SkincareProduct("First Aid Beauty: Pure Skin Face Cleanser", "Cleanser"));
        skincareHashTable.put("Essence", new SkincareProduct("COSRX: Advanced Snail 96 Mucin Power Essence", "Essence/Toner"));
        skincareHashTable.put("Serum", new SkincareProduct("COSRX: Full Fit Propolis Light Ampoule", "Serum"));

        int numThreads = 3; // Number of threads to create
        int productsPerThread = skincareProducts.size() / numThreads;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        // Create and start threads for processing skincare products
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * productsPerThread;
            int endIndex = (i == numThreads - 1) ? skincareProducts.size() - 1 : startIndex + productsPerThread - 1;

            SkincareThread thread = new SkincareThread(skincareProducts, startIndex, endIndex);
            executorService.submit(thread);
        }

        // Shutdown the ExecutorService to stop accepting new tasks
        executorService.shutdown();

        // Wait for all submitted tasks to complete or timeout after a certain period
        try {
            executorService.awaitTermination(10, java.util.concurrent.TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int score = 0;


        System.out.println("\nQuestion 1: What is your skin type?");
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
            System.out.println("Your personalized skincare routine for dry skin with concerns is: \n");
        } else if (score == 3) {
            System.out.println("Your personalized skincare routine for combination skin with concerns is: \n");
        } else if (score == 4) {
            System.out.println("Your personalized skincare routine for normal skin with concerns is: \n");
        } else if (score == 1){
            System.out.println("Your personalized skincare routine for oily skin with concerns is: \n");
        } else {
            System.out.println("Invalid input. Please enter a valid option.");
        }


        //Cleanser recommendations
        for (SkincareProduct product : skincareProducts) {
            if (product.getCategory().equals("Cleanser")) {
                System.out.println(product.getName());
            }
        }

        System.out.println();

        //Essence/Toner recommendations
        for (SkincareProduct product : skincareProducts) {
            if (product.getCategory().equals("Essence/Toner")) {
                System.out.println(product.getName());
            }
        }

        System.out.println();

        //Serum recommendations
        for (SkincareProduct product : skincareProducts) {
            if (product.getCategory().equals("Serum")) {
                System.out.println(product.getName());
            }
        }

        System.out.println();

        //Moisturizer recommendations
        for (SkincareProduct product : skincareProducts) {
            if (product.getCategory().equals("Moisturizer")) {
                System.out.println(product.getName());
            }
        }

        System.out.println();

        //Sunscreen recommendations
        for (SkincareProduct product : skincareProducts) {
            if (product.getCategory().equals("Sunscreen")) {
                System.out.println(product.getName());
            }
        }


        // Retrieving a skincare product from the hash table
        SkincareProduct foundProduct = skincareHashTable.get("Essence");
        if (foundProduct != null) {
            System.out.println("Product found: " + foundProduct);
        } else {
            System.out.println("Product not found.");
        }



        scanner.close();

        System.out.println("\nThank you for taking the time to do this short little skincare routine quiz! \n" +
                "Many of the results may look similar as the product can be used for mulitple skin \n" +
                "types and overall depends on the person!\n");

        ArrayList<String> skincareCategories = new ArrayList<>();
        skincareCategories.add("Sunscreen");
        skincareCategories.add("Serum");
        skincareCategories.add("Cleanser");
        skincareCategories.add("Moisturizer");
        skincareCategories.add("Essence/Toner");

        System.out.println("\nOriginal Categories: " + skincareCategories);

        mergeSort(skincareCategories, 0, skincareCategories.size() - 1);

        System.out.println("Sorted Categories: " + skincareCategories);

        // Create a queue and enqueue sorted categories
        Queue<String> sortedCategoriesQueue = new LinkedList<>(skincareCategories);
        System.out.println("Categories in Queue: " + sortedCategoriesQueue);

        // Dequeue and print each category
        System.out.println();
        System.out.println("Dequeued Categories:");
        while (!sortedCategoriesQueue.isEmpty()) {
            System.out.println(sortedCategoriesQueue.poll());
        }
    }


    private static void mergeSort(ArrayList<String> categories, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(categories, left, mid);
            mergeSort(categories, mid + 1, right);

            merge(categories, left, mid, right);
        }
    }

    private static void merge(ArrayList<String> categories, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        ArrayList<String> leftList = new ArrayList<>(categories.subList(left, mid + 1));
        ArrayList<String> rightList = new ArrayList<>(categories.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftList.get(i).compareTo(rightList.get(j)) <= 0) {
                categories.set(k++, leftList.get(i++));
            } else {
                categories.set(k++, rightList.get(j++));
            }
        }

        while (i < n1) {
            categories.set(k++, leftList.get(i++));
        }

        while (j < n2) {
            categories.set(k++, rightList.get(j++));
        }

    }
}
