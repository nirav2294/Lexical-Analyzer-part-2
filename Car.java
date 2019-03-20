
public class Car extends Operator{

	String id;
	Car(String car){
		id = car;
	}
	void printParseTree(String indent){
		IO.displayln(indent + indent.length() + " car ");
	}
}
