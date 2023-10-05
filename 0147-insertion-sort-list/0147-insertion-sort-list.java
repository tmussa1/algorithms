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
    
    public ListNode insertionSortList(ListNode head) {
        
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        
        ListNode curr = head;
        
        while(curr != null){
            
            ListNode trav = dummyHead, prev = null;
            
            while(trav != null && curr.val > trav.val){
                prev = trav;
                trav = trav.next;
            }
            
            ListNode newNode = new ListNode(curr.val);
            prev.next = newNode;
            newNode.next = trav;
            curr = curr.next;
        }
        
        return dummyHead.next;
    }
}