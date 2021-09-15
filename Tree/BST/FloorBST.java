package ImportantQ.Tree.BST;
import ImportantQ.Tree.TreeNode.Node;
//  return a number in BST which is just less than equal to than key
public class FloorBST {
    public static int floorInBST(Node node, int key) {
        int ans = -1;
        while(node != null){
            if(key == node.data){
                ans = node.data;
                break;
            }
            if(key < node.data){
                node = node.left;
            }else{
                ans = node.data;
                node = node.right;
            }
        }
        return ans;
    }
}
