
public class ExpListExp extends Exp {

	ListExp expListExp;
	
	ExpListExp( ListExp e ){
		
		expListExp = e;
	}
	
	void printParseTree(String indent) {
		// IO.displayln(indent + indent.length() + " <exp> ldlsfklksflasjkf");
		expListExp.printParseTree(indent+" ");
	}
}

