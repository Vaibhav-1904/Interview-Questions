package ImportantQ.Graph.CycleDetection;
import java.util.*;

// using Kahn Algorithm
public class DirectedBFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> graph) {
        // code here

        int[] result = new int[V];
        int[] inDegree = new int[V]; // Storing Inorder degrees for very Node i
        // Count Indegree of every vertex
        for(int i = 0; i < V; i++){
            for(Integer j : graph.get(i)){
                inDegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0)
                q.add(i);
        }
        int count = 0;
        int i = 0;
        while(!q.isEmpty()){
            Integer current = q.poll();
            // result[i++] = current;
            count++;
            for(Integer j : graph.get(current)){
                inDegree[j]--;

                if(inDegree[j] == 0)
                    q.add(j);
            }
        }
        // Topological sort is not possible if graph is Cyclic
        // And in Topological sort, vertices = total elements in sort
        // So if count is not equal is to total vertices, it means Topological sort is not Possible
        // as graph is cyclic
        return count != V;
    }
}
