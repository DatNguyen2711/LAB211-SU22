package Lab211_20loc;

import java.util.Random;
import java.util.Scanner;

public class BBS {
    public static void main(String[] args) {
        input();
    }


    //check input from keyboard when user enter wrong data
    public static void input(){
        Scanner sc = new Scanner(System.in);
        boolean cout = false;
        do{
            try {
                String str;
                int n;
                System.out.println("Enter the number of array : ");
                str = sc.next();
                n = Integer.parseInt(str);
                int []arr = new int[100000];
                    if(n<1){
                        System.out.println("Number must > 0. Please enter again !");
                        cout=true;
                    }else{
                        randomNumber(n,arr);
                        bbs(n,arr);
                        show(n,arr);
                        break;
                    }
                //if user enter a character like : word or special character they must enter again
            } catch (NumberFormatException e) {
                System.out.println("Number must be integer !");
                cout=true;
            }
        }while(cout == true);

    }

    //create random number < 10
    public static void randomNumber(int n, int[] a){
        System.out.print("Unsorted array : ");
        System.out.print("[");
        //create random nums
        for (int i=0; i<n-1; i++) {
            Random rand = new Random();
            int ranNum = rand.nextInt(10)+1;
            a[i]=ranNum;
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[n-1]+ "]");
    }

    //sort the elements in array by bubble sort algorithm
    static void bbs(int n,int[] a){
        for(int i = 0;i<n;i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    // display the array after sorted
    static void show(int n, int[] a){
        System.out.printf("\n");
        System.out.print("Sorted array :");
        System.out.print("[");
        for(int i=0;i<n-1;i++){
            System.out.print(a[i]+", ");
        }
        System.out.print(a[n-1]+ "]");
    }
}
