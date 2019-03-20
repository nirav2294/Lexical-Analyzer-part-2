
public class And extends Operator {
	String id;
	And(String and){
		id = and;
	}
	void printParseTree(String indent){
		IO.displayln(indent + indent.length() + " and ");
	}
}
