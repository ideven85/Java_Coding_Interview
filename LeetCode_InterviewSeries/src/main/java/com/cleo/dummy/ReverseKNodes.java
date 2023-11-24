package com.cleo.dummy;

public class ReverseKNodes {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  private int length(ListNode head){
        int size=0;
        while(head!=null){
            size++;
            head=head.next;
        }
        return size;
  }

  private ListNode reverse(ListNode head, int start, int end){
        ListNode temp=null,current=head;
       // int counter=start;
        while(start<end){
            ListNode next=current.next;
            current.next=temp;
            temp=current;
            current=next;
            start++;

        }
        return temp;
  }
  private ListNode reverse(ListNode head){
        ListNode prev=null,current=head;
        while(current!=null){
            ListNode next=current.next;

            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
  }

  /*  public ListNode reverseKGroup(ListNode head, int k) {
        int length=length(head);//1-2-3-4-5//2-1
        int start=0;
        ListNode current=head;
        while(start<length-k){
            int end=start+k;
            if(end<length-k&&current!=null){
                while(start<end&&current!=null){
                    System.out.println(current.val);
                    current=current.next;
                    start++;

                }
//How do I handle the reversed list?
                ListNode current_end=reverse(current,start,end);
               *//* System.out.println(current.val);
                System.out.println(current.next.val);
*//*
               *//* if(current_end!=null) {
                   current=current_end;
                }*//*





            }
            start=end;


        }
        return head;
    }
*/
    int index=0;
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        if(count <k) return head;
        else {
            ListNode current = head, prev = null, next = null;
            count = k;
            while (current != null && count > 0) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count--;
            }


            if (next != null)
                head.next = reverseKGroup(next, k);


            return prev;
        }

    }
        public ListNode swapPairs(ListNode head){
        if(head!=null&&head.next!=null) {
            ListNode temp;


            temp=head.next;
            head.next=temp.next;
            temp.next=head;
            head=temp;
            head.next.next=swapPairs(head.next.next);
        }
        return head;

    }
    public void printList(ListNode head){
        while(head!=null) {
            System.out.print(head.val + " ");
            head=head.next;
        }
    }

    public void reverseRecursive(ListNode current,ListNode[] head){
        if(current==null)
            return;
        ListNode next=current.next;
        if(next==null){
            head[0]=current;
            return;
        }
        reverseRecursive(next,head);
        next.next=current;
        current.next=null;
    }
    public ListNode reverseRecursive(ListNode head){
        ListNode[] next=new ListNode[1];
        reverseRecursive(head,next);
        return next[0];
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1),current=head;
        current.next=new ListNode(2);current=current.next;
        current.next=new ListNode(3);current=current.next;
        current.next=new ListNode(4);current=current.next;
        current.next=new ListNode(5);current=current.next;
        current.next=new ListNode(6);current=current.next;
        ReverseKNodes list= new ReverseKNodes();
        list.printList(head);
        System.out.println();
        head=list.reverse(head);
        list.printList(head);
        System.out.println();
        //head=list.reverseKGroup(head,2);
        //list.printList(head);
        System.out.println();
        head=list.reverseRecursive(head);
        list.printList(head);
        System.out.println();
        head=list.swapPairs(head);
        list.printList(head);
        System.out.println();
        head=list.reverseKGroup(head,4);
        list.printList(head);
        System.out.println();

    }
}
