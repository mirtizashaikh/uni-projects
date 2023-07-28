package com.company;

public class LinkedList {
    Node Head = null;
    Node Tail = null;

    Node create(String title, String author, String categories, int num, double price){
        Node node = new Node();
        if (node != null) {     // Node allocated
            node.Title = title;
            node.Author = author;
            node.category = categories;
            node.num = num;
            node.price = price;
            node.Next = null;
            node.Prev = null;
        }
        return node;
    }

    boolean Add(String title, String author, String categories, int num, double price){
        boolean retval = false;
        Node node = create( title, author, categories, num, price);
        if (node != null) {     // NODE EXISTS
            if (Head == null) {      // Empty List
                Head = Tail = node;
            }else{      // Non Empty list , make it tail
                Tail.Next = node;
                node.Prev = Tail;
                Tail = node;
            }
            arrange_id();
            retval = true;
        }
        return retval;
    }

    boolean insert(int loc,String title, String author, String categories, int num, double price) {
        boolean retval = false;
        Node node = create(title, author, categories, num, price);
        if (node != null) {// NODE Allocated
            if (Head == null) {//List is empty
                Head = Tail = node;
            }else{//there is a list
                if (loc == 1) {//first node
                    Head.Prev = node;
                    node.Next = Head;
                    Head = node;
                }else if (loc>1) {//middle or last
                    Node temp = Head;
                    for (int i = 1; i < loc && temp != null; i++) {
                        temp = temp.Next;
                    }
                    if (temp == null || temp == Tail) {// Last Node
                        node.Prev = Tail;
                        Tail.Next = node;
                        Tail = node;
                    }else{// Middle
                        temp.Next.Prev = node;
                        node.Next = temp.Next;
                        node.Prev = temp;
                        temp.Next = node;
                    }
                }
            }
            arrange_id();
            retval = true;
        }
        return retval;
    }

    void arrange_id () {
        if (Head != null) {
            Node temp = Head;
            for (int i = 1; temp!=null; i++) {
                temp.ID = i;
                temp = temp.Next;
            }
        }

    }

    boolean update (int loc,String title, String author, String categories, int num, double price) {// search for node by loc and update it
        boolean retval = false;
        Node node = SearchId(loc);
        node.Title = title;
        node.Author = author;
        node.category = categories;
        node.num = num;
        node.price = price;
        return retval;
    }

    boolean DeleteNode(int id) {
        boolean retval = false;
        if(Head != null){ // Node exists
            if(id == 1){ // DElete the first node
                if(Head == Tail) {// The List contains only one node
                    Head = Tail = null;
                }
                else{ // The list has multiple nodes
                    Head = Head.Next;
                    Head.Prev = null;
                }
                retval = true;
            }
            else if (id > 1) { // middle or last
                Node Current;
                Current = Head;
                for(int i = 1 ; i < id && Current != null ; i++){
                    Current = Current.Next;
                }
                if(Current != null){
                    if(Current == Tail){ // Last
                        Tail = Tail.Prev;
                        Tail.Next = null;
                    }
                    else{ // Middle
                        Current.Prev.Next = Current.Next;
                        Current.Next.Prev = Current.Prev;
                    }
                    retval = true;
                }
            }
        }
        return retval;
    }

    Node SearchId(int id) {
        Node node = Head;
        if (Head != null) {// there is a list
            while (node.ID != id && node != null) {
                node = node.Next;
            }
        }
        return node;
    }

    Node SearchName(String Both){
        Node node;
        node=Head;
        while(node != null && node.Title.equalsIgnoreCase(Both) != true && node.Author.equalsIgnoreCase(Both) != true ){
            node = node.Next;
        }
        if(node==null){//node not exists
            System.out.println(node);
        }else{//node exists
            System.out.println( "The ID of the Node:" + node.ID);
        }
        return node;

    }


    void Display(){

        if(Head== null){
            System.out.println("Empty LinkedList");
        }
        else{
            Node node = Head;
            //Display in a Table
            //first the header
            System.out.println("+----+---------------------------+-----------------+------------+--------+---------+");
            System.out.println("| ID | Title                     | Author          | Category   | Copies | Price   |");
            System.out.println("+----+---------------------------+-----------------+------------+--------+---------+");
            while(node != null){
                // id=> 2   ,title => 25     , Author =>15    , categories => 10   , copies => 6    , price =>6
                String id = space(String.valueOf(node.ID),2);
                String title = space(node.Title, 25);
                String author = space(node.Author, 15);
                String cat = space(node.category , 10);
                String cop = space(String.valueOf(node.num), 6);
                String price = space(String.valueOf(node.price), 6);
                System.out.println("| "
                        +id     +" | "
                        +title  +" | "
                        +author +" | "
                        +cat    +" | "
                        +cop    +" | "
                        +price  +"$ |");
                node = node.Next;
            }
            System.out.println("+----+---------------------------+-----------------+------------+--------+---------+");
            int[] Total = CountTotalData();
            System.out.println("Total books  : "+Total[0]);
            System.out.println("Total copies : "+Total[1]);
            System.out.println("Total prices : "+Total[2]+" $");
        }
    }

    String space(String data,int space){
        int length = data.length();
        String new_space = "";
        String new_data = null;
        if (length <= space) { // space is enough to display the string
            int j = space - length;//to calculate the space that should be after the string
            for (int i = 1; i <= j; i++) {
                new_space = new_space + " ";
            }
            new_data = data+new_space;
        }else{//space is not enough for the string
            new_data = data.substring(0, space-3)+"...";
        }
        return new_data;
    }
    int[] CountTotalData() { // to count the total books, available copies and price;
        int[] Total = new int[3];
        if (Head != null) {//list not empty
            Node node = Head;
            while (node != null) {
                Total[0] ++; // number of Books
                Total[1] += node.num; // Total available copies
                Total[2] += node.price; // Total price
                node = node.Next;
            }
        }
        return Total;
    }

    void ClearAll(){
        Head = Tail=null;
    }
}
