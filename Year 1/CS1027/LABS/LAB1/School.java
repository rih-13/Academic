
public class School {

	Person[] students;

	public School() {
		Person p1 = new Person("Tomi", "Maarigati", "tomimaari@gmail.com");
		Person p2 = new Person("Bryce", "Karlsson", "bkarlsson@uwo.ca");
		Person p3 = new Person("Kelsey", "Saunders", "guitar.girl2002@gmail.com");
		Person p4 = new Person("Nayra", "Surdeep", "nsurde75@uwo.ca");
		Person p5 = new Person("Anwar", "Mohammad", "amohammad32@aol.com");
		Person p6 = new Person("Jake", "Rogers", "jrogers@uwo.ca");
		Person p7 = new Person("Kate", "Simpson", "kateisgreat88@gmail.com");

		students = new Person[] { p1, p2, p3, p4, p5, p6, p7 };

	}

	public static void main(String[] args) {
		new School();
	}

}
