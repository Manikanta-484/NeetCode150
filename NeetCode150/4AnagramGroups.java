/* Anagram Groups
Solved 
Medium
Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: strs = ["act","pots","tops","cat","stop","hat"]

Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
Copy
Example 2:

Input: strs = ["x"]

Output: [["x"]]
Copy
Example 3:

Input: strs = [""]

Output: [[""]]  */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> ans = new HashMap<>();
        for(String s: strs){
            int[] count= new int[26];
            for(char c: s.toCharArray()){
                count[c-'a']++;
            }

            String key= Arrays.toString(count);
            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList<>());
            }

            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}
