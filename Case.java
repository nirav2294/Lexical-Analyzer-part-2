
public class Case extends CaseExp{
	Exp caseExp1;
	Exp caseExp2;
	
	Case(Exp e1, Exp e2){
		caseExp1 = e1;
		caseExp2 = e2;
	}
	
	void printParseTree(String indent)
	{		
		String indent1 = indent + " ";
		//IO.displayln(indent + indent.length() + " <exp> ");
		caseExp1.printParseTree(indent);
		IO.displayln(indent + indent.length() + " <exp> ");
		caseExp2.printParseTree(indent1);
	}

}
