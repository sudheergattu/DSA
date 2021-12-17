package algs.array;

import java.util.HashSet;
import java.util.Set;

/*Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

		 

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109*/
public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4}; //{1,1,1,3,3,4,3,2,4,2}
		containsDuplicate(nums);
	}
	
	//Time complexity is O(n2),Time limit exceeded in leet code
	
	/*
	 * public static boolean containsDuplicate(int[] nums) { 
	 * for (int i = 0; i < nums.length; ++i) {
	 *  for (int j = 0; j < i; ++j) { 
	 *  if (nums[j] == nums[i])
	 * 		return true; 
	 *	 } 
	 * } 
	 * return false; 
	 * }
	 */

	//In this approach, first data is sorted, then intuition is duplicate elements will be consecutive
	//his approach employs sorting algorithm. Since comparison sorting algorithm like heapsort is known to provide O(n \log n)O(nlogn) worst-case performance, sorting is often a good preprocessing step. 
	//After sorting, we can sweep the sorted array to find if there are any two consecutive duplicate elements.
	/*public static boolean containsDuplicate(int[] nums) {
	    Arrays.sort(nums);
	    for (int i = 0; i < nums.length - 1; ++i) {
	        if (nums[i] == nums[i + 1]) return true;
	    }
	    return false;
	}*/
	//Time complexity: O(n)O(n). We do search() and insert() for nn times and each operation takes constant time.
	//Space complexity: O(n)O(n). The space used by a hash table is linear with the number of elements in it
	
	 public static boolean containsDuplicate(int[] nums) {
	     boolean containsDuplicate = false;
	     Set<Integer> set = new HashSet<>();
	      for(int i=0;i<nums.length;i++){
	          if(set.contains(nums[i])){
	              containsDuplicate = true;
	              break;
	          }
	          else{
	              set.add(nums[i]);
	          }
	      }  
	        return containsDuplicate;
	    }
}
