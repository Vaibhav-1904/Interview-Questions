package ImportantQ.Graph;
import java.util.*;
// https://www.youtube.com/watch?v=V8qIqJxCioo&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=27
// https://practice.geeksforgeeks.org/tracks/dsa-workshop-1-graph/?batchId=308
// DFS Based Algorithm
public class KosrajuAlgorithm {
    static void topoSort(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> stack){
        visited[node] = true;
        for(Integer j : graph.get(node)){
            if(!visited[j])
                topoSort(j, graph, visited, stack);
        }
        stack.push(node);
    }
    // T = O(N + E + N + E N + E) = O(N+E)   S = O((N+E) +N +N)
    static ArrayList<ArrayList<Integer>> kosaraju(int V, ArrayList<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>(); // we store elements in increasing order of finish time, the greatest finish time at top
        // Topological Sort
        for(int i = 0; i < V; i++){
            if(!visited[i])
                topoSort(i, graph, visited, stack);
        }

        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int i = 0; i < V; i++){
            transpose.add(new ArrayList<>());
            visited[i] = false;
        }
        // Transpose of Graph, reversing all the edges
        for(int i = 0; i < V; i++){
            for(Integer v : graph.get(i))
                transpose.get(v).add(i);
        }

        ArrayList<ArrayList<Integer>> SCC = new ArrayList<>(); // for storing Strongly Connected Components
        // DFS Traversal according to topoSort
        while(stack.size() > 0){
            int node = stack.pop();
            ArrayList<Integer> arr = new ArrayList<>();
            if(!visited[node]){
                dfs(node, transpose, visited, arr);
                SCC.add(arr);
            }
        }
        return SCC;
    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, ArrayList<Integer> arr){
        visited[node] = true;
        arr.add(node);
        for(Integer j : graph.get(node)) {
            if(!visited[j]){
                dfs(j, graph, visited, arr);
            }
        }
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 5;
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(2).add(3);
        graph.get(3).add(4);

        System.out.println(kosaraju(V, graph));
    }
}
