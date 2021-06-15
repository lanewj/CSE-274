import java.util.Arrays;

public class SetTester {

	public static void main(String[] args) 
	{
	
		SortedSet test = new SortedSet();	
		SortedSet test2= new SortedSet();
		SortedSet test3 = new SortedSet();		
		
		
		//add tester
		
		
		
		//System.out.println("a added");
		test.add("b");
		//System.out.println("b added");
		test.add("c");
		//System.out.println("c added");
		test.add("d");
		//System.out.println("d added");
		test.add("e");
		//System.out.println("e added");
		test.add("f");
		//System.out.println("f added");
		test.add("a");
		
		System.out.println("adding 6 items to empty LinkedSet ");
		System.out.println("should see : a b c d e f");
		System.out.println(test);
		System.out.println("getSize test\nshould return 6");
		 System.out.println(test.getCurrentSize());
		// remove test
		System.out.println();
		System.out.println("general remove test");
		System.out.println("should see : b c d e f ");
		test.remove();
		System.out.println(test);
		// specfic array test
		System.out.println("specfic remove test i'll remove the letter b then f then d");
		test.remove("b");
		System.out.println(" should see   c d e f ");
		System.out.println(test);
		test.remove("f");
		System.out.println(" should see   c d e   ");
		System.out.println(test);
		test.remove("d");
		System.out.println(" should see  c e ");
		System.out.println(test);
		System.out.println("next ill add other words to show the sorted portion works");
		test.add("walrus");
		System.out.println("added the word walrus should see c e walrus");
		System.out.println(test);
		test.add("chicken");
		System.out.println("added the word chicken should see c chicken e walrus");
		System.out.println(test);
		test.add("apple");
		System.out.println("added the word apple should see apple c e walrus");
		System.out.println(test);
		System.out.println("next ill add apple again to show it doesn't add duplicates");
		test.add("apple");
		System.out.println(test);
		
		
		
		//contains test method
		System.out.println();
		System.out.println("contains test i'll first search for e then i'll search for z \nshould see true then false");
		System.out.println(test.contains("e"));
		System.out.println(test.contains("z"));
		System.out.println("clear test array should be empty");
		test.clear();
		System.out.println(test);
		System.out.println();
		
		
	
	
		
	
	
		
		
		
		// TODO Auto-generated method stub

	}

}

