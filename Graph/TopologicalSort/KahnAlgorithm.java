package ImportantQ.Graph.TopologicalSort;
import java.util.*;
// https://www.geeksforgeeks.org/topological-sorting/
// Topological Sorting in Graph is only Possible for only Directed Acyclic Graph(DAG)
// It is linear Ordering of vertices such that if there is an edge u->v,
// then u appears before v in ordering
// Kahn Algo is used to find Topological order using BFS

public class KahnAlgorithm {
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> graph)
    {
        int[] result = new int[V];
        int[] inDegree = new int[V]; // Storing Inorder degrees for very Node i

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
        int i = 0;
        while(!q.isEmpty()){
            Integer current = q.poll();
            result[i++] = current;

            for(Integer j : graph.get(current)){
                inDegree[j]--;

                if(inDegree[j] == 0)
                    q.add(j);
            }
        }
        return result;
    }
}
