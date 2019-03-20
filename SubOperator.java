
public class SubOperator extends Operator {
	
	String id;
	SubOperator(String x){
		id = x;
	}
	void printParseTree(String indent){
		LexArith.displayln(indent + indent.length() + " - ");
	}

}
