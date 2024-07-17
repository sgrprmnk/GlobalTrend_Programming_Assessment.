package global.trend;
/////////////////// Question 6 ////////////////////
import java.util.Stack;

public class isValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack =new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }
            else if(!stack.isEmpty() && ch==')' && stack.peek()=='('){
                stack.pop();
            }else if(!stack.isEmpty() && ch=='}' && stack.peek()=='{'){
                stack.pop();
            }else if(!stack.isEmpty() && ch==']' && stack.peek()=='['){
                stack.pop();
            } else{
                return false;
            }
        }
        return stack.isEmpty();
    }

}
