package UppgiftA3;// ArrayNumberSequence.java

/****************************************************************

ArrayNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses an array to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class ArrayNumberSequence implements NumberSequence
{
	// numbers in the sequence
    private double[] numbers;

    // create the sequence
    public ArrayNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

		this.numbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
		    this.numbers[i] = numbers[i];
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		for (int i = 0; i < numbers.length - 1; i++)
		    s = s + numbers[i] + ", ";
		s = s + numbers[numbers.length - 1];

		return s;
	}

	@Override
	public int length() {
		return numbers.length;
	}

	@Override
	public double upperBound() {
		return numbers[numbers.length-1];
	}

	@Override
	public double lowerBound() {
		return numbers[0];
	}

	@Override
	public double numberAt(int position) throws IndexOutOfBoundsException {
		return numbers[position];
	}

	@Override
	public int positionOf(double number) {

		int index = -1;

		for (int i = 0; i < numbers.length; i++){
			if (numbers[i] == number){
				index = i;
				break;	// För att inte forsätta gämföra när man hittat platsen
			}
		}
		return index;
	}

	@Override
	public boolean isIncreasing() {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (!(numbers[i] < numbers[i + 1])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isDecreasing() {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (!(numbers[i] < numbers[i + 1])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean contains(double number) {
		for (int i = 0; i < numbers.length; i++){
			if (numbers[i] == number){
				return true;
			}
		}
		return false;
	}

	@Override
	public void add(double number) {
		double[] copy = new double[numbers.length + 1];

		System.arraycopy(numbers, 0, copy, 0, numbers.length);

		numbers = copy;

		numbers[numbers.length-1] = number;
	}

	@Override
	public void insert(int position, double number) {
		double[] copy = new double[numbers.length + 1];

		copy[position] = number;

		for (int i = 0; i < numbers.length + 1; i++) {
			if (i < position)
				copy[i] =  numbers[i];
			else if (i == position)		// insert number när i når position
				copy[i] = number;
			else
				copy[i] = numbers[i - 1];
		}

		numbers = copy;
	}

	@Override
	public void removeAt(int position) throws IndexOutOfBoundsException {
		double[] copy = new double[numbers.length - 1];

		for (int i = 0; i < numbers.length - 1; i++) {
			if (i < position)
				copy[i] =  numbers[i];
			else
				copy[i] = numbers[i + 1];
		}

		numbers = copy;
	}

	@Override
	public double[] asArray() {
		return numbers;
	}
	// add code here
}