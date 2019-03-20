
public class If {

	Exp exp_1;
	Exp exp_2;
	Exp exp_3;
	
	If(Exp e1,Exp e2,Exp e3){
		exp_1 = e1;
		exp_2 = e2;
		exp_3 = e3;
	}
	void printParseTree(String indent){	
		IO.displayln(indent + indent.length() + " <exp> ");
		exp_1.printParseTree(indent);
		IO.displayln(indent + indent.length() + " <exp> ");
		exp_2.printParseTree(indent);
		IO.displayln(indent + indent.length() + " <exp> ");
		exp_3.printParseTree(indent);
	}	
}
