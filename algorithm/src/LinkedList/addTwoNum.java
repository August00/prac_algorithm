
/*题目描述：
*   给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    https://leetcode-cn.com/problems/add-two-numbers
* */

package LinkedList;

public class addTwoNum {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode num1 = l1;
        ListNode num2 = l2;
        int addnum = 0;//用于保存进位的
        ListNode head = new ListNode((num1.val+num2.val)%10);
        ListNode tail = head;
        addnum = ((num1.val+num2.val)>9)?1:0;
        num1 = num1.next;
        num2 = num2.next;
        while(num1!=null && num2!=null)
        {
            ListNode node = new ListNode((num1.val+num2.val+addnum)%10);
            tail.next = node;
            tail = node;
            addnum = ((num1.val+num2.val+addnum)>9)?1:0;
            num1 = num1.next;
            num2 = num2.next;

        }
        while(num1!=null){
            ListNode node = new ListNode((num1.val+addnum)%10);
            tail.next = node;
            tail = node;
            addnum = ((num1.val+addnum)>9)?1:0;
            num1 = num1.next;
        }

        while(num2!=null){
            ListNode node = new ListNode((num2.val+addnum)%10);
            tail.next = node;
            tail = node;
            addnum = ((num2.val+addnum)>9)?1:0;
            num2 = num2.next;
        }

        //最后判断一下是否有上一次进位的遗留，如果没有以下，542+9465的结果就会变成0007了
        if(addnum==1){
            ListNode node = new ListNode(1);
            tail.next = node;
        }
        return head;
    }

    public static void main(String[] args){
        ListNode head1 = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        head1.next = node1;
        node1.next = node2;
        node2.next = null;

        ListNode head2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(9);
        head2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode res = addTwoNumbers(head1,head2);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }

}
