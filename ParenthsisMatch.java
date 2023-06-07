import java.util.HashMap;
import java.util.Map;

public class ParenthsisMatch {
    public boolean isValid(String s) {
        int i = s.length()-1;
        int upperbd = s.length()-1;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        while(i >= 0){
            if(i-1 < 0) return false;
            char currentCh = s.charAt(i);
            char beforeCh = s.charAt(i-1);
            if(beforeCh == map.get(currentCh)){
                upperbd -=2;
                if(i+1 < upperbd) i = i+1;
                else i = i-2;
            }else return false;
        }
        return true;
    }
    public static void main(String[] args){
        ParenthsisMatch p = new ParenthsisMatch();
//        String str = "(){}[]"; )}
//        String str = "(){}}}";
        String str = "()[{}]";
        System.out.println(p.isValid(str));
    }
}
