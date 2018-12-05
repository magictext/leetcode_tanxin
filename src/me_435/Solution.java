package me_435;

import java.util.Arrays;
import java.util.Comparator;

import javax.swing.text.StyledEditorKit.BoldAction;

import jdk.management.resource.internal.UnassignedContext;

//Arrays.sort(intervals,new Comparator<Interval>() {
//@Override
//public int compare(Interval o1, Interval o2) {
//	// TODO Auto-generated method stub
//	if(o1.start!=o2.start)
//		return o1.start-o2.start;
//	else 
//		return o1.end-o2.end;
//}
//});
public class Solution {
	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals.length == 0)
			return 0;
		int max = intervals[0].end, mini = intervals[0].start;
		for (Interval interval : intervals) {
			max = max > interval.end ? max : interval.end;
			mini = mini < interval.start ? mini : interval.start;
		}
		boolean goal[] = new boolean[max - mini + 1];
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if (o1.start != o2.start)
					return (o1.end - o1.start) - (o2.end - o2.start);
				else
					return o1.start - o2.start;
			}
		});
		int count = 0;
		for (Interval item : intervals) {
			boolean flag = true;
			for (int i = item.start - mini; i < item.end - mini; i++) {
				if (goal[i] == true)
					flag = false;
			}
			if (flag == true) {
				Arrays.fill(goal, item.start - mini, item.end - mini, true);
			} else {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		boolean goal[] = new boolean[100];
		Arrays.fill(goal, 3, 5, true);
		System.out.println(Arrays.toString(goal));

	}
}
