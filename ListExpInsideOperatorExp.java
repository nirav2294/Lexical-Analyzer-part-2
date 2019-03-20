
public class ListExpInsideOperatorExp extends ListExpInside {


	OperatorExp listExpInsideOperatorExp;
	
	ListExpInsideOperatorExp(OperatorExp oe){
		listExpInsideOperatorExp = oe;
	}
	
	void printParseTree(String indent) {
		//IO.displayln(indent + indent.length() + " <listExpInsideOperatorExp>");
		listExpInsideOperatorExp.printParseTree(indent);
	}

	
}

