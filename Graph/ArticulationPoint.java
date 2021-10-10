package ImportantQ.Graph;
import java.util.*;

public class ArticulationPoint {
    void printArticulation(int V, ArrayList<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[V];
        int[] time = new int[V];
        int[] low = new int[V];
        HashSet<Integer> result = new HashSet<>();
        int timer = 0;
        for(int i = 0; i < V; i++){
            if(!visited[i]){

            }
        }
    }

    List<Integer> dfs(int node, int parent, boolean[] visited, int[] time, int[] low, ArrayList<ArrayList<Integer>> graph, HashSet<Integer> result, int timer){
        visited[node] = true;
        time[node] = low[node] = timer++;
        int child = 0;
        for(int j : graph.get(node)){
            if(j == parent)
                continue;

            if(!visited[j]){
                dfs(j, node, visited, time, low, graph, result, timer);
                low[node] = Math.min(low[node], low[j]);

                if(low[j] >= time[node] && parent != -1){// lowest time to reach j node which is an adjacent of 'node'
                    result.add(node);
                }
                child++;
            }else{
                low[node] = Math.min(low[node], time[j]);
            }
        }
        if(parent == -1 && child > 1)
            result.add(node);

        return new ArrayList<Integer>(result);
    }
}
