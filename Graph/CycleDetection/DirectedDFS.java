package ImportantQ.Graph.CycleDetection;
import java.util.*;

public class DirectedDFS {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> graph) {
        // code here
        int[] visited = new int[V];
        int[] dfsVisited = new int[V];

        for(int i = 0; i < V; i++){
            if(visited[i] == 0)
                if(checkCycleDFS(i, graph, visited, dfsVisited))
                    return true;
        }
        return false;
    }

    boolean checkCycleDFS(int i, ArrayList<ArrayList<Integer>> graph, int[] visited, int[] dfsVisited ) {
        visited[i] = 1;
        dfsVisited[i] = 1;

        for(Integer current : graph.get(i) ){
            if(visited[current] == 0){
                if(checkCycleDFS(current, graph, visited, dfsVisited) )// IF it returns true, cycle in further DFS
                    return true;
            }else if(dfsVisited[current] == 1 ) // If it's visited in current dfs traversal
                return true;
        }
        dfsVisited[i] = 0; // If there is no cycle in all adjacent Nodes of i
        return false;
    }
}
