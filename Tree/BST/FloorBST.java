package ImportantQ.Tree.BST;
import ImportantQ.Tree.Node.TreeNode;
//  return a number in BST which is just less than equal to than key
public class FloorBST {
    public static int floorInBST(TreeNode treeNode, int key) {
        int ans = -1;
        while(treeNode != null){
            if(key == treeNode.val){
                ans = treeNode.val;
                break;
            }
            if(key < treeNode.val){
                treeNode = treeNode.left;
            }else{
                ans = treeNode.val;
                treeNode = treeNode.right;
            }
        }
        return ans;
    }
}
