
public class False extends Atom {

	String fal;
	False(String f)
	{
		fal = f;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent+" ";
		IO.displayln(indent + indent.length() + " <atom> ");
		IO.displayln(indent1 + indent1.length() + " " + fal);
	}


}