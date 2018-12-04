package me_452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public int findMinArrowShots(int[][] points) {
		Arrays.sort(points,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0]!=o2[0]) {
					return o1[0]-o2[0];
				}else {
					return o1[1]-o2[1];
				}
			}
		});
		//System.out.println(Arrays.deepToString(points));
		
		int low=points[0][0],high=points[0][1],count=1;
		for (int[] is : points) {
			if(is[1]<high){
				high=is[1];
			}else {
				if(is[0]<high){
					continue;
				}else {
					//System.out.println(Arrays.toString(is));
					count++;
					//low=is[0];
					high=is[1];
				}
			}
			
		}
		return count;
    }
	public static void main(String[] args) {
		int [][]points={{10,16},{2,8},{1,6},{7,12},{13,14}};
		System.out.println(new Solution().findMinArrowShots(points));
	}
}
