package utils;

import java.util.HashSet;

public class SinglyLinkedList<T> {
    ListNode<T> head;

    public SinglyLinkedList(){}

    public void add(ListNode<T> node){
        if(this.head == null) this.head = node;
        else{
            ListNode<T> tmp = this.head;
            while(tmp.hasNext()){
                tmp = tmp.next;
            }
            tmp.setNext(node);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(this.head != null){
            ListNode<T> tmp = this.head;
            sb.append(tmp.val);
            while(tmp.hasNext()){
                tmp = tmp.next;
                sb.append(", ").append(tmp.val);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public ListNode<T> getHead() {
        return head;
    }

    public ListNode<T> removeDuplicates(ListNode<T> head){
        ListNode<T> dummy = new ListNode<>();
        ListNode<T> tmp = head;

        dummy.setNext(tmp);
        HashSet<T> set = new HashSet<>();
        set.add(tmp.val);
        while(tmp.hasNext()){
            if(set.contains(tmp.next.val)){
                ListNode<T> tmpnext = tmp.next;
                tmp.next = tmpnext.next;
                tmpnext.next = null;
            }else{
                set.add(tmp.next.val);
                tmp = tmp.next;
            }

        }
        return dummy.next;
    }

    public ListNode<T> pairwiseSwap(ListNode<T> head){
        ListNode<T> dummy = new ListNode<>();
        dummy.setNext(swapNodes(head));
        return dummy.getNext();
    }

    public ListNode<T> swapNodes(ListNode<T> first){
        if(first == null) return null;
        if(first.getNext() != null) {
            //swap
            ListNode<T> second = first.getNext();
            ListNode<T> tmp = second.getNext();
            second.setNext(first);
            first.setNext(swapNodes(tmp));
            return second;
        }else return first;
    }
}
