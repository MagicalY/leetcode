/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        
        ListNode head = null;
        ListNode n1 = l1, n2 = l2;
        while (n1 != null) {
            s1.push(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            s2.push(n2);
            n2 = n2.next;
        }
        
        int sum = 0;
        while (!s1.empty() || !s2.empty() || sum != 0) {
            if (!s1.empty()) {
                sum += s1.peek().val;
                s1.pop();
            }
            
            if (!s2.empty()) {
                sum += s2.peek().val;
                s2.pop();
            }
            
            ListNode cur = new ListNode(sum % 10);
            cur.next = head;
            head = cur;
            sum = sum / 10;
        }
        return head;
    }
}
