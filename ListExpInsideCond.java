
public class ListExpInsideCond extends ListExpInside {


	Cond listExpInsideCond;
	
	ListExpInsideCond(Cond con){
		listExpInsideCond = con;
	}
	
	void printParseTree(String indent) {
		//IO.displayln(indent + indent.length() + " <listExpInside>");
		listExpInsideCond.printParseTree(indent);
	}

	
}

