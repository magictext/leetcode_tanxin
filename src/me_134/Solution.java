package me_134;

import java.util.Arrays;

public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int length=gas.length;
        int get[]=new int[length];
        for(int i=0;i<length;i++){
        	get[i]=gas[i]-cost[i];
        }
        int[] t1=get.clone();
        int[] res=t1.clone();
        for(int i=1;i<length;i++){
        	System.out.println(Arrays.toString(t1));
        	for(int j=0;j<length;j++){
        		res[j]=t1[(j-1+length)%length]+get[j];
        		if(t1[(j-1+length)%length]<0){
        			res[j]=-999999;
        		}
        	}
        	t1=res.clone();
        }
        for(int i=0;i<length;i++){
        	if(res[i]>=0){
        		return (i+length+1)%length;
        	}
        }
        return -1;
    }
	public static void main(String[] args) {
		int gas[]={1,2,3,4,5};
		int cost[]={3,4,5,1,2};
		System.out.println(new Solution().canCompleteCircuit(gas, cost));
	}
}
