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
    
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode curr = head;
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        while(curr != null){
            countMap.put(curr.val, countMap.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }
        
        curr = head;
        ListNode prev = dummy;
        
        while(curr != null){
            
            while(curr != null && countMap.get(curr.val) > 1){
                curr = curr.next;
            }
            
            prev.next = curr;
            prev = curr;
            curr = curr == null ? null : curr.next;
        }
        
        return dummy.next;
    }
}