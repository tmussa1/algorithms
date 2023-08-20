/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        
        int count = 0;
        
        ListNode iterator = head; 
        
        while(iterator != null){
            iterator = iterator.next;
            count += 1;
        }
        
        int iter = (count / 2);
        
        ListNode result = head;
        
        while(iter > 0){
            result = result.next;
            iter--;
        }
        
        return result;
    }
}