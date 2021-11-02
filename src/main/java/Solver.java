import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solver {
    static boolean isThisWordAPalindromeOrderN(String s) {
        if (s == null || s.length() <= 1) return true;
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < s.length() && j >= i; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    static boolean isThisSentenceAPalindromeOrderN(String s) {
        if (s == null) return false;
        if (s.length() <= 1) return true;
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < s.length() && j >= i; ++i, --j) {
            while (!Character.isAlphabetic(s.charAt(i))) ++i;
            while (!Character.isAlphabetic(s.charAt(j))) --j;

            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0, r, l = 0;

        Set<Character> charSet = new HashSet();
        for (r = 0; r < s.length(); ++r) {
            char c = s.charAt(r);
            while (charSet.contains(c)) {
                charSet.remove(s.charAt(l));
                ++l;
            }
            charSet.add(c);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }


    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     * Example 2:
     * <p>
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     * Example 3:
     * <p>
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in each linked list is in the range [1, 100].
     * 0 <= Node.val <= 9
     * It is guaranteed that the list represents a number that does not have leading zeros.
     */

    /* Definition for singly-linked list. */
    static public class ListNode {

        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1 == null && l2 == null) return null;

        ListNode result = new ListNode();
        ListNode current = result;
        ListNode left = l1;
        ListNode right = l2;
        int carry = 0;
        do {
            int sum = left.val + right.val + carry;
            carry = 0;
            current.val = sum % 10;
            carry = sum / 10;
            left = left.next;
            right = right.next;

            if (left == null && right == null) break;
            else if (left == null && right != null) {
                left = new ListNode(0);
            } else if (left != null && right == null) {
                right = new ListNode(0);
            }

            ListNode next = new ListNode();
            current.next = next;
            current = next;
        } while (true);

        if (carry != 0) current.next = new ListNode(carry);

        return result;
    }

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * You can return the answer in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     * <p>
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     * <p>
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * Only one valid answer exists.
     * <p>
     * <p>
     * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
     */
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexer = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (indexer.containsKey(nums[i])) return new int[]{indexer.get(nums[i]), i};

            indexer.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }


//    static boolean isWordRotated(String source, String target) {
//        if (source==null && target==null) return true;
//        if (source==null || target==null) return false;
//        if (source.length()==0 && target.length()==0) return true;
//        if (source.length()!=target.length()) return false;
//
//        source =source.toLowerCase();
//        target = target.toLowerCase();
//        if (source.equals(target)) return true;
//
//        for (int i=0; i<target.length(); ++i) {
//            for (int j=i+1, j)
//        }
//
//        //If source is leading by 1
//        if (source.substring(1).equals(target.substring(0, target.length()-2))) return true;
//        //If target is leading by 1
//        if (target.substring(1).equals(source.substring(0, source.length()-2))) return true;
//
//        StringBuilder tarSb = new StringBuilder(target);
//        for (int i=0, j=source.length()-1; i<source.length(); i++, --j) {
//            int j = source.length()-(i +1);
//            char tmp = tarSb.charAt(source.length()-(i+i));
//            tarSb.deleteCharAt()
//            tarSb.insert(i, tarSb)
//        }
//    }
}
