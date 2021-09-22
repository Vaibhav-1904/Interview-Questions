package ImportantQ.Arrays;

public class BuySellStock {

    public static void main(String[] args){

        int[] prices = {2,1,7};

        // BruteForce Approach
//        int max = 0;
//        for(int i = 0; i < prices.length; i++){
//            for(int j = i+1; j < prices.length; j++){
//                if((prices[j] - prices[i]) > max){
//                    max = prices[j] - prices[i];
//                }
//            }
//        }

        //Optimal Approach
        int min = prices[0];
        int profit = 0;

        for(int i = 0; i < prices.length; i++){
            if(min < prices[i]){
                if((prices[i] - min) > profit)
                    profit = prices[i] - min;
            }else{
                min = prices[i];
            }
        }
    }
}
