import java.util.Arrays;

public class SetTester {

	public static void main(String[] args) 
	{
	
		SetInterface test = new ResizableArraySet();	
		ResizableArraySet test2= new ResizableArraySet();
		ResizableArraySet test3= new ResizableArraySet();
		
		
		
		
		//add tester
		
		
		test.add(11);
		test.add(10);
		test.add(9);
		test.add(8);
		test.add(7);
		test.add(6);
		test.add(5);
		test.add(4);
		test.add(3);
		test.add(2);
		test.add(1);
		System.out.println("adding 11 items to empty set using default constructor to instantiate the array, \nhence testing the resize aswell by adding 11 items");
		System.out.println("expected : 11 10 9 8 7 6 5 4 3 2 1");
		System.out.println("result " + test);
		System.out.println();
		System.out.println("getSize test\nexpected 11");
		System.out.println("result " + test.getSize());
		
		// remove test
		System.out.println();
		System.out.println("general remove test");
		System.out.println("expected : 11 10 9 8 7 6 5 4 3 2 ");
		test.remove();
		System.out.println("result "+test);
		System.out.println();
		System.out.println("getSize test\nshould return 10");
		System.out.println("result " + test.getSize());
		System.out.println();
		System.out.println("removing 1 more item should cause the array to half in size");
		test.remove();
		System.out.println("expected 11 10 9 8 7 6 5 4 3 ");
		System.out.println("result " + test);
		System.out.println();
		System.out.println("getSize test\nshould return 9");
		System.out.println(test.getSize());
		System.out.println();
		// specfic array test
		System.out.println("specfic remove test i'll remove the numbers 4 then 7 then 8");
		test.remove(4);
		System.out.println("expected 11 10 9 8 7 6 5 3 ");
		System.out.println("result " + test);
		System.out.println();
		test.remove(7);
		System.out.println("expected 11 10 9 8 6 5 3 ");
		System.out.println("result " + test);
		System.out.println();
		test.remove(8);
		System.out.println("expected 11 10 9 6 5 3  ");
		System.out.println("result " +test);
		System.out.println();
		System.out.println("getSize test\nshould return 6 ");
		System.out.println(test.getSize());
		//contains test method
		System.out.println();
		System.out.println("contains test i'll first search for 9 then i'll search for 100 \nexpected true then false");
		System.out.println("result " + test.contains(9));
		System.out.println("result " + test.contains(100));
		// union test
		test2.add(12);
		test2.add(13);
		System.out.println();
		System.out.println("array one " + test);
		System.out.println("array two " + test2);
		System.out.println("testing union with 2 arrays \nshould print 12 13 11 10 9 6 5 3");
		test=(ResizableArraySet) test.union(test2);
		System.out.println("result " +test);
		System.out.println();
		
		// clear test
		System.out.println("clear test, array should be empty");
		test2.clear();
		test.clear();
		System.out.println("result "+ test);
		System.out.println();
		// intersection test
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test3.add(5);
		test3.add(6);
		test3.add(4);
		test3.add(11);
		
		System.out.println("first array " + test);
		System.out.println("second array " + test3);

		System.out.println("testing intersection with 2 arrays \nshould print 4 5 6");
		test =  test.intersection(test3);
		System.out.println("result " + test);
		System.out.println();
		
		SetInterface test4 = new ResizableArraySet();	
		ResizableArraySet test5= new ResizableArraySet();
		test4.add(1);
		test4.add(2);
		test4.add(5);
		test4.add(8);
		test5.add(1);
		test5.add(3);
		test5.add(5);
		test5.add(7);
		System.out.println("first array " + test4);
		System.out.println("second array " + test5);
		System.out.println("testing difference, with 2 arrays \nshould print 2 3 7 8 ");
		test4 =  test4.difference(test5);
		System.out.println("result " + test4);
		System.out.println();
		
		
		
		
		// i believe all methods work except intersection
		// but the problem seems to be in the set up rather than the method itself
		
	
	
		
		
		
		// TODO Auto-generated method stub

	}

}
