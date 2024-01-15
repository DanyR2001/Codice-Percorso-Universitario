package esericizio_base;

import java.util.ArrayList;

public class MyStack<T> {
	private ArrayList<T> stack;
	
	public MyStack() {
		stack=new ArrayList();
	}
	
	public void push(T element) {
		stack.add(element);
	}
	
	public T pop() {
		return (T)stack.remove(stack.size()-1);
	}
	
	public int getCount() {
		return stack.size();
	}
	
}
