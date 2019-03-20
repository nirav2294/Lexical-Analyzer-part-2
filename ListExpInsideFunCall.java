
public class ListExpInsideFunCall extends ListExpInside {


	FunCall listExpInsideFunCall;
	
	ListExpInsideFunCall(FunCall fc){
		listExpInsideFunCall = fc;
	}
	
	void printParseTree(String indent) {
		//IO.displayln(indent + indent.length() + " <listExpInsideFunCall>");
		listExpInsideFunCall.printParseTree(indent);
	}

	
}

