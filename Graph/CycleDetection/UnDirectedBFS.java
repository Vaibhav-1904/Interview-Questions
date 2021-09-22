package ImportantQ.Graph.CycleDetection;
import java.util.*;

public class UnDirectedBFS {
    // T = O(N + E)  ,   S = O(N + N)
    // Node class where prev is used to track where Node(node) has come from(parent).
    static class Node {
        int node, prev;
        public Node(int node, int prev) {
            this.node = node;
            this.prev = prev;
        }
    }

    static public boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[V + 1];

        // 1 based Indexing and multiple component graph
        for(int i = 1; i <= V; i++){
            if(!visited[i])
                if(checkForCycle(i, graph, visited))
                    return true;
        }
        return false;
    }

    static boolean checkForCycle(int i, ArrayList<ArrayList<Integer>> graph, boolean[] visited){
        Queue<Node> q = new LinkedList<>();
        // If it's the originating Node, parent = -1
        q.add(new Node(i, -1));
        visited[i] = true;

        while(!q.isEmpty()){
            Node current = q.poll();
            int node = current.node;
            int prev = current.prev;

            for(Integer j: graph.get(node)){
                if(!visited[j]){
                    // Take very Adjacent Node
                    q.add(new Node(j, node));
                    visited[j] = true;
                }else if(j != prev){
                    return true;
                    // Previous of Node current is not equal to j, then j must have been visited
                    // from other side of cycle, hence cycle is found
                }
            }
        }
        return false;
    }
}
