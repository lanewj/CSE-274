import java.util.ArrayList;

/**
 * Your implementation of the LookupInterface. The only public methods in this
 * class should be the ones that implement the interface. You should write as
 * many other private methods as needed. Of course, you should also have a
 * public constructor.
 * 
 * @author // TODO: Add your name here
 */

public class StudentLookup implements LookupInterface {

	private ArrayList<Node> data;
	private int count;

	public StudentLookup() {
		data = new ArrayList<Node>();
		count = 0;

	}

	@Override
	/*
	 * This method is called when you see a string s, causing the count of the
	 * number of occurrences to increase by amount. So, for example, calling
	 * addString(15, "the") would increase the number of occurrences of "the" by
	 * 15.
	 */
	public void addString(int amount, String s) {
		int num = this.contains(s);
		if (num < 0) {
			data.add(new Node(s, amount));
			count++;
		} else {
			data.get(num).total = data.get(num).total + amount;
		}

	}

	@Override
	/* This method will return the number of times string s has been seen */
	public int lookupCount(String s) {
		int num = this.contains(s);
		if (num < 0) {
			return 0;
		} else {
			return data.get(num).total;
		}
	}

	@Override
	/*
	 * This method returns the string that that is the nth most popular string
	 * seen. That is, if n=0 it should return the most popular string (the
	 * string with the highest count), if n=1 it should return the 2nd most
	 * popular string, etc... (Clearly, what string is the most popular might
	 * change over time as addString is called more times.) Ties should be
	 * broken alphabetically. (So if "Marvin" and "Eddie" have each been seen
	 * the most, lookupPopularity(0) should return "Eddie".)
	 */
	public String lookupPopularity(int n) {
		ArrayList<Node> test = this.copyData();
		int nums = 0;
		int max = 0;
		
		while (true) {
			max = 0;
			//System.out.println(this.toString() + " n =  " + n + " nums = " + nums + " max " + max);
			if (nums == n) {
				//System.out.println("entered if");
				if (test.size() == 1) {
					// System.out.println("return first");
					return test.get(0).word;
				}

				for (int i = 1; i < test.size(); i++) {
					if(test.get(i).total==test.get(max).total)
					{
						if(test.get(i).word.compareTo(test.get(max).word)<0)
						{
							max=i;
						}
					}
					if (test.get(i).total > test.get(max).total) {
						max = i;
					}

				}
				//System.out.println("return");
				return test.get(max).word;
			} else {
				for (int i = 1; i < test.size(); i++) {
					if(test.get(i).total==test.get(max).total)
					{
						if(test.get(i).word.compareTo(test.get(max).word)<0)
						{
							max=i;
						}
					}
					if (test.get(i).total > test.get(max).total) {
						max = i;
					}

				}
				//System.out.println("removing " + test.get(max).word);
				test.remove(max);
				nums++;

			}
		}

	}

	public int contains(String s) {
		if (count == 0) {
			return -1;
		}
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).word.equals(s))
				return i;
		}
		return -1;
	}
	public ArrayList<Node> copyData()
	{
		ArrayList<Node> ret = new ArrayList<Node>();
		
		for(int i =0; i<data.size();i++)
		{
			ret.add(new Node(data.get(i).word,data.get(i).total));
		}
		return ret;
	}

	@Override
	/*
	 * The number of unique entries in the table. That is, the number of
	 * different strings we have seen. (So if "Perfect" has been entered twice
	 * and "Dent" has been entered four times, and nothing else has been
	 * entered, numEntries() should return 2.)
	 */
	public int numEntries() {
		return count;
	}

	public String toString() {
		String ret = "";

		for (int i = 0; i < data.size(); i++) {
			ret = ret + " Word: " + data.get(i).word + " count: " + data.get(i).total;
		}
		return ret;
	}

	private class Node {
		String word;
		int total;

		private Node(String w, int i) {
			word = w;
			total = i;
		}

		private int getTotal() {
			return total;
		}

		private String getWord() {
			return word;
		}

		private void setCount(int i) {
			total = total + i;
		}
	}

}
