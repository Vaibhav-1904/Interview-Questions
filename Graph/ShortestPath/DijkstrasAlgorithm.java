package ImportantQ.Graph.ShortestPath;
import java.util.*;

// Shortest Path in UnDirected weighted Graph
// It helps us find the shortest path between source and every other vertex.
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

    // T = O(N + E)*LogN    S = O(N+N)
    int[] dijkstra(int V, ArrayList<ArrayList<Node>> graph, int source){
        int[] distance = new int[V];
        for(int i = 0; i < V; i++)
            distance[i] = Integer.MAX_VALUE;

        PriorityQueue<Node> pq = new PriorityQueue<>((v1, v2) -> v1.getWeight() - v2.getWeight());
        pq.add(new Node(source, 0));

        while(pq.size() > 0){
            Node current = pq.poll();

            for(Node n : graph.get(current.getVertex())){
                if(distance[current.getVertex()] + n.getWeight() < distance[n.getVertex()]){
                    distance[n.getVertex()] = n.getWeight() + distance[current.getVertex()];
                    pq.add(new Node(n.getVertex(), distance[n.getVertex()]));
                }
            }
        }
        // If you want to calculate distance from source to a particular target,
        // you can return distance[target]
        return distance;
    }

//    // T = O(N + E)*LogN    S = O(N+N)
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
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        int source = 0;
        graph.get(0).add(new ArrayList<>(Arrays.asList(1,4)));
        graph.get(0).add(new ArrayList<>(Arrays.asList(7,8)));
        graph.get(1).add(new ArrayList<>(Arrays.asList(2,8)));
        graph.get(1).add(new ArrayList<>(Arrays.asList(7,11)));
        graph.get(2).add(new ArrayList<>(Arrays.asList(3,7)));
        graph.get(2).add(new ArrayList<>(Arrays.asList(8,2)));
        graph.get(2).add(new ArrayList<>(Arrays.asList(5,4)));
        graph.get(3).add(new ArrayList<>(Arrays.asList(4,9)));
        graph.get(3).add(new ArrayList<>(Arrays.asList(5,14)));
        graph.get(4).add(new ArrayList<>(Arrays.asList(5,10)));
        graph.get(5).add(new ArrayList<>(Arrays.asList(6,2)));
        graph.get(6).add(new ArrayList<>(Arrays.asList(7,1)));
        graph.get(6).add(new ArrayList<>(Arrays.asList(8,6)));
        graph.get(7).add(new ArrayList<>(Arrays.asList(8,7)));

//        int[] distance = dijkstra(V, graph, source);

//        System.out.println(Arrays.toString(distance));
    }
}
