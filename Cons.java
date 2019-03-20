
public class Cons extends Operator {

	String id;
	
	Cons(String cons){

		id = cons;
	}
	void printParseTree(String indent){
		LexArith.displayln(indent + indent.length() + " cons ");
	}
}
