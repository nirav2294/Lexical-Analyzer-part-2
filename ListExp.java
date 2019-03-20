
public class ListExp {
	
ListExpInside ListExpInside;
	
	ListExp(ListExpInside lei){
		ListExpInside = lei;
	}
	void printParseTree(String indent) {
		IO.displayln(indent + indent.length() + " <list exp> ");
		ListExpInside.printParseTree(indent+" " );
		
	}
}
