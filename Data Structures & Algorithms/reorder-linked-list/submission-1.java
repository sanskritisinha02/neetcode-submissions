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
    public void reorderList(ListNode head) {

        //1. Find middle - slowPtr, fastPtr.
        //2. Split in two lists
        //3. Reverse second half
        //4. Merge two lists

        //1. Find middle
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

        }

        //2. split in 2 parts

        ListNode second = slow.next;
        slow.next = null;

        //3. reverse second half

        ListNode prev = null;
        ListNode current = second;

        while(current != null){

            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        //4. merge two lists
        ListNode first = head;
        second = prev;

        while(second!= null){
            ListNode temp1 = first.next; //2->3
            ListNode temp2 = second.next; //5

            first.next = second; //1->4->5
            second.next = temp1; //1->4->2->3->5

            first = temp1;
            second = temp2;

        }
        
    }
}
