
public class EqualOperator extends Operator {
	
	String id;
	EqualOperator(String eq){
		id = eq;
	}
	void printParseTree(String indent){
 	IO.displayln(indent + indent.length() + " = ");
	}
}
