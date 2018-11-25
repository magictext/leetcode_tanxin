package me_392;

public class Solution {
	public boolean isSubsequence(/*¶Ì*/String s, /*³¤*/String t) {
		if(s.length()==0) return true;
		char str1[] = t.toCharArray();//³¤
		char str2[] = s.toCharArray();//¶Ì
		int i = 0, j = 0;
		while (i < str1.length) {
			//System.out.println(j+"\t"+i);
			if(j==str2.length) return true;
			if (str1[i] == str2[j]) {
				j++;
			}
			i++;
			if(j==str2.length) return true;
			System.out.println(j+"\t"+i);
		}
			return false;
	}

	public static void main(String[] args) {
		String s = "axc", t = "ahbgdc";
		System.out.println(new Solution().isSubsequence(s, t));
	}
}
