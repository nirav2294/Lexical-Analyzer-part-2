
public class Not extends Operator {

	String id;
	Not(String not){
		id = not;
	}
	void printParseTree(String indent){
		LexArith.displayln(indent + indent.length() + " not ");
	}
}
