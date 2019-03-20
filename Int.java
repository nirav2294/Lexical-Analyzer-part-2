
public class Int extends Atom {
	
	int val;

	Int(int i)
	{
		val = i;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent +" ";
		IO.displayln(indent + indent.length() + " <atom> " );
		IO.displayln(indent1 + indent1.length() + " " + val);
	}
}
