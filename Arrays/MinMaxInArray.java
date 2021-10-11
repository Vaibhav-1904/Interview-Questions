package ImportantQ.Arrays;

public class MinMaxInArray {

    public static class Pair{
        int min;
        int max;
    }

    public static Pair MinMax(Pair p, int[] arr, int n){

        int i;
        if(n % 2 == 0){
            if(arr[0] > arr[1]){
                p.min = arr[1];
                p.max = arr[0];
            }else {
                p.min = arr[0];
                p.max = arr[1];
            }
            i = 2;
        }else{
            p.min = arr[0];
            p.max = arr[1];
            i = 1;
        }

        while(i < n - 1){

            if(arr[i] > arr[i + 1]){
                p.max = Math.max(p.max, arr[i]);
                p.min = Math.min(p.min, arr[i+1]);
            }else{
                p.max = Math.max(p.max, arr[i+1]);
                p.min = Math.min(p.min, arr[i]);
            }
            i += 2;
        }

        return p;
    }
    public static void main(String[] args) {

        int[] arr = {1, 2 ,4 ,5, 10, 64, 669, 41,89};
        int n =arr.length;

        Pair p = new Pair();
        p = MinMax(p,arr, n);

        System.out.println("Max is : " + p.max + " Min is  : " + p.min);

    }
}
