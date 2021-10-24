package ImportantQ.Graph;
import java.util.ArrayList;

public class practice {
    final ArrayList<Edge> bridges = new ArrayList<>();
    final ArrayList<Integer> Articulation = new ArrayList<>();
    static class Edge{
        int u;
        int v;
        Edge(int u, int v){
            this.u = u;
            this.v = v;
        }
    }
    void findBridges(int V, ArrayList<ArrayList<Integer>> graph) {
        int[] time = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];

        int timer = 0;
        for(int i = 0; i < V; i++){
            if(!visited[i])
                dfs(i, -1, time, low, visited, graph, timer);
        }
    }

    void dfs(int vertex, int parent, int[] time, int[] low, boolean[] visited, ArrayList<ArrayList<Integer>> graph, int timer) {
        visited[vertex] = true;
        time[vertex] = low[vertex] = timer++;
        int child = 0;

        for(Integer v : graph.get(vertex)){
            if(v == parent)
                continue;

            if(!visited[v]){
                dfs(v, vertex, time, low, visited, graph, timer);
                low[vertex] = Math.min(low[vertex], low[v]);

                if(time[vertex] < low[v]){
                    bridges.add(new Edge(vertex, v));
                }
                if(time[vertex] <= low[v] && parent != -1) // -1 condition is only for Source Node
                    Articulation.add(vertex);
                child++;
            }else{
                low[vertex] = Math.min(low[vertex], time[v]);
            }
        }
        if(parent == -1 && child > 1)
            Articulation.add(vertex);

    }
}
