package com.StriverSheet;

import java.util.Arrays;

public class Successful_pairs {

	public static void main(String[] args) {

		int[] spells = { 5, 1, 3 };
		int[] potions = { 1, 2, 3, 4, 5 };
		long success = 7;
		
		

		int[] pairs = successfulPairs(spells, potions, success);
		for (int i = 0; i < pairs.length; i++) {
			System.out.print(pairs[i] + " ");
		}
	}
	
	

	public static int[] successfulPairs(int[] spells, int[] potions, long success) {
		int n = spells.length;
		int m = potions.length;
		int[] pair = new int[n];

		// Sort potions array for binary search
		Arrays.sort(potions);

		for (int i = 0; i < n; i++) {
			int lo = 0;
			int hi = m - 1;
			int spell = spells[i];

			// Perform binary search to find the smallest valid potion
			while (lo <= hi) {
				int mid = lo + (hi - lo) / 2;
				long product = (long) spell * potions[mid];

				if (product >= success) {
					hi = mid - 1; // We can potentially reduce the range
				} else {
					lo = mid + 1; // We need a larger potion
				}
			}

			// After binary search, lo will be the index of the first valid potion
			// The number of valid potions will be from index `lo` to the end of the array
			pair[i] = m - lo;
		}

		return pair;
	}
}


//largest number leetcode
//String[] arr=new String[nums.length];
//String s="";
//for(int i=0; i<nums.length;i++){
//
//   arr[i]=nums[i]+s;
//}
//
//Arrays.sort(arr,(a,b)->{
//
//      long p1=Long.parseLong(a+b);
//      long p2=Long.parseLong(b+a);  
//
//      if(p1>p2){
//         return 1;
//      } else if(p1<p2){
//       return -1;
//      }else {
//       return 0;
//      }
//
//});
//
//StringBuilder sb=new StringBuilder();
//
//for(int i=arr.length-1;i>=0;i--){
//   sb.append(arr[i]);
//}
//
//if(sb.charAt(0)=='0'){
//   return "0";
//}
//  
//return sb.toString();   
//
