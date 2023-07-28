package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Project {
    public static int mainMenu() {
        System.out.println("  _     _ _                            __  __                                                   _     ____            _                 ");
        System.out.println(" | |   (_) |__  _ __ __ _ _ __ _   _  |  \\/  | __ _ _ __   __ _  __ _  ___ _ __ ___   ___ _ __ | |_  / ___| _   _ ___| |_ ___ _ __ ___  ");
        System.out.println(" | |   | | '_ \\| '__/ _` | '__| | | | | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '_ ` _ \\ / _ \\ '_ \\| __| \\___ \\| | | / __| __/ _ \\ '_ ` _ \\ ");
        System.out.println(" | |___| | |_) | | | (_| | |  | |_| | | |  | | (_| | | | | (_| | (_| |  __/ | | | | |  __/ | | | |_   ___) | |_| \\__ \\ ||  __/ | | | | |");
        System.out.println(" |_____|_|_.__/|_|  \\__,_|_|   \\__, | |_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_| |_| |_|\\___|_| |_|\\__| |____/ \\__, |___/\\__\\___|_| |_| |_|");
        System.out.println("                               |___/                            |___/                                       |___/                       ");
        System.out.println();
        System.out.println();
        System.out.println("[1] Add a Book.");
        System.out.println("[2] Update a Book.");
        System.out.println("[3] Delete a Book.");
        System.out.println("[4] Search for a Book.");
        System.out.println("[5] Display All Books.");
        System.out.println("[6] Exit");
        System.out.println();
        Scanner s = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                choice = s.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Please input an integer number!");
                s.nextLine();
            }
        }
        return choice;
    }

    public static void Add(LinkedList b) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Do you want to add in a specific location?  (y/n)      (0 to exit)");
            char specific = s.next().charAt(0);
            if (specific == '0') {
                break;
            }else if (specific == 'n' || specific == 'N') { // Add in the last with linkedlist.add()
                System.out.println("Please fill in all the fields. ");
                String title,author,cat;
                while (true) {
                    System.out.println("Title  :");
                    s.nextLine();
                    title = s.nextLine();
                    if (title == null){
                        System.out.println();
                        System.out.println("Please fill this field!");
                        System.out.println();
                    }
                    else
                        break;
                }
                while (true) {
                    System.out.println("Author :");
                    author = s.nextLine();
                    if (author == null){
                        System.out.println();
                        System.out.println("Please fill this field!");
                        System.out.println();
                    }
                    else
                        break;
                }
                while (true) {
                    System.out.println("Categories :");
                    cat = s.nextLine();
                    if (cat == null){
                        System.out.println();
                        System.out.println("Please fill this field!");
                        System.out.println();
                    }
                    else
                        break;
                }
                Integer num;
                System.out.println("Enter the number of copies:");
                num = s.nextInt();
                Double price;
                while (true) {
                    try {
                        System.out.println("Price :");
                        price = s.nextDouble();
                        if (price == null) {
                            System.out.println();
                            System.out.println("Please fill this field!");
                            System.out.println();
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println("Please input a correct integer number");
                        System.out.println();
                        s.nextLine();
                    }
                }
                boolean retval = b.Add(title, author, cat, num, price);
                if (retval){
                    System.out.println();
                    System.out.println("your book was added successfully");
                    break;
                }else{
                    System.out.println("Somthing went wrong!!");
                }
            }else if (specific == 'y' || specific == 'Y') {// Add in a specific location with linkedlist.insert()
                System.out.println("Please fill in all the fields. ");
                String title,author,cat;
                while (true) {
                    System.out.println("Title  :");
                    s.nextLine();
                    title = s.nextLine();
                    if (title == null){
                        System.out.println();
                        System.out.println("Please fill this field!");
                        System.out.println();
                    }
                    else
                        break;
                }
                while (true) {
                    System.out.println("Author :");
                    author = s.nextLine();
                    if (author == null){
                        System.out.println();
                        System.out.println("Please fill this field!");
                        System.out.println();
                    }
                    else
                        break;
                }
                while (true) {
                    System.out.println("Categories :");
                    cat = s.nextLine();
                    if (cat == null){
                        System.out.println();
                        System.out.println("Please fill this field!");
                        System.out.println();
                    }
                    else
                        break;
                }
                Integer num;
                while (true) {
                    try {
                        System.out.println("Number of copies :");
                        num = s.nextInt();
                        if (num == null) {
                            System.out.println();
                            System.out.println("Please fill this field!");
                            System.out.println();
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println("Please input a correct integer number");
                        s.nextLine();
                    }
                }
                Double price;
                while (true) {
                    try {
                        System.out.println("Price :");
                        price = s.nextDouble();
                        if (price == null) {
                            System.out.println();
                            System.out.println("Please fill this field!");
                            System.out.println();
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println("Please input a correct integer number");
                        System.out.println();
                        s.nextLine();
                    }
                }
                Integer loc;
                while (true) {
                    try {
                        System.out.println("Enter the Location :");
                        loc = s.nextInt();
                        if (loc == null) {
                            System.out.println();
                            System.out.println("Please fill this field!");
                            System.out.println();
                            continue;
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println();
                        System.out.println("Please input a correct integer number");
                        s.nextLine();
                    }
                }
                boolean retval = b.insert(loc, title, author, cat, num, price);
                if (retval){ // true
                    System.out.println();
                    System.out.println("your book was added successfully");
                    break;
                }else{ // false
                    System.out.println("Somthing went wrong!!");
                }
            }else{//Wrong answer and ask again
                System.out.println();
                System.out.println("Please write a correct answer !!");
            }
        }

    }

    public static void update(LinkedList b) {
        //we need to know the book that will update
        Scanner s = new Scanner(System.in);
        int id;
        while (true) {
            try {
                System.out.println("Enter the id of the Book you want to update :");
                id = s.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input a correct integer number");
                s.nextLine();
            }
        }
        Node node = b.SearchId(id);
        if (node != null) {
            System.out.println(node.ID+"\t"+node.Title+"\t"+node.Author+"\t"+node.category+"\t"+node.num+"\t"+node.price);
            System.out.println("Do you want to update it?");
            System.out.println("Title  :");
            s.nextLine();
            String title = s.nextLine();
            if ("".equals(title))    //if the user enter with no input then this field will not be changed
                title = node.Title;
            System.out.println("Author :");
            String author = s.nextLine();
            if ("".equals(author))
                author = node.Author;
            System.out.println("Categories :");
            String cat = s.nextLine();
            if ("".equals(cat))
                cat = node.category;
            Integer num;
            while (true) {
                try {
                    System.out.println("Number of copies :");
                    num = s.nextInt();
                    if (num == null)
                        num = node.num;
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Please input an integer number!");
                    s.nextLine();
                }
            }
            Double price;
            while (true) {
                try {
                    System.out.println("Price :");
                    price = s.nextDouble();
                    if (price == null)
                        price = node.price;
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Please input an integer number!");
                    s.nextLine();
                }
            }
            b.update(id, title, author, cat, num, price);
            System.out.println("your book was updated ");
        }else{//node not exists
            System.out.println("The book not exists");
        }


    }

    public static void Delete(LinkedList b) {
        Scanner s = new Scanner(System.in);
        System.out.println("Do You want to delete all Books? (y/n)");
        char x = s.next().charAt(0);
        if (x=='y'||x=='Y') {//that will clear all in the list
            b.ClearAll();
            System.out.println("All books were deleted.");
        }else if (x=='n'||x=='N') {// delete one node in the list
            while (true) {
                int id;
                try {
                    System.out.println("Enter the id of the book that you want to delete :\t(0 to exit)");
                    id = s.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please input an integer number!");
                    s.nextLine();
                    continue;
                }
                if (id == 0)
                    break;
                Node node = b.SearchId(id);
                if (node != null) {
                    System.out.println("Do you want to delete this book?");
                    System.out.println(node.Title);
                    System.out.println("(y/n)");
                    char c = s.next().charAt(0);
                    if (c=='y'||c=='Y') {
                        b.DeleteNode(id);
                        System.out.println("The book was deleted");
                        break;
                    }else if (c=='n'||c=='N') {

                    }
                }else
                    System.out.println("The book is not exists");
            }
        }else{
            System.out.println("wrong answer");
        }

    }

    public static void SearchId(LinkedList b) {
        Scanner s = new Scanner(System.in);
        int id = 0;
        while (true) {
            try {
                System.out.println("Enter the id of the book :");
                id = s.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input an integer number!");
                s.nextLine();
            }
        }
        Node node = b.SearchId(id);
        if (node != null) { // node exists
            System.out.println( node.Title+"\t"+ node.Author+"\t"+ node.category+"\t"+ node.num+"\t"+node.price+"$");
        }else{ // node not exists
            System.out.println("The book not exists");
        }
    }

    public static void SearchName(LinkedList b) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the name of the author or the book title : ");
        String nm = s.nextLine();
        Node node = b.SearchName(nm);
        if (node != null) { // node exists
            System.out.println( node.Title+"\t"+ node.Author+"\t"+ node.category+"\t"+ node.num+"\t"+node.price+"$");
        }else{ // node not exists
            System.out.println("The book not exists");
        }
    }

    public static void Display(LinkedList b) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Do You want to display all Books? (y/n)");
            char x = s.next().charAt(0);
            if (x=='y'||x=='Y') {//Display all Books
                b.Display();
                break;
            }else if (x=='n'||x=='N') {// display one books
                int id;
                while (true) {
                    try {
                        System.out.println("Enter the id of the book:");
                        id = s.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Please input an integer number!");
                        s.nextLine();
                    }
                }
                Node node = b.SearchId(id); // select the node
                if (node != null) {//node exists
                    System.out.println("Title :"+ node.Title+"\t"+ node.Author+"\t"+ node.category+"\t:"+ node.num+"\t"+node.price+"$");
                    break;//to go out from the loop
                }else{// Node not exists - should enter correct id
                    System.out.println("The book not found");
                    //continue;//to repeat the loop
                }
            }else{// Answer not correct
                System.out.println("Please input a correct answer");
            }
        }//End while
    }
    }

