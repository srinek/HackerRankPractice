package algo.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;

public class ActivitySelection {

	public static void main(String[] args) {
		ActivitySelection as = new ActivitySelection();
		int[] start = new int[]{2, 2, 3, 5, 7};
		int[] end = new int[]{3, 6, 5, 8, 8};
		
		System.out.println(as.selectActivities(createActivities(start, end)));
		
		
	}
	
	private static  Activity[] createActivities(int[] start, int[] end){
		
		Activity[] activities = new Activity[start.length];
		for(int i=0; i < start.length; i++){
			Activity a = new Activity(start[i], end[i]);
			activities[i] = a;
		}
		
		return activities;
		
	}
	
	// 2 3 2 5 7
	// 3 5 6 8 8
	public String selectActivities(Activity[] activities){
		
		if(activities.length == 0){
			return "";
		}
		// sort by activity finish times
		Arrays.sort(activities, new Comparator<Activity>() {
			@Override
			public int compare(Activity o1, Activity o2) {
				if(o1.getEndTime() > o2.getEndTime() ){
					return 1;
				}
				else if(o1.getEndTime() < o2.getEndTime() ){
					return -1;
				}
				return 0;
			}
		});
		System.out.println(Arrays.toString(activities));
		String selectedActivities = "0";
		Activity selectedActivity = activities[0];
		for(int i=1; i < activities.length; i++){
			
			if(activities[i].getStartTime() >= selectedActivity.getEndTime()){
				selectedActivities += " "+i;
				selectedActivity = activities[i];
			}
		}
		return selectedActivities;
	}
	
	public static class Activity{
		
		private int startTime, endTime = 0;
		
		public Activity(int starttime, int endTime){
			this.startTime = starttime;
			this.endTime = endTime;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}
		
		@Override
		public String toString() {
			StringJoiner joiner = new StringJoiner(",","[","]");
			joiner.add(""+startTime).add(""+endTime);
			return joiner.toString();
		}
		
	}
}


