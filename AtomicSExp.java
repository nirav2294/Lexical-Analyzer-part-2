
public class AtomicSExp {
	
	Atom atom;
	AtomicSExp(Atom a ){
		atom = a;
	}

	void printParseTree(String indent) {
		IO.displayln(indent + indent.length() + " <Atomic S Exp>");
		atom.printParseTree(indent+" ");
	}
}
