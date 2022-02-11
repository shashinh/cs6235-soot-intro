import java.util.Arrays;

import soot.Body;
import soot.PackManager;
import soot.Scene;
import soot.SootMethod;
import soot.Transform;

public class Main {
	public static void main (String [] args) {
		String classPath = "<directory-containing-your-main-class";
		String mainClass = "<name-of-your-main-class";
		
		String [] sootArgs = {
				"-v",
				"-cp", classPath,
				"-pp",
				"-w", /*"-app",*/
				//"-p", "jb", "use-original-names:true",
				//"-f", "J",
				//"-d", "output",
				mainClass
				
		};
		
		System.out.println("The soot arguments are " + Arrays.toString(sootArgs));
		
		DummyAnalysis da = new DummyAnalysis();
		PackManager.v().getPack("wjtp").add(new Transform("wjtp.da", da));
		
		soot.Main.main(sootArgs);
		
	}
}
