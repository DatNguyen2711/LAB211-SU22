package DSLK;

public class MyList {
    Node head,tail;

    MyList(){
        head = tail = null;
    }

    boolean isEmpty(){
        return (head==null);
    }
    void clear(){
        head=tail=null;
    }
    //(1)
    void addLast(Person x){ // them vao cuoi danh sach 1 nut
        Node q = new Node(x);//tao ra nut moi co noi dung la x/'
        if(isEmpty()){
            head=tail=q;
            return;
        }
        tail.next = q;
        tail=q;
    }

    void visit(Node p){
        if(p!=null){
            System.out.println(p.infor);
        }
    }

    void traverse(){
        Node p = head;
        while(p!=null){
            visit(p);
            p=p.next;

        }
        System.out.println();
    }
    // (3)
    void addMany(String []a,int []b){
        int n,i;
        n=a.length;
        for(i=0;i<n;i++){
            addLast(new Person(a[i],b[i]));
        }
    }

    Node searchByName(String xName){
        Node p =head;
        while(p!=null){
            if(p.infor.name.equals(xName)){
                return (p);
            }
        }
        return (null);
    }

    Node searchByAge(int xAge){
        Node p = head;
        while(p != null){
            if(p!=null){
                return (p);
            }
            p=p.next;
        }
        return (null);
    }
    //(3)
    void addFirst(Person x){
        head = new Node(x,head);
        Node q = new Node(x);//tao ra nut moi co noi dung la x/'
        if(isEmpty()){
            head=tail=q;
            return;
        }
        head.next = q;
        head=q;
    }
    //(4)
    void insertAfter(Node q, Person x){//chen 1 nut co noi dung la x
        if(isEmpty() || q==null){
            return;
        }
        Node q1 = q.next;// cho q1 giu dia chi cua nut sau q
        Node p =new Node(x,q1);
        q.next=p;
        if(tail==q){
            tail=p;
        }
    }
    //(5)
    void insertBefore(Node q,Person x){
        if(isEmpty()||q==null){
            return;
        }
        if(q==head){
            addFirst(x);
            return;
        }
        Node f = head;
        while(f != null && f.next!=q){
            f=f.next;
        }
        if(f==null){
            return;
        }
        insertAfter(f,x);
        }

    //(6)
    void removeFirst(){
        if(isEmpty()){
            return;
        }
        head = head.next;
        if(head==null){
            tail =null;
        }
    }
    //(7)
    void remove(Node q){
        if(isEmpty()||q==null){
            return;
        }
        if(q==head){
            removeFirst();
            return;
        }
        Node f = head;
        while(f!=null && f.next !=q){
            f=f.next;//sau vong lap nay f tro vao nut truoc nut q
        }
        if(f==null){
            return;//q khong co trong danh sach
        }
        Node q1 = q.next;//cho q1 tro vao nut sau q
        f.next=q1;//f tro vao nut truoc q1
        if(f.next==null){
            tail=f;
        }
    }
    //(8)
    void remove(String xAge){
        Node q = searchByName(xAge);
        remove(q);
    }
    //(9)
    void removeAll(int xAge){
        Node q;
        while(true){
            q = searchByAge(xAge);
            if(q==null){
                break;
            }
            remove(q);
        }
    }
    //(10)
    Node pos(int k){ //Tim dia chi cua phan tu thu k
        int i=0;
        Node p = head;
        while(p != null){
            if(i==k){
                return (p);
            }
            i++;
            p=p.next;
        }
        return (null);
    }
    //(11)
    void removePos(int k){
        Node q = pos(k);
        remove(q);
    }
    //(12)
    void sortbyName(){
        Node pi,pj;
        Person x;
        pi=head;
        while(pi!=null){
            pj = pi.next;
            while(pj != null){
                if(pj.infor.name.compareTo(pi.infor.name)<0){
                    x=pi.infor;
                    pi.infor=pj.infor;
                    pj.infor=x;
                }
                pj=pj.next;

            }
            pi=pi.next;
        }

    }
    void sortbyAge(){
        Node pi,pj;
        Person x;
        pi=head;
        while(pi!=null){
            pj = pi.next;
            while(pj != null){
                if(pj.infor.age < pi.infor.age){
                    x=pi.infor;
                    pi.infor=pj.infor;
                    pj.infor=x;
                }
                pj=pj.next;

            }
            pi=pi.next;
        }

    }
    int size(){
        int i=0;
        Node p = head;
        while(p!=null){
            i++;
            p=p.next;

        }
        return (i);
    }

    Person []toArray(){
        int i,n;
        n=size();
        Person[]a=new Person[n];
        Node p =head;
        i=0;
        while (p != null) {

            a[i++]=new Person(p.infor.name,p.infor.age);
            p=p.next;
        }
        return (a);
    }
    void reverse(){
        MyList t = new MyList();
        Node p = head;
        while (p != null) {
            t.addFirst(new Person(p.infor.name,p.infor.age));
        }
        head=t.head;
        tail=t.tail;
    }
    Node findMaxage(){
        if(isEmpty()){
            return (null);
        }
        int x;
        Node p,q;
        p=q=head;
        x=head.infor.age;
        p=p.next;
        while(p!=null){
            if(p.infor.age>x){
                x=p.infor.age;
                q=p;
            }
            p=p.next;
        }
        return (q);
    }
    Node findMinage(){
        if(isEmpty()){
            return (null);
        }
        int x;
        Node p,q;
        p=q=head;
        x=head.infor.age;
        p=p.next;
        while(p!=null){
            if(p.infor.age<x){
                x=p.infor.age;
                q=p;
            }
            p=p.next;
        }
        return (q);
    }

    void setDate(Node p, Person x){
        if(p!=null){
            p.infor=x;
        }
    }
    void sortbyAge(int k,int h){//sap xep doan tu vi tri k den vi tri thu n
        if(k>h){
            return;
        }
        if(k<0){
            k=0;
        }
        int n=size();//n la so phan tu trong toan danh sach
        if(h>n-1){
            h=n-1;//h-1 la chi so cua phan tu cuoi cung
        }
        Node u = pos(k);//cho con tro u giu dia chi cua phan tu thu h+1
        Node v = pos(h+1);
        Node pi,pj;
        Person x;
        pi=u;
        while(pi!=v){
            pj=pi.next;
            while(pj!=null){
                if(pi.infor.age<pj.infor.age){
                    x=pi.infor;
                    pi.infor=pj.infor;
                    pj.infor=x;

                }
                pj=pj.next;
            }
            pi=pi.next;
        }
    }

    void reverse(int k, int h){
        if(k>h){
            return;
        }
        int n = size();
        int i, j;
        if(k<0 || k> n-1){
            return;
        }
        Person[]a=toArray();
        i=k;
        j=h;
        Person x;
        while(i<j){
            x=a[i];
            a[i]=a[j];
            a[j]=x;
            i++;
            j--;
        }
        clear();
        for( i =0;i<n;i++){
            addLast(a[i]);
        }
    }
//    //(10)
//    void removeLast(){
//        Node q = head;
//        tail=q;
//        tail.next  = null;
//    }
}
