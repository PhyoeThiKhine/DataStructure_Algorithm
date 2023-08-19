package code;

public class MyLinkedList {
    public class Node {
        int data;
        Node next;
        public Node(int d){
            data = d;
        }
    }
    Node head = null;
    
    public void add(int d){
        Node p = new Node(d);
        p.next = head;
        head = p;
    }

    public void insert(int d){
        Node t = new Node(d);
        Node p = head;
        Node prev = null;
        while ((p != null) && (p.data < d)){
            prev = p;
            p = p.next;
        }
        if (prev == null) {
            t.next = head;
            head = t;
        }
        else {
            prev.next = t;
            t.next = p;
        }
    }


    public int find(int d){
        Node p = head;
        //int count = 0;
        while(p!=null) {
            if(p.data==d) {
                return size();
            }
            //count++;
            p = p.next;
        }
        return -1;
    }
    public void delete(int d){
        Node t = new Node(0); // temporary node since if the data we want to delete is the data of the first node.
        t.next = head; 
        Node p = t; // need to copy because we need to set the head back after travasing
        Node prev = null; // to know the previous node
        while ((p.next != null) && (p.next.data != d)){
            prev = p;
            p = p.next;
        }
        if (p.next!= null){ // if the node we want to delete is not the last node
            //p.next = p.next.next;
            prev.next = p.next;
        }
        else { // if the node we want to delete is the last node
            prev.next = null;
        }
        head = t.next;
    }

    public void printLinkedlist(){
        Node p = head;
        System.out.print("head->");
        while (p!=null){
            System.out.print("("+ p.data +")");
            p = p.next;
            if (p!=null) {
                System.out.print("->");
            }
            else{
                System.out.print("->null");
            }
        }
        System.out.println();
    }

    private int size(){
        Node p = head;
        int count = 0;
        while (p!=null){
            count++;
            p = p.next;
        }
        return count;
    }

    public void add(int []d){
        for(int i = 0; i< d.length; i++){
            add(d[i]);
        }
        // Reverse the linked list to correct the order
        head = reverseLinkedList(head);
    }

    public void insert (int []d){
        for(int i = 0; i< d.length; i++){
            insert(d[i]);
        }
    }

    public void q1_rotate_clockwise(int k){ //Rotate the linked list counter-clockwise by k nodes where k is a positive integer not larger than the list’s size.
        if (k==0) { //no rotation needed
            return;
        }
        int i = 1;
        Node p = head;
        while(i<k && p != null){
            i++;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        Node newHead= p.next; // new head, where rotation starts
        p.next = null; // make the end null
        Node tail = newHead;
        while(tail.next!=null){
            tail = tail.next;
        }
        tail.next = head;
        head = newHead;
        
    }
    public void q2_reverse(){// Reverse Linkedlist
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        Node p = head;
        while (p!=null){
            p=p.next;
        }
    } 
    

    public void q3_remove_dup() { // Remove duplicates (node with duplicate values) from the list (if exists).
       Node p = head;
       while (p!=null){
         if(p.next != null && p.data == p.next.data){
            p.next = p.next.next;
         }
         p = p.next;
       }
    }

    private Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
    
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
    
        return prev;
    }

    public void q4_increment_digits() { //Given a number represented in a linked list such that each digit corresponds to a node in a linked list. 
                                        //Add 1 to it. For example, 1999 is represented as (1->9->9->9) and adding 1 to it should result in (2->0->0->0)
        /*Node p = head;
        //check length of the linked list
        int length = 0;
        while (p!=null){
            p = p.next;
            length++;
        }
        int multiple = 1;
        while(length>0){
            multiple *= 10;
            length--;
        }
        int value = 0;
        while (p!=null){
            value += p.data *multiple;
            multiple/=10;
            p = p.next;
        }
        value += 1;
        Node t = new Node(0);
        while (value % 2 !=0){
            t.data = value % 10;
            value = value / 10;
            t = t.next;
        }
        head = t;*/

      
            head = reverseLinkedList(head);
        
            Node p = head;
            int carry = 1;
        
            while (p != null && carry > 0) {
                int sum = p.data + carry;
                p.data = sum % 10;
                carry = sum / 10;
                p = p.next;
            }
        
            if (carry > 0) {
                // If carry is still present, create a new node for it
                Node newNode = new Node(carry);
                p.next = newNode;
            }
            head = reverseLinkedList(head);
    
    }

    public boolean q5_isPalindrome() { // Given a singly linked list of integers, the method returns true if the list is palindrome, else false.
        if (head == null || head.next == null) {
            // empty or contains only one node, it is a palindrome.
            return true;
        }
    
        // Find the middle using two pointers (p and q).
        Node p = head;
        Node q = head;
        while (p != null && p.next != null) {
            q = q.next;
            p = p.next.next;
        }
    
        // Reverse the second half of the linked list starting from q.
        Node reversedSecondHalf = reverseLinkedList(q);
    
        // Compare the first half with the reversed second half for palindrome check.
        Node firstHalf = head;
        while (reversedSecondHalf != null) {
            if (firstHalf.data != reversedSecondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }
        return true;


   }
   
}
