package ImportantQ.Greedy;
import java.util.*;

public class FractionalKnapsack {
    static class Item{
        int value, weight;
        Item(int v, int w){
            value = v;
            weight = w;
        }
    }
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Your code here
        double maxValue = 0;

        Arrays.sort(arr, (a , b) -> (b.value / b.weight) - (a.value / a.weight));
        int i = 0;

        while(W > 0 && i < n){
            if(W > arr[i].weight){
                maxValue += arr[i].value;
                W = W - arr[i].weight;
                i++;
            }else{
                double d = ((double)W / (double)arr[i].weight);
                maxValue += (d * arr[i].value);
                break;
            }
        }
        return maxValue;

    }
}
