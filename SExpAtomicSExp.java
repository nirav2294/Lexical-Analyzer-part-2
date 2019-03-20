
public class SExpAtomicSExp extends SExp {

	AtomicSExp sExpAtomicSExp;
	
	SExpAtomicSExp(AtomicSExp ase){
		sExpAtomicSExp = ase;
		
	}
	void printParseTree(String indent) {
		IO.displayln(indent + indent.length() + " <s Exp>");
		sExpAtomicSExp.printParseTree(indent+ " ");
		
		}
	
}
