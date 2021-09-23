package ImportantQ.Graph.MinimumSpanningTree;
// Union by Rank and Path Compression
// Know as union-find algorithm
// union–find data structure, is a data structure that stores a collection of disjoint (non-overlapping) sets.
// https://www.youtube.com/watch?v=3gbO7FDYNFQ&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=23
public class DisJointSet {
    int[] parent;
    int[] rank;

    void makeSet(int N){
        parent = new int[N + 1];
        rank = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int findParent(int node){
        if(node == parent[node])
            return node;
        // Path Compression
        return parent[node] = findParent(parent[node]); // assign the highest parent to hierarchical child
    } // 7 -> 6 -> 3 -> 2, and 2 is main parent, then assign 2 to 6 and 7

    void Union(int node1, int node2){
        node1 = findParent(node1);
        node2 = findParent(node2);

        if(rank[node1] < rank[node2])
            parent[node1] = node2;
        else if(rank[node2] < rank[node1])
            parent[node2] = node1;
        else{
            parent[node2] = node1;
            rank[node1]++;
        }
    }

    public void main(String[] args) {
        int N = 6;
        makeSet(N);

        // If we want to find whether 2 Nodes belong to same component of a graph
        // or not, simply use findParent method, if both are same -> they belong
        // to same component else they belong to different component.
    }
}
