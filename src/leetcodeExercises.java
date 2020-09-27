import java.sql.SQLOutput;
import java.util.*;

public class leetcodeExercises {

    /** 1. Two Sum Exercise **/

    /*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.


    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]*/

    public static Integer[] twoSum(Integer[] nums, int target) {
        //cycle through the nums array for a first index
        for (int i = 0; i < nums.length; i++) {
            //cycle through the nums array a second time for second index
            for (int j = i + 1; j < nums.length; j++) {
                //conditional statement to check if the second index is equal to the second parameter in method minus the 1st index
                if (nums[j] == target - nums[i]) {
                    //return the new result array as first index, second
                    return new Integer[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static Integer[] twoSumV2(Integer[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new Integer[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    /** 1. Two Sum Exercise End **/

    /** 2. Add Two Numbers **/
//    You are given two non-empty linked lists representing two non-negative integers.
//    The digits are stored in reverse order and each of their nodes contain a single digit.
//    Add the two numbers and return it as a linked list.
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//    Example:
//    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: 7 -> 0 -> 8
//    Explanation: 342 + 465 = 807.

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Declare local variables
        ListNode result = new ListNode(0);
        ListNode p = l1,
                q = l2,
                curr = result;
        // carry variable to store the number to carry over to the following summation of the lists
        int carry = 0;

        // while loop that will perform the calculation using l1 and l2 linked lists
        while(p != null || q != null) {
            int num1 = (p != null)? p.val : 0;
            int num2 = (q != null)? q.val: 0;
            int sum = carry + num1 + num2;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);

            // set the variable pointers to point to the following ListNode in the list
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }

        if(carry > 0) {
            curr.next = new ListNode(carry);
        }

        return result.next;
    }

    // method to help build the linked list from List<Integer>
    public static ListNode buildList(List<Integer> arr) {
        ListNode root = new ListNode(arr.get(0));
        ListNode current = root;
        for (int i = 1; i < arr.size(); i++) {
            current.next = new ListNode(arr.get(i));
            current = current.next;
        }
        return root;
    }
    /** 2. Add Two Numbers End **/

    /** 3. Longest Substring Without Repeating Characters **/

//    Given a string s, find the length of the longest substring without repeating characters.
//
//    Example 1:
//    Input: s = "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3.
//
//    Example 2:
//    Input: s = "bbbbb"
//    Output: 1
//    Explanation: The answer is "b", with the length of 1.
//
//    Example 3:
//    Input: s = "pwwkew"
//    Output: 3
//    Explanation: The answer is "wke", with the length of 3.
//    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//    Example 4:
//    Input: s = ""
//    Output: 0
//
//    Constraints:
//
//    0 <= s.length <= 5 * 104
//    s consists of English letters, digits, symbols and spaces.

    // Solution 1: O(n^2)
    public static int lengthOfLongestSubstring(String str)
    {
        int n = str.length();

        // Result
        int res = 0;
        for(int i = 0; i < n; i++)
        {

            // Note : Default values in visited are false
            boolean[] visited = new boolean[256];

            for(int j = i; j < n; j++)
            {
                // If current character is visited
                // Break the loop
                if (visited[str.charAt(j)] == true)
                    break;

                // Else update the result if
                // this window is larger, and mark
                // current character as visited.
                else
                {
                    res = Math.max(res, j - i + 1);
                    visited[str.charAt(j)] = true;
                }
            }

            // Remove the first character of previous
            // window
            visited[str.charAt(i)] = false;
        }
        return res;
    }

    // Solution 2: O(n) Linear
    static final int NO_OF_CHARS = 256;

    static int longestUniqueSubsttr(String str)
    {
        int n = str.length();

        int res = 0; // result

        // last index of all characters is initialized
        // as -1
        int [] lastIndex = new int[NO_OF_CHARS];
        Arrays.fill(lastIndex, -1);

        // Initialize start of current window
        int i = 0;

        // Move end of current window
        for (int j = 0; j < n; j++) {

            // Find the last index of str[j]
            // Update i (starting index of current window)
            // as maximum of current value of i and last
            // index plus 1
            i = Math.max(i, lastIndex[str.charAt(j)] + 1);

            // Update result if we get a larger window
            res = Math.max(res, j - i + 1);

            // Update last index of j.
            lastIndex[str.charAt(j)] = j;
        }
        return res;
    }
    /** 3. Longest Substring Without Repeating Characters **/

    public static void main(String[] args) {
//        Integer [] arr = new Integer[] { 3,2,4 };
//        Integer [] res = twoSumV2(arr, 6);
//        System.out.println(Arrays.asList(res));
//        List<Integer> list1 = new ArrayList<>(Arrays.asList( 1, 0, 0, 0, 0, 0, 0, 1 ));
//        List<Integer> list2 = new ArrayList<>(Arrays.asList( 5, 6, 4 ));
//
//        ListNode l1 = buildList(list1);
//        ListNode l2 = buildList(list2);
//
//        ListNode rt = addTwoNumbers(l1, l2);
//        ListNode current = rt;
//        while (current != null) {
//            System.out.println(current.val);
//            current = current.next;
//        }
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
