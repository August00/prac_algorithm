//翻转单链表

public class ReverseLinklist {
    public ReverseLinklist(){}

    static class Node {
        private Node next;
        private int data;

        public Node(int data){
            this(data,null);
        }

        public Node(int data,Node next){
            this.next = next;
            this.data = data;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public Node getNext(){
            return next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    //递归,传入以node为头结点的单链表,返回翻转后的新的头节点
    public Node reverseRecursive(Node node){
        if(node==null||node.getNext()==null){//说明是一个空链表或者当前遍历到了最后一个节点
            return node;
        }
        Node newhead = reverseRecursive(node.getNext());//将当前node子链表翻转后的头结点记录下来
        node.getNext().setNext(node);//把当前节点的下一个节点的next指向当前节点（即指向翻转）
        node.setNext(null);//把当前节点指向下一个节点的路给抹了（留着干啥,装双向链表呢）

        return newhead;
    }

    //非递归,传入以node为头结点的单链表,返回翻转后的新的头节点
    public Node reverseNormal(Node node){
        if(node == null) return node;//空链表,直接返回
        Node cur = node;
        Node next = cur.getNext();
        Node temp = null;
        while(next!=null){//当前链表不是空链表,节点不是最后一个节点
            temp = next.getNext();//记录一下当前节点下一个节点的下一个（不记录一下,等next指向回cur，后面的node就断联了）
            next.setNext(cur);//把next指向cur;
            cur = next;
            next = temp;
        }
        node.setNext(null);//把原来头结点的next置为空,不然他和原来的第二个节点就双向指向,打印的时候就没null终止,死循环了。
        return cur;
    }


    public static void main(String[] args){

        Node node = new Node(1);
        Node node2 = new Node(2,node);
        Node node3 = new Node(3,node2);
        Node node4 = new Node(4,node3);

        Node head = node4;
        System.out.println("before reverse");
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
        System.out.println();
        System.out.println("after reverse");
        ReverseLinklist rlist = new ReverseLinklist();

        Node newHead = rlist.reverseNormal(node4);
        while (null != newHead) {
            System.out.print(newHead.getData() + " ");
            newHead = newHead.getNext();
        }





    }
}
