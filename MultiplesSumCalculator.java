package com.Paan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiplesSumCalculator {

    public static void multiplesSumCalculator() {
        //Initialise local objects
        int upperbound=0;
        int trailingSum=0;
        List<Integer> multiples = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //Start user input loop
    CalculatorLoop:
    while(true) {

        //Enter valid upper-bound
        System.out.println("Enter Upper Bound");
        if (scanner.hasNextInt()) {
            upperbound = scanner.nextInt();
        } else {
            break;
        }

        //Keep entering numbers to see live sum of multiples
        scanner.nextLine();
        while (true) {
            System.out.println("Enter a number with multiples");

            if (scanner.hasNextInt()) {
                int myNumber = scanner.nextInt();
                if (myNumber <= upperbound) {
                    findMultiples:
                    for (int i = myNumber; i < upperbound; i++) {
                        if (i % myNumber == 0) {
                            //Verify that if previous multiples have already been found, this multiple isn't also added
                            //to the trailing sum
                                for (int j = 0; j < multiples.size(); j++) {
                                    if (i == multiples.get(j)) {
                                        continue findMultiples;
                                    }
                                }

                                multiples.add(i);
                                trailingSum += i;
                        }
                    }
                }
                else {
                    System.out.println("Please enter a number lower than the upper bound");
                }

                //Print trailing sum
                System.out.println("The trailing sum is = " + trailingSum);
                scanner.nextLine();
            } else {
                System.out.println("The trailing sum is = " + trailingSum);
                break CalculatorLoop;
            }
        }
    }

    }
}
