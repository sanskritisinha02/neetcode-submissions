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

        //1. Find middle
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(slowPtr != null && fastPtr != null && fastPtr.next != null){

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        //2. Split into two lists
        //eg. 1->2->3->4->5
        ListNode second = slowPtr.next; //2nd is created (4->5)
        slowPtr.next = null; //1st is splited (1->2->3)

        //3. Reverse second half
        ListNode prev = null;
        while(second != null){
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        //4. Merge two lists
        ListNode first = head;
        second = prev;

        while(second != null){
            ListNode temp1 = first.next; //2 (1->"2"->3)
            ListNode temp2 = second.next; //4 (5->"4")

            first.next = second; // 1->4->5
            second.next = temp1; //2->3

            first = temp1;
            second = temp2;
        }
    }
}
