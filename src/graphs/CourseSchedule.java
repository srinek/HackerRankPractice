package graphs;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/course-schedule/
 * 
 * 
 * There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */

public class CourseSchedule {
	
	public static void main(String[] args) {
		
		CourseSchedule cs = new CourseSchedule();
		
		if(cs.canFinish(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})){
			System.out.println(cs.finishOrder);
		}
		else{
			System.out.println(new ArrayList<>());
		}
		
	}
	
	private static class Course{
		
		public List<Course> required = new ArrayList<>();
		
		public boolean finished; 
		
		public boolean visited;
		
		public int num;
		
		public Course(int num){
			this.num = num;
		}
		
		
		public String toString(){
			
			return this.num +" "+this.finished +" "+this.visited;
		}
	}
	
	private static class CourseGraph{
		
		public List<Course> vertex = new ArrayList<>();
		
		public CourseGraph(int n){
			
			for(int i=0; i<n; i++){   // O(n)
				vertex.add(new Course(i));
			}
		}
		
		public void addRequiredCourses(int[][] prerequisites){
			
			for(int i=0; i<prerequisites.length; i++){
				
				int[] pair = prerequisites[i];
				vertex.get(pair[0]).required.add(vertex.get(pair[1]));
			}
		}
	}
	
	
	List<Integer> finishOrder = new ArrayList<>();
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        
		CourseGraph g = new CourseGraph(numCourses);
		g.addRequiredCourses(prerequisites);
		
		for(Course each : g.vertex){
			
			each.visited = true;
			if(finish(each.required)){
				each.finished = true;
				finishOrder.add(each.num);
			}
			else{
				return false;
			}
		}
		return true;
    }
	
	private boolean finish(List<Course> courses){
		
		if(courses.size() == 0){
			return true;
		}
		int finished = 0;
		for(Course c : courses){
			
			if(c.finished){
				finished++;
				continue;
			}
			if(c.visited){
				return false;
			}
			c.visited = true;
			if(!c.finished){
				if(finish(c.required)){
					finished++;
					c.finished = true;
					finishOrder.add(c.num);
				}
			}
		}
		if(finished == courses.size()){
			return true;
		}
		return false;
		
	}

}
