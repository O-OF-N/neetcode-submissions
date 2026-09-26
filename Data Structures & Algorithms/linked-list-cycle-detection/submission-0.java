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
    public boolean hasCycle(ListNode head) {
        Set<Long> seen = new HashSet<>();
        while(head!=null) {
            long code = head.hashCode();
            if(seen.contains(code)) {
                return true;
            }
            seen.add(code);
            head= head.next;
        }
        return false;
        
    }
}
