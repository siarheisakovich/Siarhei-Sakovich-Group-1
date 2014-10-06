package classloading;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Runner {
	static final Logger logger = Logger.getLogger(Runner.class);
	
	public static void main(String[] args) {
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
			Class<?> clazz;
			try {
				clazz = Class.forName(className, true, classLoader);
				logger.info(clazz);
				Module module = (Module) clazz.newInstance();
				module.doStaff();
				logger.info(module);
			} catch (ClassNotFoundException e) {
				logger.error("Could not find class " + className + " in " + path, e);
			} catch (InstantiationException e) {
				logger.error(e);
			} catch (IllegalAccessException e) {
				logger.error(e);
			}
		}
	}

}
