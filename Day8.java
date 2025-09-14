import java.util.Stack;

public class Day8 {


    // Question 1: Push at bottom of stack
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }

    // Question 2: Reverse a string using stack
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder result = new StringBuilder("");

        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();
    }

    //Ques: 3: Reverse a stack using recursion
    // Approach: Pop the top element, reverse the remaining stack and then push the popped element at the bottom of the reversed stack.
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()) return;
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    //print stack
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        // pushAtBottom(s,4);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        // String str = "abcd";
        // System.out.println( "Original string is: "+ str);
        // System.out.println("Reversed string is: " + reverseString(str));
        reverseStack(s);
        System.out.println("Reversed Stack is: ");
        printStack(s);
    }
}
