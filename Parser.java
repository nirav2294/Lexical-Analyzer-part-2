/**

 @author Nirav Patel
1. ⟨fun def list⟩ → ⟨fun def⟩ | ⟨fun def⟩ ⟨fun def list⟩ 
2. ⟨fun def⟩ → "(" "define" ⟨header⟩ ⟨exp⟩ ")" 
3. ⟨header⟩ → "(" ⟨fun name⟩ ⟨parameter list⟩ ")" 
4. ⟨fun name⟩ → ⟨id⟩ 
5. ⟨parameter list⟩ → ε | ⟨id⟩ ⟨parameter list⟩ 
6. ⟨exp⟩ → ⟨atom⟩ | ⟨quote⟩ ⟨S exp⟩ | ⟨list exp⟩  - working
7. ⟨atom⟩ → ⟨id⟩ | ⟨int⟩ | ⟨float⟩ | ⟨floatE⟩ | ⟨false⟩ | ⟨true⟩ 
8. ⟨S exp⟩ → ⟨atomic S exp⟩ | "(" [ ⟨S exp⟩ ⟨period⟩ ⟨S exp⟩ ] ")" 
9. ⟨atomic S exp⟩ → ⟨atom⟩ 
10.⟨list exp⟩ → "(" ⟨list exp inside⟩ ")" 
11.⟨list exp inside⟩ → ⟨if⟩ | ⟨cond⟩ | ⟨fun call⟩ | ⟨operator exp⟩ 
12.⟨if⟩ → "if" ⟨exp⟩ ⟨exp⟩ ⟨exp⟩ 
13.⟨cond⟩ → "cond" ⟨case list⟩ 
14.⟨case list⟩ → ⟨case exp⟩ | ⟨case exp⟩ ⟨case list⟩ 
15. ⟨case exp⟩ → "(" ( ⟨case⟩ | ⟨else case⟩ ) ")" 
16.⟨case⟩ → ⟨exp⟩ ⟨exp⟩ 
17. ⟨else case⟩ → "else" ⟨exp⟩ 
18.⟨fun call⟩ → ⟨fun name⟩ ⟨exp list⟩ 
19.⟨operator exp⟩ → ⟨operator⟩ ⟨exp list⟩ 
20.⟨operator⟩ → + | − | * | / | < | <= | > | >= | = | "and" | "or" | "not" | "equal" | "car" | "cdr" | "cons" 
21.⟨exp list⟩ → ε | ⟨exp⟩ ⟨exp list⟩ 

The following variables/functions of "IO"/"LexArithArray" classes are used:

static void display(String s)
static void displayln(String s)
static void setIO(String inFile, String outFile)
static void closeIO()

static void setLex()
static String t // holds an extracted token
static State state // the current state of the finite automaton
static int getToken() // extracts the next token



 */
public abstract class Parser extends LexArith {
	static boolean errorFound = false;

	//⟨fun def list⟩ → ⟨fun def⟩ | ⟨fun def⟩ ⟨fun def list⟩ 
	public static FunDefList funDefList(){
		FunDef funDef = funDef();
		if(state == State.LParen) {
			FunDefList funDefList = funDefList();
			return new MultipleFunDef(funDef, funDefList);
		}
		else 
			return funDef;
	}


	//⟨fun def⟩ → "(" "define" ⟨header⟩ ⟨exp⟩ ")" 
	public static FunDef funDef() {
		
		if(state == State.LParen) {
			getToken();
			if(t.equals("define")) {
				getToken();
				Header header = header();
				Exp exp = exp();
				if(state == State.RParen) {
					getToken();
					return new FunDefHeader(header, exp);
				}
				else 
					errorMsg(1);
			}
			else 
				errorMsg(1);
		}
		else 
			errorMsg(3);
		return null;
	}

	//⟨header⟩ → "(" ⟨fun name⟩ ⟨parameter list⟩ ")" 
	public static Header header() {
		if(state == State.LParen) {
			getToken();
			FunName funName = funName();
			ParameterList parameterList = parameterList();
			if(state == State.RParen) {
				getToken();
				return new Header(funName, parameterList);
			}
			else 
				errorMsg(1);
				return null;
		}
		else
			errorMsg(3);
			return null;
	}

	//⟨fun name⟩ → ⟨id⟩ 
	public static FunName funName() {
		if(state == State.Id) {
			String id = t;
			getToken();
			return new FunName(id);
		}
		else 
			errorMsg(3);
		return null;
	}

	// ⟨parameter list⟩ → ε | ⟨id⟩ ⟨parameter list⟩ 
	public static ParameterList parameterList() {
		
		
		if(state == State.Id) {
			String id = t;
			getToken();
			ParameterList parameterList = parameterList();
			return new MultipleParameterList(id, parameterList);	
		}
		else
			return new EmptyParameterList();
	}

	//⟨exp⟩ → ⟨atom⟩ | ⟨quote⟩ ⟨S exp⟩ | ⟨list exp⟩  - working
	public static Exp exp() {
		if(state == State.Id || state == State.Int || state == State.Float || 
				state== State.FloatE || state == State.True || state == State.False) {
			//getToken();
			Atom atom = atom();
			return new ExpAtom(atom);
		}
		else if(state == State.Quote) {
			String id = t;
			getToken();
			SExp sExp = sExp();
			return new ExpSExp(id, sExp);
		}
		else if (state == State.LParen) {
			ListExp listExp = listExp();
			return new ExpListExp(listExp);
		}
		else
			return null;
	}

	// ⟨atom⟩ → ⟨id⟩ | ⟨int⟩ | ⟨float⟩ | ⟨floatE⟩ | ⟨false⟩ | ⟨true⟩ 
	public static Atom atom() {
		switch(state) {
		case Id:
			Id id = new Id(t);
			getToken();
			return id;
		case Int:
			Int intElem = new Int(Integer.parseInt(t));
			getToken();
			return intElem;
		case Float: case FloatE:
			Floatp floatElem = new Floatp(Float.parseFloat(t));
			getToken();
			return floatElem;
		case False:
			False boolElem = new False((t));
			getToken();
			return boolElem;
		case True:
			True boolElem1 = new True((t));
			getToken();
			return boolElem1;

		default:
			errorMsg(3);
			return null;
		}
	}

	//⟨S exp⟩ → ⟨atomic S exp⟩ | "(" [ ⟨S exp⟩ ⟨period⟩ ⟨S exp⟩ ] ")" 
	public static SExp sExp() {
		if(state == State.Id || state == State.Int || state == State.Float || 
				state== State.FloatE || state == State.True || state == State.False) {
			AtomicSExp atomicSExp = atomicSExp();
			return new SExpAtomicSExp(atomicSExp);
		}
		else if(state == State.LParen) {
			String id = t;
			getToken();
			if(state == State.RParen) {
				String id1 = t;
				getToken();
				return new EmptyExp(id,id1);
			}
			SExp sExp = sExp();
			if(state == State.Period) {
				getToken();
				SExp sExp1 = sExp();
				if(state == State.RParen) {
					getToken();
					return new MultipleSExp(sExp, sExp1);
				}
				else
					errorMsg(1);
			}
			else
				errorMsg(7);
		}
		else
			errorMsg(3);
		return null;
	}
	
	// ⟨atomic S exp⟩ → ⟨atom⟩ 
	public static AtomicSExp atomicSExp() {
		if(state == State.Id || state == State.Int || state == State.Float || 
				state== State.FloatE || state == State.True || state == State.False) {
			//getToken();
			Atom atom = atom();
			return new AtomicSExp(atom);
		}
		else 
			errorMsg(3);
		return null;
	}
	
	//.⟨list exp⟩ → "(" ⟨list exp inside⟩ ")" 
	//error
	public static ListExp listExp() {
		if(state == State.LParen) {
			getToken();
			ListExpInside listExpInside = listExpInside();
			if(state == State.RParen) {
				getToken();
				return new ListExp(listExpInside);
			}
			else 
				errorMsg(1);
		}
		else
			errorMsg(3);
		return null;
	}
	
	//⟨list exp inside⟩ → ⟨if⟩ | ⟨cond⟩ | ⟨fun call⟩ | ⟨operator exp⟩ 
	public static ListExpInside listExpInside() {
		if(t.equals("if")) {
			//getToken();
			If iF = iF();
			return new ListExpInsideIf(iF);
		}
		else if(t.equals("cond")) {
			//getToken();
			Cond cond = cond();
			return new ListExpInsideCond(cond);
		}
		else if(state == State.Add || state == State.Sub || state == State.Mul || state == State.Div || state ==State.Lt || state == State.Le
					|| state == State.Gt || state == State.Ge || state == State.Eq || t.equals("and") || t.equals("or") || t.equals("not") 
					|| t.equals("equal") || t.equals("car") || t.equals("cdr") || t.equals("cons")) {
			OperatorExp operatorExp = operatorExp();
			return new ListExpInsideOperatorExp(operatorExp);
		}
		else {
			//getToken();
			FunCall funCall = funCall();
			return new ListExpInsideFunCall(funCall);
		}
		

	}
	
	//⟨if⟩ → "if" ⟨exp⟩ ⟨exp⟩ ⟨exp⟩ 
	public static If iF() {
		if(t.equals("if")) {
			getToken();
			Exp exp1 = exp();
			Exp exp2 = exp();
			Exp exp3 = exp();
			return new If(exp1, exp2, exp3);
		}
		else 
			errorMsg(8);
		return null;
	}

	//⟨cond⟩ → "cond" ⟨case list⟩ 
	public static Cond cond() {
		if(t.equals("cond")) {
			String id = t;
			getToken();
			CaseList caseList = caseList();
			return new Cond(id, caseList);
		}
		else 
			errorMsg(9);
		return null;
	}
	
	//⟨case list⟩ → ⟨case exp⟩ | ⟨case exp⟩ ⟨case list⟩ 
	public static CaseList caseList() {
		CaseExp caseExp = caseExp();
		if(state == State.LParen) {
			//getToken();
			CaseList caseList = caseList();
			return new MultipleCaseList(caseExp, caseList);
		}
		else 
			return caseExp;
	}
	
	//⟨case exp⟩ → "(" ( ⟨case⟩ | ⟨else case⟩ ) ")" 
	//error
	public static CaseExp caseExp() {
		if(state == State.LParen) {
			getToken();
			if(t.equals("else")) {
				//getToken();
				ElseCase elseCase = elseCase();
				if(state == State.RParen) {
					getToken();
					return new CaseExpElseCase(elseCase);
				}
				else 
					errorMsg(1);
			}
			else {
				Case CASE = CASE();
				if(state == State.RParen) {
					getToken();
					return new CaseExpCase(CASE);
				}
				else 
					errorMsg(1);
			}
		}
		else
			errorMsg(3);

		return null;
	}
	
	//⟨case⟩ → ⟨exp⟩ ⟨exp⟩ 
	public static Case CASE() {
		Exp exp1 = exp();
		Exp exp2 = exp();
		return new Case(exp1, exp2);
	}
	
	//⟨else case⟩ → "else" ⟨exp⟩ 
	public static ElseCase elseCase() {
		if(t.equals("else")) {
			getToken();
			Exp exp = exp();
			return new ElseCase(exp);
		}
		else 
			errorMsg(10);

		return null;
	}

	//⟨fun call⟩ → ⟨fun name⟩ ⟨exp list⟩ 
	public static FunCall funCall() {
		FunName funName = funName();
		ExpList expList = expList();
		return new FunCall(funName, expList);
	}

	//⟨operator exp⟩ → ⟨operator⟩ ⟨exp list⟩ 
	public static OperatorExp operatorExp() {
		Operator operator = operator();
		ExpList expList = expList();
		return new OperatorExp(operator, expList);
	}
	
	//⟨operator⟩ → + | − | * | / | < | <= | > | >= | = | "and" | "or" | "not" | "equal" | "car" | "cdr" | "cons" 

		public static Operator operator() {
			if(state == State.Add) {
				AddOperator add = new AddOperator(t);
				getToken();
				return add;
			}
			else if( state == State.Sub) {
				SubOperator sub = new SubOperator(t);
				getToken();
				return sub;
			}
			else if(state == State.Mul) {
				MulOperator mul = new MulOperator(t);
				getToken();
				return mul;
			}
			else if(state == State.Div) {
				DivOperator div = new DivOperator(t);
				getToken();
				return div;
			}
			else if(state == State.Lt) {
				LessThanOperator lt = new LessThanOperator(t);
				getToken();
				return lt;
			}
			else if(state == State.Le) {
				LessThanOrEqualOperator le = new LessThanOrEqualOperator(t);
				getToken();
				return le;
			}
			else if(state == State.Gt) {
				GreaterThanOperator gt = new GreaterThanOperator(t);
				getToken();
				return gt;
			}
			else if(state == State.Ge) {
				GreaterThanOrEqualOperator ge = new GreaterThanOrEqualOperator(t);
				getToken();
				return ge;
			}
			else if(state == State.Eq) {
				EqualOperator eq = new EqualOperator(t);
				getToken();
				return eq;
			}
			else if(t.equals("and")) {
				And and = new And(t);
				getToken();
				return and;
			}
			else if(t.equals("or")) {
				Or or = new Or(t);
				getToken();
				return or;
			}
			else if(t.equals("not")) {
				Not not = new Not(t);
				getToken();
				return not;
			}
			else if(t.equals("equal")) {
				Equal equal = new Equal(t);
				getToken();
				return equal;
			}
			else if(t.equals("car")) {
				Car car = new Car(t);
				getToken();
				return car;
			}
			else if(t.equals("cdr")) {
				Cdr cdr = new Cdr(t);
				getToken();
				return cdr;
			}
			else if(t.equals("cons")) {
				Cons cons = new Cons(t);
				getToken();
				return cons;

			}
			else {
				errorMsg(4);
				return null;
			}
		}

		//<exp list⟩ → ε | ⟨exp⟩ ⟨exp list⟩
		public static ExpList expList() {
			
			if (state == State.Id || state == State.Int || state == State.Float || 
					state== State.FloatE || state == State.True || state == State.False || 
					state==State.Quote || state==State.LParen){
				//getToken();
				Exp exp = exp();
				ExpList expList = expList();
				return new MultipleExpList(exp, expList);
			}
			else {
				
				return new EmptyExpList();
			}
		}

	public static void errorMsg(int i) {
		errorFound = true;

		display(t + " : Syntax Error, unexpected symbol where");

		switch( i ){
		case 1:	displayln(" Keyword define or ) expected"); return;
		case 2: displayln(" id expected"); return;
		case 3: displayln(" id, int, float, true, false or ( expected"); return;
		case 4:	displayln(" + , − , * , / , < , <= , > , >= , = , and , or , not, equal, car , cdr , cons expected"); return;
		case 5:	displayln(" ; expected"); return;
		case 6:	displayln(" id expected"); return;	
		case 7: displayln(" <period> expected"); return;
		case 8: displayln(" KeyWord_if expected"); return;
		case 9: displayln(" KeyWord_cond expected"); return;
		case 10:displayln("Keyword_else expecterd"); return;
		}
	}

	public static void main(String argv[])
	{
		// argv[0]: input file containing an assignment list
		// argv[1]: output file displaying the parse tree

		setIO( argv[0], argv[1] );


		getToken();

		
        FunDefList funDefList = funDefList(); // build a parse tree
		if ( ! t.isEmpty() )
			errorMsg(5);
		else if ( ! errorFound )
			funDefList.printParseTree(""); // print the parse tree in linearly indented form in argv[1] file

		closeIO();
	}

}







