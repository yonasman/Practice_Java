//my first java program
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");  //prints Hello world
	String name = "Yonas";
	int a = 5;
	float b = 2.4f;
	char c = 'A';
	boolean d = true;

	System.out.println(name);
	System.out.println(a);
	System.out.println(b);
	System.out.println(c);
	System.out.println(d);
	//working with string
	String text = "Yonas is becoming a great programmer!";
	System.out.println("The length of text is :" + text.length());
	//expl2
	String firstName = "Yonas";
	String lastName = "Negese";
	String fullName = firstName.concat(lastName);
	System.out.println(fullName);
	//for each loop
	String[] arr = {"abe","yon","bel"};
	for (String i : arr) {
		System.out.println(i);
	}
    }
}
