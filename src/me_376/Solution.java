package me_376;


public class Solution {
	public int wiggleMaxLength(int[] nums) {
		if(nums.length==0) return 0;
		boolean flag = nums[0]<nums[1];
		int p=0;
		int length = 1, prev = nums[0];
        for(int i=0; i<nums.length; ++i) {
            if(nums[i] == prev) continue;
            if(p==0){
            	flag = !(nums[i]>prev);
            	p++;
            	}
            if( flag != nums[i]>prev) {
                flag = (nums[i]>prev);
                System.out.println(nums[i]+"\t"+prev);
                ++length;
            }
            prev = nums[i];
        }
        
        return length;

//		int cha[]=new int[nums.length];
//		cha[0]=0;
//		int goal[]=new int[nums.length];
//		goal[0]=1;
//		for (int i = 1; i < cha.length; i++) {
//			cha[i]=nums[i]-nums[i-1];
//		}
//		for (int i = 1; i < goal.length; i++) {
//			if(i==1){
//				goal[i]=1;
//				continue;
//			}else {
//				if(cha[i]*cha[i-1]<0){
//					goal[i]=goal[i-1]+1;
//				}else {
//					goal[i]=1;
//				}
//			}
//		}
//        return 0;
    }
	public static void main(String[] args) {
		int nums[]={1,2,1,2,2,1,2,1,1,2};
		System.out.println(new Solution().wiggleMaxLength(nums));
	}
}
