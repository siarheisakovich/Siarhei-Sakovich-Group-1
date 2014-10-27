package memoryManagement;

public class OutOfMemoryErrorRunner {

	public static void main(String[] args) throws InterruptedException {
		ChainBean initBean = new ChainBean();		
		ChainBean prev = new ChainBean();
		initBean.setChainBean(prev);
		while(true){
			ChainBean current = new ChainBean();
			current.setChainBean(prev);
			prev = current;
		}
	}
}
