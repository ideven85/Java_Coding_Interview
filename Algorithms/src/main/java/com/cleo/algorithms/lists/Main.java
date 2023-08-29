package com.cleo.algorithms.lists;

public class Main {

    public static ListNode reverse(ListNode root){
        if(root==null)
            return null;
       root=reverse(root.next);
       return root;

    }
    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val+ " ");
            head=head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current=head;

        current.next=new ListNode(2);
        current=current.next;
        current.next = new ListNode(3);
        current=current.next;

        current.next = new ListNode(10);
        current=current.next;
        current.next= new ListNode(4);

        current=current.next;
        printList(head);
        System.out.println();
        head=reverse(head);
        printList(head);
        System.out.println();
        PalindromeLinkedList p = new PalindromeLinkedList();
        printList(head);
        System.out.println("Is palindrome?");
        DeleteValue deleteValue = new DeleteValue();
       // head=deleteValue.removeElements(head,1);
       // printList(head);
        System.out.println();
       // head = deleteValue.removeElements(head,2);
        //printList(head);
        SortList sortedList = new SortList();
        printList(head);
        System.out.println();
        ListNode lst = sortedList.sortList(head);
        printList(lst);

      //  System.out.println(p.isPalindrome(head));
    }
}
