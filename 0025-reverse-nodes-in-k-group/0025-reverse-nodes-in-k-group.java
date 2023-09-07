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

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while(true){

            ListNode kth = findKth(groupPrev, k);

            if(kth == null){
                break;
            }

            ListNode groupNext = kth.next;

            ListNode prev = groupNext, curr = groupPrev.next;

            while(curr != groupNext){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }

        return dummy.next;
    }

    private ListNode findKth(ListNode curr, int k){

        while(curr != null && k > 0){
            k--;
            curr = curr.next;
        }

        return curr;
    }
}