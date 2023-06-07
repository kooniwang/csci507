import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args){
        String reversedGroupName = "";
        Stack<Character> stack = new Stack<>();
        System.out.println("Please input your group name: ");
        String groupName = new Scanner(System.in).nextLine();
        int i = 0;
        while(i < 4){
            stack.push(groupName.charAt(i++));
        }
        while(!stack.isEmpty()){
            reversedGroupName = reversedGroupName.concat(String.valueOf(stack.pop()));
        }

        System.out.println("The reversed group name is: " + reversedGroupName);
    }
}
