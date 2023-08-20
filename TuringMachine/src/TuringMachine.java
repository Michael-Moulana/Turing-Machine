import java.util.Scanner;

// a Turing Machine that accepts L={0^(2^n); n>=0}
public class TuringMachine {
	public char[] strip;
	private int numberOfZeros;
	private int headState;
	
	// Constructor
	public TuringMachine(int n) throws Exception {
		setNumberOfZeros(n);
		setStrip(numberOfZeros);
		System.out.println("\nThe Strip Now:\n");
		showStrip();
		setHeadState(0);
	}
	
	// getter for strip
	public char[] getStrip() {
		return strip;
	}
	
	// setter for strip
	public void setStrip(int numberOfZeros) {
		strip = new char[numberOfZeros+1];
		int i = 0;
		while (i < strip.length) {
			strip[i] = '0';
			i++;
		}
		strip[--i] = 'B';

	}
	
	// getter for numberOfZeros
	public int getNumberOfZeros() {
		return numberOfZeros;
	}
	
	// setter for numberOfZeros
	public void setNumberOfZeros(int n) throws Exception {
		// the number of zeros must be at least 1
		if (n > 0) {
			numberOfZeros = n;
		}else {
			throw new Exception("\nError: The Number Of Zeros Must Be At Least One !");
		}
	}

	// getter for headState
	public int getHeadState() {
		return headState;
	}
		
	// setter for headState
	public void setHeadState(int n) {
		headState = n;
	}
	
	// goes through strip and does the main process
	public void process() {
		 // first element replaced by 'B', then go to the next.
		strip[headState] = 'B';
		showStrip();
		goRight();
		
		// count how many zeros are skipped
		int countZeros = 0;
		
		// shows if headState reached to zero or not
		boolean isReachedToZero = false;
		
		// the main loop
		outterloop:
		while (true) {		
			
			// this loop is for seeking the first zero that headState reached
			innerloop1:
			while (headState < strip.length -1) {
				if (strip[headState] == '0') {
					isReachedToZero = true;
					strip[headState] = 'X';
					showStrip();
					goRight();
					break innerloop1;
				}
				
				goRight();
				
				// if there is not any '0' left
				isReachedToZero = false;
			}
			
			// if there is not any zero remained, it finishes the process
			if (isReachedToZero == false) {
				System.out.println("*** ACCEPTED ! Your Input Implements The Machine. ***\n");
				break outterloop;
			}
			
			// this loop is for replacing every other '0' with 'X' 
			// also it checks if the overall string (E.g. "0000") is acceptable or not
			innerloop2:
			while (headState < strip.length) {
				
				// if the head of machine reached '0', adds 1 to countZero 
				if (strip[headState] == '0') {
					countZeros += 1;
				}
				
				// if countZero reached 2, replaces '0' with 'X'
				if (countZeros == 2) {
					strip[headState] = 'X';
					showStrip();
					countZeros = 0;
				}
				
				goRight();
				
				// when the head reached blank
				if (strip[headState] == 'B') {
					
					// if there is still one '0' left, the number of '0's is odd
					// and it will be rejected
					if (countZeros == 1) {
						System.out.println("*** REJECTED ! Your Input Does Not Implement The Machine. ***\n");
						break outterloop;
					}
					
					// move the head back to the first index of arrOfChar
					while (headState != 0) {
						goleft();
					}
					
					// headState is 0 now,
					// to avoid repetition in "innerloop2", break the loop 
					// and get back to "outterloop" again
					break innerloop2;
				}
			}		
		}
	}
	
	// moves the head of machine to the next index
	public void goRight() {
		if (headState != strip.length-1) {
			headState++;
		}
	}
	
	// moves the head of machine to the previous index
	public void goleft() {
		if (headState != 0) {
			headState--;
		}
	}
	
	// shows current strip
	public void showStrip() {
		for (int i = 0; i < getStrip().length-1; i++) {
			System.out.print("| " + getStrip()[i] + " ");
		}
		System.out.println("|\n");
	}
}
