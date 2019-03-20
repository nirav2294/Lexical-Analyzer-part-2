
public class Cond {
	
	CaseList caseList;
	String id ;
	Cond(String i, CaseList cl){
		id = i;
		caseList = cl;
	}
	
	void printParseTree(String indent){
		IO.displayln(indent + indent.length() + " " + id);
		IO.displayln(indent + indent.length() + " <case List> ");
		caseList.printParseTree(indent+" ");
	}
}
