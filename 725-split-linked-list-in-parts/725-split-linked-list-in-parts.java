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
    
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        int length = 0;
        
        ListNode curr = head;
        
        while(curr != null){
            length++;
            curr = curr.next;
        }
        
        int oneListSize = length / k;
        int leftOver = length % k;
        
        ListNode [] result = new ListNode[k];
        
        curr = head;
        ListNode prev = head, temp = head;
        int i = 0, count = 0;
        
        while(curr != null){
            
            int plusOne = leftOver > 0 ? 1 : 0;

            i = 0;
            
            while(curr != null && i < oneListSize + plusOne){
                prev = curr;
                curr = curr.next;
                i++;
            }

            result[count++] = temp;
            temp = prev.next;
            prev.next = null;
            curr = temp;
            leftOver--;
        }
        
        return result;
    }
}