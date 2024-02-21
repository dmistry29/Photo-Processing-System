package tests;

import org.junit.Test;

import sysutilities.Address;

public class StudentTests {
	
	@Test
	public void fullConstructor(){
		Address add1 = new Address("123 UMD Street", "College Park", "MD", "27481");
		System.out.println(add1);
		System.out.println("\n====================================\n");
	}
	
	@Test
	public void gettersCheck(){
		Address add2 = new Address("123 UMD Street", "College Park", "MD", "27481");
		System.out.println(add2.getStreet());	
		System.out.println(add2.getCity());
		System.out.println(add2.getState());
		System.out.println(add2.getZip());
		System.out.println("\n====================================\n");
	}
	
	@Test
	public void nullStreet(){
		try 
		{
			Address add3 = new Address(null, "College Park", "MD", "27481");
			System.out.println(add3);
		}
		
		catch(IllegalArgumentException e)
		{
			System.out.println("Please provide a street address!");
			System.out.println("\n====================================\n");
		}
	}
	
	@Test
	public void nullCity(){
		try
		{
		Address add4 = new Address("123 UMD Street", null, "MD", "27481");
		System.out.println(add4);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Please provide a city");
			System.out.println("\n====================================\n");
		}
	}
	
	@Test
	public void nullState(){
		try 
		{
			Address add5 = new Address("123 UMD Street", "College Park", null, "27481");
			System.out.println(add5);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Please provide the state");
			System.out.println("\n====================================\n");
		}
	}
	
	@Test
	public void nullzip(){
		try
		{
		Address add6 = new Address("123 UMD Street", "College Park", "MD", null);
		System.out.println(add6);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Please provide a zip code");
			System.out.println("\n====================================\n");
		}
	}
	
	@Test
	public void emptyConstructor() {
		Address add7 = new Address();
		System.out.println(add7);
		System.out.println("\n====================================\n");
	}
	
	@Test
	public void copyConstructor() {
		Address add8 = new Address("453 West Drive", "Silver Spring", "MD", "20503");
		Address add9 = new Address(add8);
		System.out.println(add8);
		System.out.println(add9);
		System.out.println("\n====================================\n");
	}
	
	@Test
	public void differentStreet() {
		Address add10 = new Address("984 South Drive", "Bethesda", "MD", "23424");
		System.out.println(add10);
		Address add11 = new Address(add10, "893 West Street");
		System.out.println(add11);
		System.out.println("\n====================================\n");
	}
	
	@Test
	public void trimExample() {
		Address add10 = new Address("   238 North Street    ", "   College Park   ", "   MD ", " 478923 ");
		System.out.println(add10);
		System.out.println("\n====================================\n");
	}
	
	
	@Test
	public void checkEqualTrue(){
		Address add11 = new Address("123 UMD Street", "College Park", "MD", "24233");
		Address add12 = new Address("123 UMD Street", "College Park", "MD", "24233");
		boolean answer = add11.equals(add12);
		System.out.println(answer);
		System.out.println("\n====================================\n");
	}
	
	@Test
	public void checkEqualFalseStreet(){
		Address add13 = new Address("123 UMD Street", "College Park", "MD", "24233");
		Address add14 = new Address("123 UMD Stret", "College Park", "MD", "24233");
		boolean answer = add13.equals(add14);
		System.out.println(answer);
		System.out.println("\n====================================\n");
	}
	
	@Test
	public void checkEqualFalseState(){
		Address add15 = new Address("123 UMD Street", "College Park", "MD", "24233");
		Address add16 = new Address("123 UMD Stret", "College Park", "VA", "24233");
		boolean answer = add15.equals(add16);
		System.out.println(answer);
		System.out.println("\n====================================\n");
	}
	
	@Test
	public void checkEqualFalseCity(){
		Address add17 = new Address("123 UMD Street", "College Park", "MD", "24233");
		Address add18 = new Address("123 UMD Stret", "College", "MD", "24233");
		boolean answer = add17.equals(add18);
		System.out.println(answer);
		System.out.println("\n====================================\n");
	}
	
	@Test
	public void checkEqualFalseZip(){
		Address add19 = new Address("123 UMD Street", "College Park", "MD", "24233");
		Address add20 = new Address("123 UMD Stret", "College Park", "MD", "24253");
		boolean answer = add19.equals(add20);
		System.out.println(answer);
		System.out.println("\n====================================\n");
	}	
}
