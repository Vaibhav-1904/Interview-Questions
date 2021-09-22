package ImportantQ.Graph.TopologicalSort;
import java.util.*;
// https://www.geeksforgeeks.org/topological-sorting/
// Topological Sorting in Graph is only Possible for only Directed Acyclic Graph(DAG)
// It is linear Ordering of vertices such that if there is an edge u->v,
// then u appears before v in ordering
public class TopologicalSortDFS {
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> graph)
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++){
            if(!visited[i])
                findTopoSort(i, graph, visited, stack);
        }

        int[] result = new int[V];
        int i = 0;
        while(!stack.isEmpty())
            result[i++] = stack.pop();
        return result;
    }

    // Using DFS  T = O(N+E) S = O(N + N + N)
    static void findTopoSort(int i, ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> stack ){
        visited[i] = true;

        for(Integer j : graph.get(i)){
            if(!visited[j])
                findTopoSort(j, graph, visited, stack);
        }
        stack.push(i);
    }
}
