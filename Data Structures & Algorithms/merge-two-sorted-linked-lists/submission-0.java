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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current1 = null;
        ListNode current2 = null;
        if(list1==null && list2!=null) {
            current1 = list2;
            list1 = list2;
            list2 = null;
        }
        if(list1==null && list2==null) {
            return null;
        }
        if(list2==null || list1.val<list2.val) {
            current1 = list1;
            current2 = list2;
        }   else {
            current1 = list2;
            current2 = list2.next;
            current1.next = list1;
        }
        ListNode result = current1;
        while(current1!=null && current2!=null) {
            if(current1.next!=null) {
                if(current1.next.val<=current2.val) {
                    current1 = current1.next;
                } else {
                    ListNode next1 = current1.next;
                    ListNode next2 = current2.next;
                    current1.next = current2;
                    current2.next = next1;
                    current2 = next2;
                    current1 = current1.next;
                }
            } else {
                current1.next = current2;
                break;
            }
        }
        return result;
    }
}