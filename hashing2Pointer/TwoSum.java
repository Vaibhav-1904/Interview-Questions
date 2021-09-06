package ImportantQ.hashing2Pointer;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> m = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(m.containsKey(target-nums[i])){
                ans[0] = m.get(target-nums[i]);
                ans[1] = i;
                break;

            }
            else{
                m.put(nums[i],i);
            }
        }

        return ans;
    }

}
