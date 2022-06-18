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
    public ListNode plusOne(ListNode head) {
        
        ListNode rev = reverseList(head);
        ListNode trav = rev, prev = null;
        int carry = 1;
        
        while(rev != null){
            int temp = rev.val + carry;
            rev.val = temp % 10;
            carry = temp / 10;
            prev = rev;
            rev = rev.next;
        }
        
        if(carry > 0){
            ListNode newNode = new ListNode(1);
            prev.next = newNode;
        }
        
        ListNode result = reverseList(trav);
        
        return result;
    }
    
    private ListNode reverseList(ListNode head){
        
        ListNode curr = head, prev = null;
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}