
public class InfixExpression {

	private String infix;
	private LinkedStack stack;

	/*
	 * This should construct a new InfixExpression object, but will store it as
	 * a cleaned up expression. It should make use of the private clean() method
	 * to do the cleaning. The constructor should throw an
	 * IllegalArgumentException if the String parameter is not valid, calling on
	 * the isValid() method for help
	 */
	public InfixExpression(String calc) {
		infix = calc;
		clean();
		stack = new LinkedStack();
	}

	public String toString() {
		return infix;
	}

	/*
	 * This private method should return true if the infix expression has
	 * balanced parentheses, and false otherwise. It does not check for any
	 * other kinds of invalid expressions. So, for example, isBalanced() should
	 * return true for the invalid infix expression "( 3 ( ( * * 4 ) 8 ) 7 7 )
	 * 6" because the parentheses are balanced, even though other things are a
	 * mess. Use the algorithm described in chapter 5 for checking balanced
	 * parentheses. This algorithm should use an instance of your LinkedStack
	 * class.
	 */
	public boolean isBalanced() {
		int stack = 0;
		int stack1 = 0;
		int stack2 = 0;
		for (int i = 0; i < infix.length(); ++i) {
			char c = infix.charAt(i);
			if (c == '(')
				stack++;
			if (c == '[')
				stack1++;
			if (c == '{')
				stack2++;
			 if (c == ')') 
				stack--;
			 if (c == ']') 
					stack1--;
			 if (c == '}') 
					stack2--;
			
			if (stack < 0) {
					return false;
			}
			if (stack1 < 0) {
				return false;
			}
				if (stack2 < 0) {
					return false;
			}
		}
			
	
		return stack == 0 && stack1==0 && stack2 ==0;
	}

	/*
	 * This private method should return true if the infix expression is valid
	 * in all respects, and false otherwise. For example, isValid() should
	 * return false for the infix expression "( 3 ( ( * * 4 ) 8 ) 7 7 ) 6", even
	 * though the parentheses are balanced. isValid() should check all of the
	 * following:
	 */
	private boolean isValid() 
	{
		/*char c;
		char top;
		for (int i = 0; i < infix.length(); i++) {
			c = infix.charAt(i);
			if(isOperand(c))
			{
				if(isOperand(infix.charAt(i+1)))
					return false;
				if(infix.charAt(i+1).equals('('||'['||'{'))
					return false;
			}
			else if(operator(infix.charAt(i+1)))
					return false;
			else if*/
		return true;
	}

	/*
	 * cleans the expression, cleaning up the provided string by putting a
	 * single space between adjacent tokens, and no leading or trailing spaces.
	 * So, for example, if the parameter is " 3+4* 83 / 6 ", it should be stored
	 * as "3 + 4 * 83 / 6". The only reason this method exists is to help the
	 * constructor. That's why it is private. One fairly simple approach to this
	 * could be to use the replace() method of the String class to insert spaces
	 * where needed, and to convert multiple spaces into single spaces.
	 */
	private void clean() {
		String words = infix;
		String clean = words.replaceAll("\\s", ""); // found the replace all
													// online
		infix = clean;
	}

	/*
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String getPostfixExpression() {

		if (isBalanced() == false)
			return "isn't a balanced expression";
		// if(isValid()==false)
		// return "isnt a valid expression";
		String postfix = "";
		char c;
		char top;
		for (int i = 0; i < infix.length(); i++) {
			c = infix.charAt(i);
			if (isOperand(c)) {
				postfix = postfix + c;
			}
			if (getThePrecedence(c) == 3) {
				stack.push(c);
			}
			if (c == '*' || c == '/' || c == '+' || c == '-') {
				while (!stack.isEmpty() && getThePrecedence(c) <= getThePrecedence((char) stack.peek())) {
					postfix = postfix + stack.pop();
				}
				stack.push(c);
			}
			if (c == '(') {
				stack.push(c);
			}
			if (c == ')') {
				top = (char) stack.pop();
				while (top != '(') {
					postfix = postfix + top;
					top = (char) stack.pop();
				}
			}
		}

		while (!stack.isEmpty()) {
			postfix = postfix + stack.pop();
		}

		return postfix;

	}

	public int getThePrecedence(char c) {
		if (c == '^')
			return 3;
		if (c == '*' || c == '/' || c == '%')
			return 2;
		if (c == '-' || c == '+')
			return 1;
		return 0;
	}

	boolean operator(char ch) {
		if (ch == '/' || ch == '*' || ch == '+' || ch == '-') {
			return true;
		} else
			return false;
	}

	boolean isOperand(char ch) {
		if (ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9')
			return true;
		else
			return false;
	}

	public int evaluatePostfix() {
		LinkedStack<Integer> valueStack = new LinkedStack<Integer>();
		char c;
		int operand2;
		int operand1;
		int result;
		String input = getPostfixExpression();
		
		for (int i = 0; i < input.length(); i++) {
			c = input.charAt(i);
			if (isOperand(c)) {
				
				valueStack.push( c-'0');
			} else {
				operand2 = valueStack.pop();
				operand1 = valueStack.pop();
				if (c == '-') {
					result = operand1 - operand2;
					valueStack.push(result);
					
					
				}
				if (c == '+') {
					result = operand1 + operand2;
					valueStack.push(result);
					
					
				}
				if (c == '/') {
					result = operand1 / operand2;
					valueStack.push(result);
					
					
				}
				if (c == '*') {
					result = operand1 * operand2;
					valueStack.push(result);
					
					
				}
				if (c == '^') {
					result = (int) Math.pow(operand1, operand2);
					valueStack.push(result);
					
					
				}

			}

		}
		return valueStack.pop();
	}

	public int evaluate() {
		stack.clear();
		int ret = 0;
		return ret;

	}

}
