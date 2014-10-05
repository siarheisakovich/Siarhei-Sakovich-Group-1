package classloading.task1.newFunctionality;

import classloading.task1.Module;


public class ModuleImpl implements Module{

	@Override
	public String toString() {
		return counter.toString();
	}

	@Override
	public void append(String string) {
		counter.append(string);
	}

}
