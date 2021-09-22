package ImportantQ.Graph.CycleDetection;
import java.util.*;

public class UnDirectedDFS {
    // T = O(N + E)  ,   S = O(N + N)
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
        // Code here

        boolean[] visited = new boolean[V + 1];
        // 1- Based Indexing
        for(int i = 1; i <= V; i++){
            if(!visited[i])
                if(checkForCycle(i, -1, graph, visited))
                    return true;
        }
        return false;
    }

    boolean checkForCycle(int current, int prev, ArrayList<ArrayList<Integer>> graph, boolean[] visited){

        visited[current] = true;
        for(Integer j : graph.get(current)){
            if(!visited[j]){
                if(checkForCycle(j, current, graph, visited))
                    return true;
            }else if(j != prev) // If previous is not equal to next, which means there is a cycle
                return true;
        }
        return false;
    }
}
