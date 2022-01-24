package ImportantQ.Tree;

import java.util.*;
public class VerticalOrderTraversal {

    static class Node{
        int data;
        Node left, right;
    }
//    static ArrayList<Integer> verticalOrder(Node root)
//    {
//        ArrayList<Integer> result = new ArrayList<>();
//
//        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
//
//        getVerticalOrder(root, map, 0);
//
//        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
//            result.addAll(entry.getValue());
//        }
//
//        return result;
//    }
//
//    static void getVerticalOrder(Node root, Map<Integer, ArrayList<Integer>> map, int line) {
//
//        if(root == null)
//            return;
//        ArrayList<Integer> arr = map.get(line);
//
//        if(arr == null){
//            arr = new ArrayList<>();
//        }
//
//        arr.add(root.data);
//
//        map.put(line, arr);
//
//        getVerticalOrder(root.left, map, line - 1);
//        getVerticalOrder(root.right, map, line + 1);
//    }

    static class TreeNode{
        Node node;
        int line, level;
        TreeNode(Node node, int line, int level){
            this.node = node;
            this.line = line;
            this.level = level;
        }
    }

    static ArrayList<Integer> VerticalOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(new TreeNode(root, 0, 0));
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer> > > map = new TreeMap<>(); // line, level, sorting

        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            Node cur = temp.node;
            int line = temp.line;
            int level = temp.level;

            if(!map.containsKey(line))
                map.put(line, new TreeMap<>());

            if(!map.get(line).containsKey(level))
                map.get(line).put(level, new PriorityQueue<>());

            map.get(line).get(level).add(cur.data);

            if(cur.left != null)
                q.add(new TreeNode(cur.left, line - 1, level + 1));
            if(cur.right != null)
                q.add(new TreeNode(cur.right, line + 1, level + 1));
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> mp : map.values()){
            for(PriorityQueue<Integer> pq : mp.values()){
                while(!pq.isEmpty()){
                    result.add(pq.poll());
                }
            }
        }
        return result;
    }
}
