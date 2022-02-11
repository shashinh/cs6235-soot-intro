import java.util.List;
import java.util.Map;

import soot.Body;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.AssignStmt;
import soot.jimple.IfStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;

public class DummyAnalysis extends SceneTransformer {

	@Override
	protected void internalTransform(String arg0, Map<String, String> arg1) {

		System.out.println("hello from Dummy Analysis");
		
		
		SootClass mainClass = Scene.v().getMainClass();
		SootMethod mainMethod = mainClass.getMethodByName("main");
		
		System.out.println(mainMethod);
		
		System.out.println(mainMethod.getActiveBody());

		System.out.println(mainMethod.getActiveBody().getLocals());
		
		System.out.println("************************");
		for(Unit unit : mainMethod.getActiveBody().getUnits()) {
			System.out.println(unit);
			
			//identify all assignment statements
			//print all LHS and RHS
			// left expr = right expr
			
			Stmt stmt = (Stmt) unit;
			if(stmt instanceof AssignStmt) {
				AssignStmt as = (AssignStmt) stmt;
				System.out.println("found an assign " + as);
				System.out.println("LHS " + as.getLeftOp());
				System.out.println("RHS " + as.getRightOp());
			}
		}

	}

}
