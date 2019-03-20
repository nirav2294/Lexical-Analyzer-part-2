
public class MultipleExpList extends ExpList {

	
	Exp exp;
	ExpList expList;
	
	MultipleExpList(Exp x, ExpList y){
		exp = x;
		expList = y;
	}	
	void printParseTree(String indent){
		String indent1 = indent +" ";
		IO.displayln(indent + indent.length() + " <exp> ");
		exp.printParseTree(indent1);
		//IO.displayln(indent1 + indent1.length() + " <exp List> ");
		expList.printParseTree(indent);
	}
}
