package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Project p = new Project();
        LinkedList l = new LinkedList();
        Scanner s = new Scanner(System.in);
        LinkedList b = new LinkedList();
        boolean quit = false;
        int choice = -1;

        printOptions();

        while(!quit) {
            System.out.println("Enter choice: ");
            choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 0:
                    printOptions();
                    break;

                case 1:
                    p.Add(b);
                    break;

                case 2:
                    p.update(b);
                    break;

                case 3:
                    p.Delete(b);
                    break;

                case 4:
                    int searchby;
                    while (true) {
                        try {
                            System.out.println("[1] Search by Name.");
                            System.out.println("[2] Search by ID.");
                            searchby = s.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println();
                            System.out.println("Please input an integer number!");
                            s.nextLine();
                        }
                    }
                    if (searchby == 1) {//search by name
                            p.SearchName(b);
                            break;
                        }else if (searchby == 2) {//Search by id
                            p.SearchId(b);
                            break;
                        }else{
                            System.out.println("Please input 1 or 2");
                        }
                    break;

                case 5:
                    p.Display(b);
                    break;

                case 6:
                    System.out.println("Exiting Program Gracefully...");
                    quit = true;
                    break;
            }
        }


    }
    public static void printOptions(){
        System.out.println("0. For Options");
        System.out.println("1. Add");
        System.out.println("2. Update List");
        System.out.println("3. Delete");
        System.out.println("4. Search from List");
        System.out.println("5. Display List");
        System.out.println("6. Quit");

    }
}