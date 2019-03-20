
public class ElseCase {
	
	Exp exp;
	ElseCase(Exp e){
		exp=e;
	}
	void printParseTree(String indent){
		IO.displayln(indent + indent.length() + " <exp> ");
		exp.printParseTree(indent);
	}
	
	

}
