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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next == null){
            return null;
        }
        
        ListNode temp = head;
        int size = 0;
        
        while(temp != null){
            temp = temp.next;
            size++;
        }
        
        if(size - n == 0){
            head = head.next;
            return head;
        }
        
        ListNode result = head;
        
        removeNthFromEnd(result, n, 0, size);
        
        return head;
    }
    
    private void removeNthFromEnd(ListNode head, int n, int curr, int size){
        
        if(head == null){
            return;
        }
        
        removeNthFromEnd(head.next, n, curr + 1, size);
        
        if(curr + n == size - 1) {
           head.next = head.next.next;
        } 
    }
}