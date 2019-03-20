
public class Header {
	
	
	FunName funName;
	ParameterList parameterList;
	
	Header(FunName fn, ParameterList pl) {
		funName = fn;
		parameterList = pl;
	}
	
	void printParseTree(String indent){	
		
		String indent1 = indent + " ";
		//IO.displayln(indent + indent.length() + " <fun name> ");
		funName.printParseTree(indent);
		IO.displayln(indent + indent.length() + " <parameter List> ");	
		parameterList.printParseTree(indent1);
	}	
}
