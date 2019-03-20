
public class LessThanOperator extends Operator{
	String id;
	LessThanOperator(String lt){
		id = lt;
	}
	void printParseTree(String indent){
		LexArith.displayln(indent + indent.length() + " < ");
	}
}
