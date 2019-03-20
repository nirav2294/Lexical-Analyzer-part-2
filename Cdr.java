
public class Cdr extends Operator{

	String id;
	Cdr(String cdr){
		id = cdr;
	}
	void printParseTree(String indent){
		LexArith.displayln(indent + indent.length() + " cdr ");
	}
}
