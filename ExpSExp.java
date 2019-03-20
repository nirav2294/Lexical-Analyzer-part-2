
public class ExpSExp extends Exp{

	SExp expSExp;
	String id;

	ExpSExp( String i, SExp e ){
		id =i;
		expSExp = e;
		
	}

	void printParseTree(String indent) {
		String indent1 = indent + " ";
		IO.displayln(indent + indent.length() +  " " + id);
		expSExp.printParseTree(indent);
	}
}


