
public class True extends Atom {


	String tru;
	True(String f)
	{
		tru = f;
	}

	void printParseTree(String indent)
	{
		String indent1= indent +" ";
		IO.displayln(indent + indent.length() + " <atom> ");
		IO.displayln(indent1 + indent1.length() + " " + tru);
	}


}

