package classloading.task1;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Runner {
	private static Logger logger = Logger.getLogger(Runner.class);
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String className = scanner.nextLine();
		MyClassLoader classLoader = new MyClassLoader();
		try {
			Class s = classLoader.loadClass(className);
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		System.out.println(args.length != 0 ? args[0] : "Empty param");
	}

}
