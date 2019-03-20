
public class MulOperator extends Operator{

	String id;
	MulOperator(String m){
		id = m;
	}
	void printParseTree(String indent){
		IO.displayln(indent + indent.length() + " * ");
		
	}
}
