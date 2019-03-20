
public class FunCall {


	FunName funName;
	ExpList expList;

	FunCall(FunName x, ExpList y){
		funName = x;
		expList = y;
	}	
	void printParseTree(String indent){	
		String indent1 = indent +" ";
		IO.displayln(indent + indent.length() + " <fun Name> ");
		funName.printParseTree(indent1);
		IO.displayln(indent1 + indent1.length() + " <exp List> ");
		expList.printParseTree(indent1);

	}	
}
