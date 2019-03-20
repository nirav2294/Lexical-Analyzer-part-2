
public class Equal extends Operator{

	String id;
	Equal(String eq){
		id = eq;
	}
	void printParseTree(String indent){
		IO.displayln(indent + indent.length() + " "+  id);
	}
}
