
public class OperatorExp extends ListExpInside {

	Operator operator;
	ExpList expList;
	
	OperatorExp(Operator o,  ExpList el){
		operator = o;
		expList = el;
	}
	
	void printParseTree(String indent)
	{		
		String indent1 = indent + " ";
		IO.displayln(indent + indent.length() + " <operator exp> ");
		operator.printParseTree(indent1);
		//IO.displayln(indent1 + indent1.length() + " <expList> ");
		expList.printParseTree(indent1);
	}
}
