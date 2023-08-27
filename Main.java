package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int ch;

        Scanner sc = new Scanner(System.in);
        BudgetCalculate bg = new BudgetCalculate();
        NewsPaperOpeations n = new NewsPaperOpeations();

        do {
            System.out.println("1. Enter the newspaper details");
            System.out.println("2. Print newspaper data");
            System.out.println("3. weekly affordable newspapers");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
            sc.nextLine(); 
            switch (ch) {
                case 1:
                    n.addData(sc, bg);
                    break;
                case 2:
                    System.out.println("Enter the newspaper name to print data: ");
                    String printName = sc.nextLine();
                    bg.printNewspaperData(printName);
                    break;
                case 3:
                    System.out.println("Enter your weekly budget: ");
                    double budget = sc.nextDouble();
                    sc.nextLine(); // Consume the newline character
                    List<String> affordableNewspapers = bg.findNewspaperCombinationWithinBudget(budget);
                    if (affordableNewspapers.isEmpty()) {
                        System.out.println("No newspapers are affordable within the given budget.");
                    } else {
                        System.out.println("Affordable newspapers within your budget: " + affordableNewspapers);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Choice not found");
                    break;
            }
        } while (ch != 3);

        sc.close();
    }
}
