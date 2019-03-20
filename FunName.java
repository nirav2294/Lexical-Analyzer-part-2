
public class FunName {

	String id;	
	FunName(String i){
		id = i;
	}
	void printParseTree(String indent){	
		IO.displayln(indent + indent.length() + " <fun name> " +  id);
		
	
	}
}
