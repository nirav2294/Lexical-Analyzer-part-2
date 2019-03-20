
public class AddOperator extends Operator {
	String id;
	AddOperator(String a){
		id = a;
	}
	void printParseTree(String indent){
		IO.displayln(indent + indent.length() + " + ");
		
	}
}
