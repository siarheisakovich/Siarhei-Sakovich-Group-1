package classloading.task1;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Runner {
	static final Logger logger = Logger.getLogger(Runner.class);
	
	public static void main(String[] args) throws Exception {
		for(; ; ){
			Scanner scanner = new Scanner(System.in);
			//"classloading.task1.ModuleImpl"
			String className = scanner.nextLine();
			//"D:\\test\\myJar.jar"
			String path = scanner.nextLine();
			MyClassLoader classLoader = new MyClassLoader(path);
			Class<?> clazz = Class.forName(className, true, classLoader);
			Module module = (Module)clazz.newInstance();
			logger.info(module);
			module.append("Hello");
			logger.info(module.toString());
		}
	}

}
