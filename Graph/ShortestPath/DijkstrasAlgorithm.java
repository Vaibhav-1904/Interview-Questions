package ImportantQ.Graph.ShortestPath;
import java.util.*;
// Shortest Path in UnDirected weighted Graph
// It helps us find the shortest path between source and every other vertex.
// It will not work if there are -ve weights in Graph

// DFS is not used to find the shortest distance in graph, but is used in Trees instead coz we have unique paths
// between nodes in Trees, but we can have exponential number of unique paths between 2 nodes in a graph.
public class DijkstrasAlgorithm {
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

    // T = O((N + E)*LogN)    S = O(N+N)
    static int[] dijkstra(int V, ArrayList<ArrayList<Node>> graph, int source) {
        int[] distance = new int[V];
        for(int i = 0; i < V; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((v1, v2) -> v1.getWeight() - v2.getWeight());
        pq.add(new Node(source, 0));

        while(pq.size() > 0){
            Node current = pq.poll();

            for(Node node : graph.get(current.getVertex())){
                if(distance[current.getVertex()] + node.getWeight() < distance[node.getVertex()]) {
                    distance[node.getVertex()] = node.getWeight() + distance[current.getVertex()];
                    pq.add(new Node(node.getVertex(), distance[node.getVertex()])); //logn
                }
            }
        }
        // If you want to calculate distance from source to a particular target,
        // you can return distance[target]
        return distance;
    }

    // T = O(N + E)*LogN    S = O(N+N)
//    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> graph, int source)
//    {
//        int[] distance = new int[V];
//        for(int i = 0; i < V; i++)
//            distance[i] = Integer.MAX_VALUE;
//
//        PriorityQueue<Node> pq = new PriorityQueue<>((v1, v2) -> v1.getWeight() - v2.getWeight());
//        pq.add(new Node(source, 0));
//        distance[source] = 0; // distance form source to source is 0
//
//        while(pq.size() > 0){
//            Node current = pq.poll();
//
//            for(ArrayList<Integer> arr : graph.get(current.getVertex())){
//                if(distance[current.getVertex()] + arr.get(1) < distance[arr.get(0)]){
//                    distance[arr.get(0)] = arr.get(1) + distance[current.getVertex()];
//                    pq.add(new Node(arr.get(0), distance[arr.get(0)]));
//                }
//            }
//        }
//        // If you want to calculate distance from source to a particular target,
//        // you can return distance[target]
//        return distance;
//    }

    public static void main(String[] args) {
        int V = 9;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        int source = 0;
        graph.get(0).add(new Node(1, 4));
        graph.get(0).add(new Node(7, 8));
        graph.get(1).add(new Node(2,8));
        graph.get(1).add(new Node(7, 11));
        graph.get(1).add(new Node(0,7));
        graph.get(2).add(new Node(1, 8));
        graph.get(2).add(new Node(3, 7));
        graph.get(2).add(new Node(8, 2));
        graph.get(2).add(new Node(5, 4));
        graph.get(3).add(new Node(2, 7));
        graph.get(3).add(new Node(4, 9));
        graph.get(3).add(new Node(5, 14));
        graph.get(4).add(new Node(3, 9));
        graph.get(4).add(new Node(5, 10));
        graph.get(5).add(new Node(4,10));
        graph.get(5).add(new Node(6, 2));
        graph.get(6).add(new Node(5, 2));
        graph.get(6).add(new Node(7, 1));
        graph.get(6).add(new Node(8, 6));
        graph.get(7).add(new Node(0, 8));
        graph.get(7).add(new Node(1, 11));
        graph.get(7).add(new Node(6, 1));
        graph.get(7).add(new Node(8, 7));
        graph.get(8).add(new Node(2, 2));
        graph.get(8).add(new Node(6, 6));
        graph.get(8).add(new Node(7, 1));

        int[] distance = dijkstra(V, graph, source);
        System.out.println("Vertex  " + "  Distance from Source");
        for(int i = 0; i < V; i++){
            System.out.println(i + "             " + distance[i]);
        }
    }
}
