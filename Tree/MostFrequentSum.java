package ImportantQ.Tree;
import java.util.*;
import ImportantQ.Tree.Node.TreeNode;


// https://leetcode.com/problems/most-frequent-subtree-sum/
public class MostFrequentSum {

    // T->O(n)  S->O(n)

    public static int[] findFrequentTreeSum(TreeNode root) {

        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int rootSum = findSum(root, map);
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            max = Math.max(max, entry.getValue());
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == max)
                arr.add(entry.getKey());
        }

        int[] result = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }

        return result;
    }

    public static int findSum(TreeNode root, HashMap<Integer, Integer> map) {
        if(root == null)
            return 0;

        if(isLeaf(root)){
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            return root.val;
        }else{
            int leftSum = findSum(root.left, map);
            int rightSum = findSum(root.right, map);

            int rootSum = leftSum + rightSum + root.val;

            map.put(rootSum, map.getOrDefault(rootSum, 0) + 1);

            return rootSum;
        }
    }

    public static boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
}
