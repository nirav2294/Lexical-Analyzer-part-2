
public class Or extends Operator {

	String id;
	Or(String or){
		id = or;
	}
	void printParseTree(String indent){
		IO.displayln(indent + indent.length() + " or ");
	}
}
