
public class CaseExpCase extends CaseExp{

	Case CASE ;
	CaseExpCase(Case c){
		CASE = c;
	}
	
	void printParseTree(String indent)
	{		
		IO.displayln(indent + indent.length() + " <exp> ");
		CASE.printParseTree(indent);
	}
}
