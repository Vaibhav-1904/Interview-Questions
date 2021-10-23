package ImportantQ.Graph.MinimumSpanningTree;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class practice {
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

    public static int[] primsAlgo(ArrayList<ArrayList<Node>>graph, int V) {
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        int[] parent = new int[V];
        for(int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> (n1.getWeight() - n2.getWeight()));
        distance[0] = 0;
        pq.add(new Node(0, distance[0]));
        for(int i = 0; i < V - 1; i++){
//            int min = Integer.MAX_VALUE;
//            for(int j = 0; j < V; j++){
//                if(distance[j] < min){
//                    min = distance[j];
//                    cur = j;
//                }
//            }

            int cur = pq.poll().getVertex();

            visited[cur] = true;

            for(Node n : graph.get(cur)){
                if(!visited[n.getVertex()] && n.getWeight() < distance[n.getVertex()]){
                    distance[n.getVertex()] = n.getWeight();
                    parent[n.getVertex()] = cur;
                }
            }
        }
        return parent;
    }
}
