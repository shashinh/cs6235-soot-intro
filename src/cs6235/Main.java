package cs6235;

import java.util.Arrays;

import soot.Body;
import soot.PackManager;
import soot.Scene;
import soot.SootMethod;
import soot.Transform;

public class Main {
	public static void main (String [] args) {
		String classPath = "<path to the folder that contains your test classes";
		String mainClass = "<the name of your Main class - usually just 'Main'>";
		
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
