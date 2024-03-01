import java.util.Iterator;
import java.util.Scanner;

public class ContactList {
	
	public static char sortBy;

	public ContactList (Person[] contacts, char sortBy) {
		ArrayOrderedList<Person> sortedContacts = new ArrayOrderedList<Person>();
		
		ContactList.sortBy = sortBy;
		
		for (int i = 0; i < contacts.length; i++) 
			sortedContacts.add(contacts[i]);
		printContacts(sortedContacts);
		checkContacts(sortedContacts);
	}
	

    /* -----------------------------------------------------------
	   Check that the list has been sorted corectly 
	   ------------------------------------------------------------  */ 
	public static void checkContacts(ArrayOrderedList<Person> list) {
		// Correct order for each one of the possible sorting attributes
		char[] sortedNames = {'A','A','A','C','J','M','R','R','T','V'};
		char[] sortedEmails = {'a','b','j','k','k','m','r','t','t','v'};
		char[] sortedCities = {'L','L','L','L','L','T','T','T','V','V'};
		
		boolean passed = true;
		for (int i = 0; i < list.size(); ++i) {
			Person p = list.get(i);
			if (sortBy == 'n') {  // sort by name
				if (p.getName().charAt(0) != sortedNames[i])
				passed = false;
			}
			else if (sortBy == 'e') {  // sort by email
				if (p.getEmail().charAt(0) != sortedEmails[i])
					passed = false;
			}
			else if (sortBy == 'c') { // sort by city
				if (p.getCity().charAt(0) != sortedCities[i])
					passed = false;
			}
			else passed = false;
		}
		System.out.println("----------------------");
		if (passed) System.out.println("SORTING TEST PASSED");
		else System.out.println("SORTING TEST FAILED!");
		System.out.println("----------------------");		
	}
	
	
	/* ----------------------------------------------------------------
	   Print the information about each one of the contacts in list
	   ----------------------------------------------------------------- */
	public static void printContacts (ArrayOrderedList<Person> list) {
		// Add your code here
   
   


	}
	
	
	public static void main(String[] args) {
	
		Person[] contacts = new Person[] {
			new Person("Artem Kyrzikov", "the.art.guy@gmail.com", "Toronto"),
			new Person("Tina Lawson", "tlawson@uwo.ca", "London"),
			new Person("Clara Kinkaid", "kinkaid_1997@msn.com", "Vancouver"),
			new Person("Johnny Smith", "jsmith57@uwo.ca", "London"),
			new Person("Rebecca Cortez", "beckybrowneyes@gmail.com", "London"),
			new Person("Ahmed Morrah", "king_ahmed_83@gmail.com", "Toronto"),
			new Person("Vanessa Hedberg", "vlhedberg14@hotmail.com", "Vancouver"),
			new Person("Megan McIsaac", "mandm_madness@gmail.com", "Toronto"),
			new Person("Ann Hoffer", "ahoffe61@uwo.ca", "London"),
			new Person("Robert Kane", "rkane79@uwo.ca", "London")
		};
		
		String msg = "Type 'n' to sort by name, 'e' to sort by email, or 'c' to sort by city. Type any other letter to quit.";
		
		
		// Add your code here
		


	}

}
