package classloading.task1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.security.CodeSource;
import java.security.SecureClassLoader;
import java.security.cert.Certificate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;

public class MyClassLoader extends SecureClassLoader {
	
	private static Logger logger = Logger.getLogger(MyClassLoader.class);
	
	private String jarPath;
	
	public MyClassLoader(String jarPath, ClassLoader parent) {
        super(parent);
        this.jarPath = jarPath;
    }

    public MyClassLoader(String path) {
        this(path, MyClassLoader.class.getClassLoader());
    }
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> clazz = null;
		try {
			clazz = defineClass(jarPath, name);
		} catch (IOException e) {
			logger.debug("Error reading class" + name,e);
		}
		if(clazz == null){
			throw new ClassNotFoundException();
		}
		return clazz;
	}
	
	private Class<?> defineClass(String jarPath, String name) throws IOException{
		File file = new File(jarPath);
		byte[] b = loadJarClassAsBytes(file, name);
		CodeSource codeSource = getCodeSource(file);
		return defineClass(name, b, 0, b.length, codeSource);
	}
	
	public static byte[] loadJarClassAsBytes(File file, String name)
            throws IOException {
		JarFile jarFile = new JarFile(file);
		String classFileName = name.replace('.', '/') + ".class";
		JarEntry jarEntry = jarFile.getJarEntry(classFileName);
		byte[] result = new byte[(int) jarEntry.getSize()];
		InputStream inputStream = jarFile.getInputStream(jarEntry);
        try {
        	inputStream.read(result, 0, result.length);
        } finally {
            try {
            	inputStream.close();
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return result;
    }
	
	protected CodeSource getCodeSource(File f) {
        Certificate[] cert = null;
        try {
            return new CodeSource(f.toURI().toURL(), cert);
        } catch (MalformedURLException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
	
}
