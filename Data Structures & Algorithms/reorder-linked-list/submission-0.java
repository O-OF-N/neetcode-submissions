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

    private void print(ListNode input) {
        ListNode c = input;
        while(c!=null) {
            System.out.println(c.val);
            c = c.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode first = null;
        ListNode current = head;
        while(current!=null) {
            ListNode next = current.next;
            current.next = null;
            if(first!=null) {
                current.next = first;  
            } 
            first = current;
            current = next;
        }
        return first;
        
    }

    public ListNode split(ListNode head, int length) {
        int mid = length%2==0?length/2-1:length/2;
        System.out.println("length = " + length);
        System.out.println("mid = " + mid);
        int currentPos = 0;
        ListNode current = head;
        while(currentPos<mid) {
            current = current.next;
            currentPos++;
        }
        ListNode next = current.next;
        current.next = null;
        return next;
        
    }

    private int findLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        // Find length
        while(current!=null) {
            length++;
            current = current.next;
        }
        return length;
    }
    private void merge(ListNode head, ListNode tail) {
        ListNode h = head;
        ListNode t = tail;

        while (h != null && t != null) {

            ListNode hNext = h.next;
            ListNode tNext = t.next;

            h.next = t;
            t.next = hNext;

            h = hNext;
            t = tNext;
        }
    }


    public void reorderList(ListNode head) {
        int length = findLength(head);
        ListNode tail = split(head, length);
        ListNode reversedTail = reverseList(tail);
        System.out.println("printing head ");
        print(head);
        System.out.println("printing tail ");
        print(reversedTail);
        merge(head,reversedTail );

    }
}
