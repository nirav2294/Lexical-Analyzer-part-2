
public class MultipleFunDef extends FunDefList{

		FunDef funDef;
		FunDefList funDefList;
		
		MultipleFunDef(FunDef f, FunDefList fl ){
			funDef = f;
			funDefList = fl;
		}
		
		void printParseTree(String indent)
		{		
			String indent1 = indent + " ";
			IO.displayln(indent + indent.length() + " <fun def> ");
			funDef.printParseTree(indent+" ");
			//IO.displayln(indent1 + indent1.length() + " <fun def List>");
			funDefList.printParseTree(indent);
		}
}
