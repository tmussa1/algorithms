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
    
    public ListNode partition(ListNode head, int x) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        List<Integer> nodeList = new ArrayList<>();
        ListNode trav1 = head, trav2 = head;
        
        while(trav1 != null){
            if(trav1.val < x){
                nodeList.add(trav1.val);
            }
            trav1 = trav1.next;
        }
        
        while(trav2 != null){
            if(trav2.val >= x){
                nodeList.add(trav2.val);
            }
            trav2 = trav2.next;
        }
        
        ListNode node = new ListNode(nodeList.get(0));
        ListNode prev = node;
        
        for(int i = 1; i < nodeList.size(); i++){
            
            ListNode newNode = new ListNode(nodeList.get(i));
            prev.next = newNode;
            prev = prev.next;
        }
        
        return node;
    }
}