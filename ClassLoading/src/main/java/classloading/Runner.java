package classloading;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Runner {
	static final Logger logger = Logger.getLogger(Runner.class);
	
	public static void main(String[] args) throws Exception {
		for(; ; ){
			Scanner scanner = new Scanner(System.in);
			//"classloading.task1.ModuleImpl"
			//String className = scanner.nextLine();
			String className = "classloading.module.ModuleImpl";
			//"D:\\test\\myJar.jar"
			System.out.print("Please enter path to jar with classloading.module.ModuleImpl: ");
			String path = scanner.nextLine();
			//String path = "D:\\test\\module1.jar";
			MyClassLoader classLoader = new MyClassLoader(path);
			Class<?> clazz = Class.forName(className, true, classLoader);
			Module module = (Module)clazz.newInstance();
			module.doStaff();
			logger.info(module);
			logger.info(module.toString());
			System.out.print("Press 'Enter' to continue");
			scanner.nextLine();
		}
	}

}
