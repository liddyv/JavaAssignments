

interface StackCalculatorInterface {

	// Pushes x onto the stack
	void push(double x);
	
	// Pops the top value from the stack
	double pop();
	
	/* Pops two values off the stack, adds them, and pushes the
		result back onto the stack. */
	double add();
	
	/* Pops two values off the stack, subtracts them, and
		pushes the result back onto the stack. */
	double subtract();
	
	/* Pops two values off the stack, multiplies them, and
		pushes the result back onto the stack. */
	double multiply();
	
	/* Pops two values off the stack, divides the first value into
		the second one, and pushes the result back onto the stack.
	 */
	double divide();
	
	/* Removes all entries from the stack.*/
	void clear();
	
	
	/* Returns all of the values from the stack in array, without
	removing them from the stack. */
	double[] getValues();
	
	/* Gets the number of values in the stack */
	int size();
}
