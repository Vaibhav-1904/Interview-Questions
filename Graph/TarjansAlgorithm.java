package ImportantQ.Graph;

import java.util.*;

// It can be used to find Strongly Connected components in a Component of a graph
// https://www.youtube.com/watch?v=ZeDNSeilf-Y
public class TarjansAlgorithm {

    static void dfs(int node, int parent, int[] time, int[] low, ArrayList<ArrayList<Integer>> graph,
                    int timer, Stack<Integer> stack, boolean[] inStack, ArrayList<ArrayList<Integer>> result){


        time[node] = low[node] = timer++;
        stack.push(node);
        inStack[node] = true;

        for(Integer j: graph.get(node)){
            // if(j == parent)
            //     continue;

            if(time[j] == -1){
                dfs(j, node, time, low, graph, timer, stack, inStack, result);
                low[node] = Math.min(low[node], low[j]);
            }else if(inStack[j]){
                low[node] = Math.min(low[node], time[j]);
            }
        }

        if(low[node] == time[node]){
            ArrayList<Integer> arr = new ArrayList<>();

            while(stack.peek() != node){
                inStack[stack.peek()] = false;
                arr.add(stack.pop());
            }
            inStack[stack.peek()] = false;
            arr.add(stack.pop());
            Collections.sort(arr);
            result.add(arr);
        }
    }

    public static ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> graph)
    {
        int[] time = new int[V];
        for(int i = 0; i < V; i++)
            time[i] = -1;
        int[] low = new int[V];
        boolean[] inStack = new boolean[V];
        int timer = 0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++){
            if(time[i] == -1)
                dfs(i, -1, time, low, graph, timer, stack, inStack, result);
        }

        result.sort((o1, o2) -> o1.get(0) - o2.get(0));
        return result;
    }

    public static void main(String[] args) {
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

        System.out.println(tarjans(V, graph));
    }
}
