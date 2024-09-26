/* Top K Elements in List
Medium
Given an integer array nums and an integer k, return the k most frequent elements within the array.

The test cases are generated such that the answer is always unique.

You may return the output in any order.

Example 1:

Input: nums = [1,2,2,3,3,3], k = 2

Output: [2,3]
Copy
Example 2:

Input: nums = [7,7], k = 1

Output: [7]


Example 1:
Input: nums = [1,2,2,3,3,3], k = 2

In this array:

The number 1 appears 1 time.
The number 2 appears 2 times.
The number 3 appears 3 times.
Since the problem is asking for the 2 most frequent elements (because k = 2), we look at the numbers with the highest frequency:

3 (appears 3 times)
2 (appears 2 times)
So, the output will be [2, 3] (you can return the elements in any order).

Step 1
frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
This line is used to update the frequency of a number (num) in the HashMap.
Explanation of getOrDefault() method:
Syntax: V getOrDefault(Object key, V defaultValue)
key: The key whose value you want to retrieve (in this case, num).
defaultValue: The value that will be returned if the key is not present in the map (in this case, 0).


Step2
PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> frequencyMap.get(n1) - frequencyMap.get(n2));
This line creates a PriorityQueue (also known as a min-heap) that stores integers (Integer type). The key part here is the custom comparator: ((n1, n2) -> frequencyMap.get(n1) - frequencyMap.get(n2)). This comparator helps maintain the priority queue in a way that keeps the elements with the lowest frequency at the top.


IMP:
Custom Comparator: (n1, n2) -> frequencyMap.get(n1) - frequencyMap.get(n2)

This defines how the elements in the priority queue are compared.
The comparison is based on the frequency of each element (n1, n2) in the array, as stored in frequencyMap.
If frequencyMap.get(n1) is less than frequencyMap.get(n2), n1 will have a higher priority in the heap (i.e., appear earlier or be the root of the heap).



removetthe least freq elements
if (heap.size() > k) {
    heap.poll(); // Remove the element with the lowest frequency
}
Purpose:
This condition checks if the size of the PriorityQueue exceeds k. If it does, we remove the element with the lowest frequency (which is at the top of the heap) using heap.poll().

Why Do We Need This?
The goal of the problem is to return exactly k most frequent elements from the array. So we use this logic 
When you poll a heap, the element that is removed is the largest or smallest value, depending on whether the heap is a max-heap or a min-heap, respectively. The removed value is always at the root of the heap. 

*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> freMap = new HashMap<>();

        for(int num : nums){
            freMap.put(num,freMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2)->freMap.get(n1)-freMap.get(n2));

        for(int num: freMap.keySet()){
            heap.add(num);
            if(heap.size()>k){
                heap.poll();
            }
        }

        int[] res = new int[k];
        for(int i=k-1;i>=0;i--){
            res[i]=heap.poll();
        }

        return res;
    }
}

