package UppgiftA3;// LinkedNumberSequence.java

/****************************************************************

LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses linked nodes to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class LinkedNumberSequence implements NumberSequence
{
	private class Node
	{
		public double number;
		public Node next;

		public Node (double number)
		{
			this.number = number;
			next = null;
		}
	}

	// the first node in the node-sequence
    private Node first;

    // create the sequence
    public LinkedNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

        first = new Node(numbers[0]);
        Node n = first;
		for (int i = 1; i < numbers.length; i++)
		{
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		Node n = first;
		while (n.next != null)
		{
		    s = s + n.number + ", ";
		    n = n.next;
		}
		s = s + n.number;

		return s;
	}

    // add code here

	// lenght returns the amount of elements in this sequence
	@Override
	public int length() {
		int lenght = 1;
		Node n = first;
		while (n.next != null)
		{
			n = n.next;
			lenght++;
		}

		return lenght;
	}

	@Override
	public double upperBound() {
		Node n = first;
		while (n.next != null)
		{
			n = n.next;
		}

    	return n.number;
	}

	@Override
	public double lowerBound() {
		Node n = first;
    	return n.number;
	}

	// numberAt returns the number at the index position of this sequence
	@Override
	public double numberAt(int position) throws IndexOutOfBoundsException {
		int index = 0;
		Node n = first;
		while (n.next != null)
		{
			if (index == position)
				return n.number;

			n = n.next;
			index++;
		}

		return index;
	}

	// positionOf returns the index of the number int this sequence
	@Override
	public int positionOf(double number) {
		int index = 0;
		Node n = first;
		while (n.next != null)
		{
			if (n.number == number)
				return index;

			n = n.next;
			index++;
		}

		return index;
	}

	@Override
	public boolean isIncreasing() {
		for (int i = 0; i < this.asArray().length - 1; i++) {
			if (!(this.asArray()[i] < this.asArray()[i + 1])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isDecreasing() {
		for (int i = 0; i < this.asArray().length - 1; i++) {
			if (!(this.asArray()[i] < this.asArray()[i + 1])) {
				return true;
			}
		}
		return false;
	}

	// contains returns true if the number exist in this sequence
	@Override
	public boolean contains(double number) {
		Node n = first;

		if (n.number == number)		// För
			return true;

		while (n.next != null)
		{
			n = n.next;

			if (n.number == number)
				return true;
		}

		return false;
	}

	// add inserts the given number last in the linkedList
	@Override
	public void add(double number) {
		Node next = new Node(number);
		Node n = first;
		while (n.next != null)
		{
			n = n.next;
		}
		n.next = next;
	}

	// insert method inserts the given number at a specified index
	@Override
	public void insert(int position, double number) {
		Node newnode = new Node(number);
		int index = 0;
		Node n = first;
		while (n.next != null){
			index++;
			if (index == position){
				newnode.next = n.next;
				n.next = newnode;
			}
			else {
				n = n.next;
			}
		}
	}

	// removeAt removes the number at the given position
	@Override
	public void removeAt(int position) throws IndexOutOfBoundsException {
		int index = 0;
		Node n = first;
		while (n.next != null)
		{
			index++;

			if (index == position)
				n.next = n.next.next;
			else
				n = n.next;
		}
	}

	@Override
	public double[] asArray() {
    	double[] array = new double[this.length()];
		Node n = first;
		for (int i = 0; i < this.length(); i++){
			array[i] = n.number;
			n = n.next;
		}

		return array;
	}
}