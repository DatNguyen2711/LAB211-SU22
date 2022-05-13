package DSLK;

public class Person {
    String name;
    int age;

    Person(){

    }

    public Person(String xName, int xAge) {
        name = xName;
        age = xAge;
    }

    @Override
    public String toString() {
        return ("("+name+","+age+")");
    }
}
