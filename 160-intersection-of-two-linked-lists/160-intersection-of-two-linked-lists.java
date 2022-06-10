/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode travA = headA, travB = headB;
        
        while(travA != null){
            
            travB = headB;
            
            while(travB != null){
                
                if(travA == travB){
                    return travA;
                }
                
                travB = travB.next;
            }
            
            travA = travA.next;
        }
        
        return null;
    }
    
}