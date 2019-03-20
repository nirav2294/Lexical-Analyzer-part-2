
public class CaseExpElseCase extends CaseExp{

	ElseCase elseCase ;
	CaseExpElseCase(ElseCase ec){
		elseCase = ec;
	}
	
	void printParseTree(String indent)
	{		
		//IO.displayln(indent + indent.length() + " <else Case> ");
		elseCase.printParseTree(indent);
	}
}

