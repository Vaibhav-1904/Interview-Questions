package ImportantQ.Graph.ShortestPath;
import java.util.*;
// https://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/
// Given a Directed ACyclic Path
// find distance form source node to a Target Node or each vertex of graph
public class DAG {
    static class Pair{
        // IF a class is declared final, then no other class can implement that class,
        // it cannot have child classes

        // If a method is declared final, then we cannot Override that method
        // A final variable cannot be changed
        private final int vertex;
        private final int weight;
        Pair(int v, int w){
            vertex = v;
            weight = w;
        }

        int getVertex(){
            return vertex;
        }
        int getWeight(){
            return weight;
        }
    }
    // T = O(N + E + N + E)   S = O(N + N + N + N)
    int[] shortestPath(int V, ArrayList<ArrayList<Pair>> graph, int src){
        int[] distance = new int[V];
        Stack<Integer> stack = new Stack<>();
        Boolean[] visited = new Boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i])
                topoSort(i, graph, stack, visited);
        }
        // Update the Distance of every vertex form source to infinity
        for(int i = 0; i < V; i++){
            distance[i] = Integer.MIN_VALUE;
        }

        distance[src] = 0; // distance from source -> source is 0
        while(!stack.isEmpty()){
            int current = stack.pop();
            // If current has not been reached previously,
            if(distance[current] != Integer.MAX_VALUE){ // So that it always starts from source node
                for(Pair p : graph.get(current)){
                    if(p.getWeight() + distance[current] < distance[p.getVertex()]){
                        distance[p.getVertex()] = distance[current] + p.getWeight();
                    }
                }
            }
        }
        // If you want to calculate distance from source to a particular target,
        // you can return distance[target]
        // If any value is still Integer.MAXVALUE, then it must be unreachable from source
        return distance;
    }

    void topoSort(int i, ArrayList<ArrayList<Pair>> graph, Stack<Integer> stack, Boolean[] visited){
        visited[i] = true;
        for(Pair p : graph.get(i)){
            if(!visited[p.getVertex()])
                topoSort(p.getVertex(), graph, stack, visited);
        }
        stack.push(i); // Node with the least incoming edges is pushed last so that it can be popped first
    }
}
