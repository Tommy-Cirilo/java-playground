import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcodeExercises {

    //Two Sum Exercise

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

//    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
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

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {}

    public static void main(String[] args) {
//        Integer [] arr = new Integer[] { 3,2,4 };
//        Integer [] res = twoSumV2(arr, 6);
//        System.out.println(Arrays.asList(res));
        int[] list1 = new int[] { 2, 4, 3 };
        int[] list2 = new int[] { 5, 6, 4 };

        ListNode l1 = buildList(list1);
        ListNode l2 = buildList(list2);

//        System.out.println(l1.val);
        ListNode current = l1;
        while(current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public static ListNode buildList(int[] arr) {
        ListNode root = new ListNode(arr[0]);
        ListNode current = root;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return root;
    }
}
