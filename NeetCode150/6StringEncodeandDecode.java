/* String Encode and Decode
Solved 
Medium
Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]
Copy
Example 2:

Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]

*/

class Solution {

    // This method encodes a list of strings into a single string
    public String encode(List<String> strs) {
        // StringBuilder to store the encoded string
        StringBuilder encodedString = new StringBuilder();
        
        // Iterate through each string in the list
        for (String str : strs) {
            // Append the length of the string, followed by the '#' delimiter, then the actual string
            // Example: if str = "neet", encoded as "4#neet"
            encodedString.append(str.length()).append("#").append(str);
        }
        // Return the final encoded string
        return encodedString.toString();
    }

    // This method decodes the encoded string back into the original list of strings
    public List<String> decode(String str) {
        // Create a list to store the decoded strings
        List<String> list = new ArrayList<>();
        
        // Initialize an index `i` to traverse the encoded string
        int i = 0;
        
        // While we haven't reached the end of the encoded string
        while (i < str.length()) {
            // Start from position `i` to find the next '#' delimiter
            int j = i;
            // Move `j` forward until we find the '#' character
            while (str.charAt(j) != '#') j++;
            
            // Extract the length of the string by taking the substring from `i` to `j`
            // Convert that substring into an integer (this tells us the length of the next string)
            int length = Integer.valueOf(str.substring(i, j));
            
            // Move `i` forward:
            // - `j + 1` moves past the '#' character
            // - `length` moves forward by the length of the actual string we need to extract
            i = j + 1 + length;
            
            // Extract the actual string using `substring(j + 1, i)` and add it to the list
            // `j + 1` skips over the '#' and `i` now points to the end of the string
            list.add(str.substring(j + 1, i));
        }
        
        // Return the list of decoded strings
        return list;
    }
}
