package ImportantQ.Graph;

import java.util.ArrayList;
import java.util.Stack;

// https://leetcode.com/problems/course-schedule/
public class CourseScheduler {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Stack<Integer> stack = new Stack<>();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        formGraph(prerequisites, graph);

        int[] visited = new int[numCourses];
        int[] dfsVisited = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == 0)
                if(checkCycle(i, graph, visited, dfsVisited))
                    return false;
        }

        return true;
    }

    public boolean checkCycle(int i, ArrayList<ArrayList<Integer>> graph, int[] visited, int[] dfsVisited) {
        visited[i] = 1;
        dfsVisited[i] = 1;

        for(Integer cur : graph.get(i)){
            if(visited[cur] == 0){
                if(checkCycle(cur, graph, visited, dfsVisited))
                    return true;
            }else if(dfsVisited[cur] == 1)
                return true;
        }
        dfsVisited[i] = 0;
        return false;
    }

    public void formGraph(int[][] pre, ArrayList<ArrayList<Integer>> graph) {
        for(int[] i : pre){
            graph.get(i[0]).add(i[1]);
        }
    }
}
