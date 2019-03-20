
public class FunDefHeader extends FunDef {

	Header header;
	Exp exp;
	
	FunDefHeader(Header h, Exp e){
		header = h;
		exp = e;
	}	
	
	
	void printParseTree(String indent) {
		String indent1 = indent + " ";
		//IO.displayln(indent + indent.length() + " <fun Def> ");
		IO.displayln(indent + indent.length() + " <header> ");
		header.printParseTree(indent1);
		IO.displayln(indent1 + indent1.length() + " <exp> ");
		exp.printParseTree(indent1);
	}

}
