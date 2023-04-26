package com.gl.lab3;
import java.util.*;

public class BalancedAndUnbalanced {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String expr = sc.nextLine();
        System.out.println("");
//        boolean b;
        if (isBalanced(expr)) {
            System.out.println("The entered String has Balanced Brackets");
        } 
        else {
            System.out.println("The entered String does not contain Balanced Brackets");
        }
    }

	 public static boolean isBalanced(String expr) {
	        Stack<Character> stack = new Stack<Character>();
	        for (int i = 0; i < expr.length(); i++) {
	            char ch = expr.charAt(i);
	            if (ch == '(' || ch == '{' || ch == '[') {
	                stack.push(ch);
	            } 
	            else if (ch == ')' || ch == '}' || ch == ']') {
	                if (stack.isEmpty()) {
	                    return false;
	                }
             else if (ch == ')' && stack.peek() == '(') {
	                    stack.pop();
	                } 
             else if (ch == '}' && stack.peek() == '{') {
	                    stack.pop();
	                } 
             else if (ch == ']' && stack.peek() == '[') {
	                    stack.pop();
	                } 
             else {
	                    return false;
	                }
	            }
	        }
			return stack.empty();
	 }
}
