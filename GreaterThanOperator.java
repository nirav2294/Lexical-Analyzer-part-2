
public class GreaterThanOperator extends Operator{

	String id;
	GreaterThanOperator(String gt){
		id = gt;
	}
	void printParseTree(String indent){
	IO.displayln(indent + indent.length() + " > ");
	}
}
