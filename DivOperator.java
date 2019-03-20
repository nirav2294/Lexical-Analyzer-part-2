
public class DivOperator extends Operator{
	
	String id;
	DivOperator(String d){
		id = d;
	}
	void printParseTree(String indent){
		IO.displayln(indent + indent.length() + " / ");
	}

}
