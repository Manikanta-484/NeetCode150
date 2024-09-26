/* Duplicate Integer
Solved 
Easy
Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

Example 1:

Input: nums = [1, 2, 3, 3]

Output: true
Copy
Example 2:

Input: nums = [1, 2, 3, 4]

Output: false

*/

class Solution {
    public boolean hasDuplicate(int[] nums) {
         Set<Integer> uniques = new HashSet<>();
         for(int i=0;i<nums.length;i++){
            if(uniques.contains(nums[i])){
                return true;
            }
            uniques.add(nums[i]);
         }
         return false; 
    }
}
