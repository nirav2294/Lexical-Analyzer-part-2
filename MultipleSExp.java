
public class MultipleSExp extends SExp {
	
	SExp multipleSExp1;
	SExp multipleSExp2;
	
	MultipleSExp(){
		
	}
	MultipleSExp(SExp exp, SExp exp1){
		multipleSExp1 = exp;
		multipleSExp2 = exp1;
		
	}
	void printParseTree(String indent) {
		String indent1 = indent+ " ";
		IO.displayln(indent + indent.length() + " <s exp>");
		multipleSExp1.printParseTree(indent1);
		//IO.displayln(indent1 + indent1.length() + " <s exp>");
		multipleSExp2.printParseTree(indent1);
		}
	
}
