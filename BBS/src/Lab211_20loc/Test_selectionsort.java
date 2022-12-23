package Lab211_20loc;

public class Test_selectionsort {
    public static void main(String[] args) {

        int []a={3,4,3,1,20,-6};
        for(int i = 0; i < a.length; i++) {
            int min_index=i;
            for(int j = i+1;j<a.length;j++) {
                if(a[j] < a[min_index]){
                    min_index=j;
                }
                int temp = a[min_index];
                a[min_index] = a[i];
                a[i] = temp;
            }
        }
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]+" ");
        }
    }
}
