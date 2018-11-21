package me_55;

import java.util.Arrays;

import sun.net.www.content.audio.x_aiff;

public class Solution {
	public boolean canJump(int[] nums) {
		boolean arr[]=new boolean[nums.length];
		for(int i=0 ;i<nums.length;i++){
			arr[i]=false;
		}
		arr[0]=true;
		for(int j=0;j<nums.length;j++){
			if(arr[j]==true){
				for(int x=j;x<nums.length&&x<=j+nums[j];x++){
					arr[x]=true;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		if(arr[arr.length-1]==true)
			return true;
		else {
			return false;
		}
		
    }
	public static void main(String[] args) {
		int nums[]={3,2,1,0,4};
		System.out.println(new Solution().canJump(nums));
	}
}
