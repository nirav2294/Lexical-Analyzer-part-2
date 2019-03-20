
public class GreaterThanOrEqualOperator extends Operator{

	String id;
	GreaterThanOrEqualOperator(String gteq){
		id = gteq;
	}
	void printParseTree(String indent){
		IO.displayln(indent + indent.length() + " >= ");
	}
}
