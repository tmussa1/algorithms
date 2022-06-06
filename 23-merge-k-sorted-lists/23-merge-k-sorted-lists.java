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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0) return null;
            
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(ListNode curr: lists){
            while(curr != null){
                queue.offer(curr.val);
                curr = curr.next;
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        while(!queue.isEmpty()){
            head.next = new ListNode(queue.poll());
            head = head.next;
        }
        
        return dummy.next;
    }
}