package ImportantQ.Graph.MinimumSpanningTree;
import java.lang.reflect.Array;
import java.util.*;

// https://www.youtube.com/watch?v=1KRmCzBl_mQ&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=24
// It is used to find MST
public class KruskalAlgorithm {
    // T = O(NlogN) N = N+E
    static class Node{
        int u, v;
        int weight;
        Node(int u, int v, int w){
            this.u = u;
            this.v = v;
            weight = w;
        }

        int getU(){
            return u;
        }
        int getV(){
            return v;
        }
    }

    int findParent(int node, int[] parent){
        if(node == parent[node])
            return node;
        // Path Compression
        return parent[node] = findParent(parent[node], parent); // assign the highest parent to hierarchical child
    } // 7 -> 6 -> 3 -> 2, and 2 is main parent, then assign 2 to 6 and 7

    void Union(int node1, int node2, int[] rank, int[] parent){
        node1 = findParent(node1,parent);
        node2 = findParent(node2, parent);

        if(rank[node1] < rank[node2])
            parent[node1] = node2;
        else if(rank[node2] < rank[node1])
            parent[node2] = node1;
        else{
            parent[node2] = node1;
            rank[node1]++;
        }
    }

    ArrayList<Node> Kruskal(ArrayList<Node> graph, int V){
        graph.sort((o1, o2) -> o1.weight - o2.weight); // sort according to minimum weight edges
        int[] parent = new int[V];
        int[] rank = new int[V];
        // Make Dis-joint set
        for(int i = 0; i < V; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        int costMST = 0;
        ArrayList<Node> mst = new ArrayList<>();

        for(Node n : graph){
            if(findParent(n.getU(), parent) != findParent(n.getV(), parent)){ // if 2 Nodes are of different component
                costMST += n.weight;
                mst.add(n);
                Union(n.getU(), n.getV(), parent, rank); // Join 2 nodes for MST
            }
        }
        System.out.println("Cost of MST : " + costMST);
        return mst; // it contains all the edges of MST
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Node> graph = new ArrayList<>();

        graph.add(new Node(0, 1, 2)); // 0 -> 1 where weight is 2
        graph.add(new Node(0, 3, 6));
        graph.add(new Node(1, 3, 8));
        graph.add(new Node(1, 2, 3));
        graph.add(new Node(1, 4, 5));
        graph.add(new Node(2, 4, 7));
    }
}
