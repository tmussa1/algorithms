/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        boolean isPalindrome = true;
            
        Stack<Integer> stInt = new Stack<>();
        Queue<Integer> qInt = new LinkedList<>();
        
        while(head != null){
            
            stInt.push(head.val);
            qInt.add(head.val);
        
            head = head.next;
        }
        
        while(!qInt.isEmpty() && !stInt.empty()){
            if(!stInt.pop().equals(qInt.poll())){
                return false;
            } 
        }
        return true;
    }
}