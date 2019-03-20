
public class EmptyExp extends SExp {
	
	String temp;
	String temp1;
EmptyExp(String i, String d){
		temp = i;
		temp1 = d;
	}

@Override
void printParseTree(String indent) {
	// TODO Auto-generated method stub
	IO.displayln(indent + indent.length() + " <S exp> ");
	String indent1 = indent +" ";
	IO.displayln(indent1 + indent1.length() + " "+ temp+temp1);
}

}
