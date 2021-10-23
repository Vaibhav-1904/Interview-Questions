package ImportantQ.Graph.MinimumSpanningTree;
import java.util.*;
// https://www.youtube.com/watch?v=8KPEROaLK-0&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=22
// It is used to find Minimum Spanning Tree
public class PrimsAlgorithm {
    static class Node{
        int vertex, weight;

        Node(int v, int w){
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

////         Naive Approach
//    // T = O(V^2) n^2    S = O(3N)
//    int[] primsAlgo(ArrayList<ArrayList<Node>>graph, int V){
//        boolean[] visited = new boolean[V];
//        int[] distance = new int[V];
//        int[] parent = new int[V];
//        for(int i = 0; i < V; i++){
//            distance[i] = Integer.MAX_VALUE;
//            parent[i] = -1;
//        }
//
//        distance[0] = 0; // Distance from source -> source (0->0) is always 0
//
//        for(int i = 0; i < V - 1; i++){ // V - 1 coz there should be V-1 edges
//            int min = Integer.MAX_VALUE;
//            int current = 0;
//            // finds the minimum distance to a Node which is not the port of MST
//            // Also finds the Node which is nearest to a Node in MST
//            for(int j = 0; j < V; j++){
//                if(!visited[j] && distance[j] < min){
//                    min = distance[j];
//                    current = j;
//                }
//            }
//            visited[current] = true; // You visit current Node
//
//            for(Node n : graph.get(current)){
//                if(!visited[n.getVertex()] && n.getWeight() < distance[n.getVertex()]){
//                    distance[n.getVertex()] = n.getWeight(); // Update Table
//                    parent[n.getVertex()] = current; // Assign its parent
//                }
//            }
//        }
//        return parent;
//    }

    // Optimal  T = O((N+E) * log N) -> NLogN
    int[] primsAlgo(ArrayList<ArrayList<Node>>graph, int V) {
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        int[] parent = new int[V];
        for(int i = 0; i < V; i++){
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)-> n1.getWeight() - n2.getWeight());
        distance[0] = 0; // Distance from source -> source (0->0) is always 0
        pq.add(new Node(0, distance[0]));

        for(int i = 0; i < V - 1; i++){ // V - 1 coz there should be V-1 edges
            int current = pq.poll().getVertex(); // Priority Queue will give the Node which is closest in MST
            // finds the minimum distance to a Node which is not the port of MST
            // Also finds the Node which is nearest to a Node in MST

            visited[current] = true; // You visit current Node

            for(Node n : graph.get(current)){
                if(!visited[n.getVertex()] && n.getWeight() < distance[n.getVertex()]){
                    distance[n.getVertex()] = n.getWeight(); // Update Table
                    parent[n.getVertex()] = current; // Assign it's parent
                    pq.add(new Node(n.getVertex(), distance[n.getVertex()]));
                }
            }
        }
        return parent;
    }

//    //Function to find sum of weights of edges of the Minimum Spanning Tree.
//    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> graph)
//    {
//        boolean[] visited = new boolean[V];
//        int[] distance = new int[V];
//        for(int i = 0; i < V; i++){
//            distance[i] = Integer.MAX_VALUE;
//        }
//
//        distance[0] = 0; // Distance from source -> source (0->0) is always 0
//
//        for(int i = 0; i < V - 1; i++){ // V - 1 coz there should be V-1 edges
//            int min = Integer.MAX_VALUE;
//            int current = 0;
//            // finds the minimum distance to a Node which is not the port of MST
//            // Also finds the Node which is nearest to a Node in MST
//            for(int j = 0; j < V; j++){
//                if(!visited[j] && distance[j] < min){
//                    min = distance[j];
//                    current = j;
//                }
//            }
//            visited[current] = true; // You visit current Node
//
//            for(ArrayList<Integer> arr : graph.get(current)){
//                if(!visited[arr.get(0)] && arr.get(1) < distance[arr.get(0)]){
//                    distance[arr.get(0)] = arr.get(1);
//                }
//            }
//        }
//        int sum = 0;
//        for(int i : distance)
//            sum += i;
//        return sum;
//    }
}
