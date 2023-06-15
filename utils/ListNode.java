package utils;

public class ListNode<E> {
    ListNode<E> next;
    E val;

    public ListNode(){
    }
    public ListNode(E obj){
        val = obj;
        next = null;
    }

    public ListNode(E obj, ListNode<E> next){
        val = obj;
        this.next = next;
    }


    public void removeNext(){
        if(this.next.next != null){
            this.next = this.next.next;
            this.next.next = null;
        }else this.next = null;

    }

    public E getVal(){
        return this.val;
    }


    public ListNode<E> getNext() {
        return next;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }

    public boolean hasNext(){return this.next != null;}

    @Override
    public String toString() {
//        return "0";
        if (! this.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        ListNode<E> pivot = this;
        while(pivot != null) {
           sb.append(pivot.val.toString());
           pivot = pivot.next;
           if(pivot != null) sb.append(", ");
           else sb.append("]");
        }

        return sb.toString();
    }
}
