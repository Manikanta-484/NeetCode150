Is Anagram
Solved 
Easy
Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

/* An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: s = "racecar", t = "carrace"

Output: true
Copy
Example 2:

Input: s = "jar", t = "jam"

Output: false
Copy
Constraints:

s and t consist of lowercase English letters.*/

class Solution {
    public boolean isAnagram(String s, String t) {
            if(s.length()!=t.length()) return false;
            
            int[] store = new int[26];

            for(int i=0;i<s.length();i++){
                store[s.charAt(i)-'a']++;
                store[t.charAt(i)-'a']--;
            }

            for(int n:store){
                if(n!=0){
                    return false;
                }
            }
            return true;
    }
}

