package DSLK;

import com.sun.security.jgss.GSSUtil;

public class List1648 {
    public static void main(String[] args) {
        MyList t=new MyList();
        Node p,q;
        Person x;
        int k;
        String []a={"A","B","C","D","E"};
        int []b={9,5,4,6,1};

        //1
        System.out.println("\n1. Test addlast and addmany");
        t.clear();
        t.addMany(a,b);
        t.traverse();
        p=t.searchByName("D");
        if(p==null){
            System.out.println("Not found");
        }else{
            System.out.println("The person is : ");
            t.visit(p);
            System.out.println();
        }

        //3
        System.out.println("\n3. Test addFirst(Person x),x=(x,30)");
        t.clear();
        t.addMany(a,b);
        t.traverse();
        x=new Person("x", 30);
        t.addFirst(x);
        t.traverse();

        //4
        System.out.println("\n3. Test insertafter (q,x),q=(B,17),x=(x,30)");
        t.clear();
        t.addMany(a,b);
        t.traverse();
        x=new Person("x", 30);
        q=t.searchByName("B");
        t.insertAfter(q,x);
        t.traverse();

        //5
        System.out.println("\n4. Test insertbefore");
    }



}
