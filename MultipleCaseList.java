
public class MultipleCaseList extends CaseList {

	CaseExp caseExp;
	CaseList caseList;
	
	MultipleCaseList(CaseExp ce, CaseList cl){
		caseExp = ce;
		caseList = cl;
	}
	
	void printParseTree(String indent)
	{		
		String indent1 = indent +" ";
		IO.displayln(indent + indent.length() + " <case Exp> ");
		caseExp.printParseTree(indent1);
		IO.displayln(indent1 + indent1.length() + " <case List> ");
		caseList.printParseTree(indent1);
	}
}
