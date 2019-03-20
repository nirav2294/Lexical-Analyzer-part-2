
public class ListExpInsideIf extends ListExpInside {
	
	If listExpInsideIf;
	
	ListExpInsideIf(If f){
		listExpInsideIf = f;
	}
	
	void printParseTree(String indent) {
		//IO.displayln(indent + indent.length() + " <listExpInside>");
		listExpInsideIf.printParseTree(indent);
	}

	
}
