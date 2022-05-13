package DSLK;

public class Node {
    Person infor;
    Node next;

    Node(Person x, Node q){
        infor = x;
        next = q;
    }

    Node (Person x){
        this(x,null);
    }
}
