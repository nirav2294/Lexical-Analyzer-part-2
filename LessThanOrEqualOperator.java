
public class LessThanOrEqualOperator extends Operator {

		String id;
		LessThanOrEqualOperator(String lteq){
			id = lteq;
		}
		void printParseTree(String indent){
			LexArith.displayln(indent + indent.length() + " <= ");
		}
}
