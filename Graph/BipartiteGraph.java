package ImportantQ.Graph;
import java.util.*;
// https://www.geeksforgeeks.org/bipartite-graph/
// Both using DFS and BFS
public class BipartiteGraph {
    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> graph)
    {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        // Multiple Component Graph
        //  0 Based Indexing
        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                if(!bfsBipartiteCheck(i, graph, color))
                    return false;
            }
        }
        return true;
    }

    // 1 -> Blue
    // 2 -> Green T = O(N + E)  S = O(N+E  + N +  N)
    public static boolean bfsBipartiteCheck(int i, ArrayList<ArrayList<Integer>> graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 1;
        while(!q.isEmpty()){
            Integer current = q.poll();
            for(Integer j : graph.get(current)){
                if(color[j] == -1){
                    color[j] = (color[current] == 1) ? 2 : 1;
                    q.add(j);
                }else if(color[j] == color[current]){ // If adjacent node have same color which are already visited
                    return false;
                }
            }
        }
        return true;
    }

    // 1 -> Blue
    // 2 -> Green     T = O(N + E)  S = O(N+E  + N +  N)
    boolean dfsCheck(int i, ArrayList<ArrayList<Integer>> graph, int[] color){

        if(color[i] == -1){
            color[i] = 1;
        }

        for(Integer current : graph.get(i)){
            if(color[current] == -1){
                color[current] = (color[i] == 1) ? 2 : 1;

                if(!dfsCheck(current, graph, color))
                    return false;
            }else if(color[current] == color[i]){
                return false;
            }
        }
        return true;
    }
}
