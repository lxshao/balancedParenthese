import java.util.Stack;

public class CheckBalancedParenthese {
	public static boolean isParenthesBalacne(String str) {
		if (null == str) {
			return false;
		}
		
		Stack<Character> st = new Stack<>();
		
		for ( int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			// find a matched ')' to pop out string '('
			 if (!st.isEmpty() && ch == ')' && st.peek() == '(') {
				 st.pop();
			 } else if (ch != '(') {
				 // don't push anything to stack except '{'
				 continue;
			 }
			 else {
				 // find anything char and '(' in string, push it to stack 
				 st.push(ch);
			 }
		}
		
		if (st.isEmpty()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isParenthesBalacne("a*(b+c)-d*(e-f)")); //this should be true
		System.out.println(isParenthesBalacne("a*(b+c)-d*(e-f")); //this should be false
		System.out.println(isParenthesBalacne("a*((b+c))-d*(e-f)")); //nested, this should be true;
	}
}
