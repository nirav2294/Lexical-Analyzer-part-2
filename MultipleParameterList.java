
public class MultipleParameterList extends ParameterList{
	String id ;
	ParameterList parameterList;
	boolean counter = true;
	MultipleParameterList(String s, ParameterList pl){
		id = s;
		parameterList = pl;
	}
	
	void printParseTree(String indent)
	{

		
		IO.displayln(indent + indent.length() + " <parameter> " + id);
		parameterList.printParseTree(indent);
		
	}
}
