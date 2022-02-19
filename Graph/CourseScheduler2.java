package ImportantQ.Graph;
import java.util.*;
// https://leetcode.com/problems/course-schedule-ii/

public class CourseScheduler2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        formGraph(prerequisites, graph);

        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(Integer n : graph.get(i))
                inDegree[n]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0)
                q.add(i);
        }

        if(q.isEmpty())
            return new int[]{};

        int count = 0;
        int i = 0;
        int[] result = new int[numCourses];

        while(!q.isEmpty()){
            Integer cur = q.poll();
            result[i++] = cur;
            count++;

            for(Integer j: graph.get(cur)){
                inDegree[j]--;

                if(inDegree[j] == 0)
                    q.add(j);
            }
        }

        if(count == numCourses)
            return result;
        else
            return new int[]{};
    }

    public void formGraph(int[][] pre, ArrayList<ArrayList<Integer>> graph) {
        for(int[] i : pre){
            graph.get(i[1]).add(i[0]);
        }
    }
}
