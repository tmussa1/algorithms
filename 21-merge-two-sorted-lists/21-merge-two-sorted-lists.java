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
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
      ListNode head = new ListNode(0);
      ListNode result = head;
      int min = 0;  
        
      while(l1 != null || l2 != null){
          
          if(l2 == null || (l1 != null && l1.val < l2.val)){
            min = l1.val;
            l1 = l1.next;
          } else {
            min = l2.val;
            l2 = l2.next;
          }
          
          head.next = new ListNode(min);
          head = head.next;
      }
        
        
      return result.next;
    }
}