

import java.util.EmptyStackException;
import java.util.LinkedList;

/*  
 * @HomeWork #5-4: StackCalculator.java
 * @Author: WanLing Hsieh
 * @Description: This class maintain the stack data using LinkedList 
 */
class StackCalculator implements StackCalculatorInterface {

	private LinkedList<Double> list;
	double value1, value2;
	
	// constructor
	StackCalculator() {
		list = new LinkedList<Double>();
	}
	
	StackCalculator(LinkedList<Double> list) {
		this.list = list; 
	}
	
	@Override
	public void push(double x) {
		//list.addFirst(x);
		list.add(x);
	}

	@Override
	public double pop() {
		/*
		if (isEmpty()) 
			throw new EmptyStackException();
		*/
		//return list.removeFirst();
		return list.removeLast();
	}

	@Override
	public double add() {
		value1 = pop();
		value2 = pop();
		return value1 + value2;
	}

	@Override
	public double subtract() {
		value1 = pop();
		value2 = pop();
		return value1 - value2;
	}

	@Override
	public double multiply() {
		value1 = pop();
		value2 = pop();
		return (value1 * value2);
	}

	@Override
	public double divide() {
		value1 = pop();
		value2 = pop();
		return (value1 / value2);
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public double[] getValues() {	
		// Double[] array = list.toArray(new Double[list.size()]);
		double[] array = new double[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i); // Watch out for NullPointerExceptions!
		}
		return array;	
	}

	@Override
	public int size() {
		return list.size();
	}
	
	boolean isEmpty() {
		return list.size()==0;
	}
	
	public double peek() {
		if(isEmpty())
			throw new EmptyStackException();
		return list.getFirst();
	}
}
