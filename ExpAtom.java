
public class ExpAtom extends Exp {
	Atom expAtom;

	ExpAtom(Atom a){
		expAtom = a;
	}

	void printParseTree(String indent) {
		//IO.displayln(indent + indent.length() + " <exp> ");
		expAtom.printParseTree(indent);
	}

}
