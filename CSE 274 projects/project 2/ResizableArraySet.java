import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class ResizableArraySet implements SetInterface {
	private int[] a;
	private int[] copy;
	private int count = 0;
	private static final int DEFAULT_CAPACITY = 10;

	public ResizableArraySet() {
		this(DEFAULT_CAPACITY);
	}

	public ResizableArraySet(int desiredCapacity) {

		a = new int[desiredCapacity];

		count = 0;
	} 
	public int getSize() {
		return count;
	}

	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean add(int n) {
		if (count + 1 == a.length) {
			a = Arrays.copyOf(a, a.length * 2);
			a[count] = n;
			count++;

		} else 
		{
			a[count] = n;
			count++;
		}

		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean remove(int anEntry) 
	{
		boolean ret = false;
		int val=0;
		
		copy = a;
		a = new int[a.length-1];
		int count2=count;
			for(int i=0;i<count2;i++)
			{
				if(copy[i]!=anEntry)
				{
					
					a[val]=copy[i];
					val++;
				}
				else
				{
					
					ret=true;
					count--;
				}
			}
		
		
		
		
		
		return ret;
	}

	@Override
	public int remove() 
	{
		int ret;
		if(count-1<a.length/2)
		{
			a = Arrays.copyOf(a, a.length/2);
			ret=a[count-1]; 
			copy = a;
			a = new int[a.length-1];
				for(int i=0;i<count-1;i++)
				{
					
					a[i]=copy[i];
				}
			count--;

		}
		else
		{
		ret=a[count-1]; 
		copy = a;
		a = new int[a.length-1];
			for(int i=0;i<count-1;i++)
			{
				
				a[i]=copy[i];
			}
		count--;
		}
		return ret;
	}

	
	public void clear() {
		a = new int[DEFAULT_CAPACITY];
		count=0;

	}

	@Override
	public boolean contains(int anEntry) {
		for (int i = 0; i < count; i++) {
			if (a[i]==anEntry)
				return true;
		}
		return false;
	}

	@Override
	public SetInterface union(SetInterface anotherSet) {
		
		
		SetInterface ret = anotherSet;
		
		for(int i=0; i<count; i++)
		{
			if(!ret.contains(a[i]))
			{
				ret.add(a[i]);
			}
		}
		return ret;

	}

	@Override
	public SetInterface intersection(SetInterface anotherSet) 
	{
		SetInterface copy = anotherSet;
	
		
		ResizableArraySet ret = new ResizableArraySet();
		
		for(int i=0; i<count; i++)
		{
			if(copy.contains(a[i]))
			{
				
				ret.add(a[i]);
			}
		}
			return ret;
	}

	@Override
	public SetInterface difference(SetInterface anotherSet)
	{
		
		SetInterface copy = anotherSet;
		SetInterface copy2 = ((ResizableArraySet) anotherSet).differenceTwo(this);
		int[] ret2 = copy2.toArray();
		
		ResizableArraySet ret = new ResizableArraySet();
		
		for(int i=0; i<count; i++)
		{
			if(!copy.contains(a[i]))
			{
				
				ret.add(a[i]);
			}
		}
		System.out.println(ret2.length);
		for(int w = 0; w<ret2.length;w++)
		{
			ret.add(ret2[w]);
		}
		
			return ret;
	}
	public SetInterface differenceTwo(ResizableArraySet anotherSet)
	{
		SetInterface copy = anotherSet;
		ResizableArraySet ret = new ResizableArraySet();
		
		for(int i=0; i<count; i++)
		{
			if(!copy.contains(a[i]))
			{
				
				ret.add(a[i]);
			}
		}	
		return ret;
	}

	@Override
	public int[] toArray() 
	{
		int nums = 0;
		for(int i =0; i<a.length;i++)
		{
			if(a[1]!=0)
			{
				nums++;
			}
		}
		int[] ret = new int[nums];
		int nums2 =0;
		for(int q=0;q<a.length;q++)
		{
			if(a[q]!=0)
			{
				ret[nums2]=a[q];
				nums++;
			}
		}
		return a;
		
	}
	public String toString()
	{
		String ret="";
		for(int i =0; i<count;i++)
		{
			ret = ret + a[i] + " ";
		}
		return ret;
	}
}

