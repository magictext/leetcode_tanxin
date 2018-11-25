package me_406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLBoundFault;

public class Solution {
	public void swap(int [][]arr,int x,int y) {
		int tempx=arr[0][x];
		int tempy=arr[1][x];
		arr[0][x]=arr[0][y];
		arr[1][x]=arr[1][y];
		arr[0][y]=tempx;
		arr[1][y]=tempy;
	}
	public void sort(int [][]arr,int x,int y) {
		if(x>=y) return;
//		System.out.println(x+"\t"+y);
//		System.out.println(Arrays.deepToString(arr));
		int fo=x,to=y;
		int goal=arr[0][x];
		x++;
		int flag1=0,flag2=0;
		while(x<y){
			if(arr[0][x]<=goal){
				flag1=1;
			}else {
				x++;
			}
			if(arr[0][y]>=goal){
				flag2=1;
			}else {
				y--;
			}
			if(flag1+flag2==2){
				swap(arr, x, y);
				flag1=0;
				flag2=0;
				x++;
				y--;
			}
		}
		swap(arr, y, fo);
		sort(arr,fo, y-1);
		sort(arr, y+1, to);
		
	}
	public int[][] reconstructQueue(int[][] people) {
//		if(people==null) return null;
//        sort(people, 0, people[0].length-1);
//        System.out.println(Arrays.deepToString(people));
//        List<int[]>  res=new LinkedList<>();        //������
//        for(int i=0;i<people.length;i++){
//            int[] peo = people[i];
//            res.add(peo[1], peo);
//        }
//        return res.toArray(new int[people.length][]);
		//�������������� ���鲻��ֱ�Ӳ� 
		Arrays.sort(people, new Comparator<int []>() {        //����߽�������(h�����ǰ��)����k�Ĵ�С��������(kС����ǰ��)
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) return -a[0]+b[0];
                else return a[1]-b[1];
            }
        });
        List<int[]>  res=new LinkedList<>();        //������
         
        for(int i=0;i<people.length;i++){
            int[] peo = people[i];
            res.add(peo[1], peo);
        }
        return res.toArray(new int[people.length][]);
    }
	public static void main(String[] args) {
		int[][] people={{7,4,7,5,6,5},{0,4,1,0,1,2}};
		System.out.println(Arrays.deepToString(new Solution().reconstructQueue(people)));
	}
}
