package ImportantQ.Graph;
import java.util.*;
// low time is time which indicates for each node which is the lowest ancestor which can be directly reached from that node.
// Tarjan's Algorithm
public class BridgesGraph {

    void dfs(int node, int parent, boolean[] visited, int[] low, int[] time, ArrayList<ArrayList<Integer>> graph, int timer){
        visited[node] = true;
        time[node] = low[node] = timer++;

        for(Integer j : graph.get(node)){
            if(j == parent)
                continue;

            if(!visited[j]){
                dfs(j, node, visited, low, time, graph, timer);
                low[node] = Math.min(low[node], low[j]);

                if(low[j] > time[node]) // j is node's adjacent
                    System.out.println("Bridge between " + j + " and " + node);
            }else{ // If it's already visited, it means that it must have been visited from some other path (cycle, back edge)
                low[node] = Math.min(low[node], time[j]);
            }
        }
    }

    void findBridges(int V, ArrayList<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[V];
        int[] low = new int[V]; // lowest insertion time among all adjacent
        int[] time = new int[V];

        int timer = 0;
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, -1, visited, low, time, graph, timer);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<Integer>());


    }
}
