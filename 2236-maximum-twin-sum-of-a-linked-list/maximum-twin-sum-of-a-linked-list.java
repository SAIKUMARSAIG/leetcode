/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head,fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast!=null){
            slow = slow.next;
        }
        ListNode rev = reverse(slow);
        ListNode temp = head;
        int sum = 0;
        while (temp!=null && rev!=null){
            sum = Math.max(temp.val+rev.val,sum);
            temp = temp.next;
            rev = rev.next;
        }
        return sum;
    }
    public static ListNode reverse(ListNode head){
        ListNode prev = null,temp = head;
        while (temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}