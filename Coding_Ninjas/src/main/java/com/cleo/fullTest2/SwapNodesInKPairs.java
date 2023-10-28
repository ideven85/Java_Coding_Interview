package com.cleo.fullTest2;


public class SwapNodesInKPairs {

    private static int length(Node head){
        int size=0;
        while(head!=null){
            head=head.next;
            size++;
        }
        return size;
    }



    public static Node reverseList(Node head, Node newHead){
        if (head==null) return newHead;
        Node temp = head.next;
        head.next = newHead;
        newHead = head;
        return reverseList(temp,newHead);
    }

    public static Node reverse(Node head, int k) {
        if (head==null) return null;
        Node temp = head;
        for (int i =0;i<k-1;i++){
            if (temp == null){
                return reverseList(head,null);
            }
            temp = temp.next;
        }
        if (temp == null){
            return reverseList(head,null);
        }
        Node node = null;
        node = reverse(temp.next,k);
        temp.next = null;
        reverseList(head,null);
        head.next = node;
        return temp;
    }

    private static Node reverseK(Node head,int k){
        Node last=null,current=head;
        int pointer=0;
        while(pointer!=k){
            Node nextNode=current.next;
            current.next=last;
            last=current;
            current=nextNode;
            pointer++;
        }
        head=last;
        return head;
    }
}
