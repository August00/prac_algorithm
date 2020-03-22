package LinkedList;

/* item id : 19. https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/
** 删除链表的倒数第N个节点
*/
public class RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode zero = new ListNode(0); //新建一个头节点是为了让要删除的元素是原头节点的时候更好操作
        zero.next = head;
        ListNode pre = zero;
        ListNode bak = zero;
        ListNode del = null;
        for(int f = 0;f<n && null != pre.next;f++)
            pre = pre.next;
        while(null != pre.next)
        {
            pre = pre.next;
            bak = bak.next;
        }
        del = bak.next;
        bak.next = del.next;
        del.next = null;
        return zero.next;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd r = new RemoveNthFromEnd();
        ListNode n1 = r.new ListNode(1);
        ListNode n2 = r.new ListNode(2);
        ListNode n3 = r.new ListNode(3);
        ListNode n4 = r.new ListNode(4);
        ListNode n5 = r.new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
//        n4.next = n5;
//        n5.next = null;
        ListNode res = r.removeNthFromEnd(n1,3);
        while (null != res) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
