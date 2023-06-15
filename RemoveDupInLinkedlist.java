import utils.ListNode;
import utils.SinglyLinkedList;

import java.util.*;

public class RemoveDupInLinkedlist {


    public static void main(String[] args){
        System.out.println("Please input several numbers and use comma as a separator: ");
        Scanner scanner = new Scanner(System.in);
        //remove all the spaces between numbers.
        String inputStr = scanner.nextLine().replaceAll("\\s","");
        //The input must be number and the separator for different numbers must be comma.
        if(!inputStr.matches("^\\d+(,\\d+)*$")){
            throw new IllegalStateException("Wrong input! Only numbers and comma as a separator accepted. Please try again.");
        }


        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        for(String str : inputStr.split(",")){
            linkedList.add(new ListNode<>(Integer.valueOf(str)));
        }
        System.out.println(linkedList.removeDuplicates(linkedList.getHead()));

    }
}
