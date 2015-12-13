package ie.gmit.sw.queue;

import java.rmi.Naming;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import ie.gmit.sw.VigenereBreaker;
import ie.gmit.sw.VigenereService;

public class VigenereHandler {
	private BlockingQueue<Request> queue;
	private Map<Long, String> out = new ConcurrentHashMap<Long, String>();	
	private String result;
	private Request req = null;
	
	public VigenereHandler(BlockingQueue<Request> q, Map<Long, String> out) {
		this.out = out;
		this.queue = q;
		run();
	}
	
	public void run() {
		try {
			req = queue.take();
		} 
		
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			
			VigenereService vs = null;
			if(req.getHostIP() != null) {
				String ip = req.getHostIP();
				vs = (VigenereService) Naming.lookup("rmi://" + ip + "/cypher-service");

			} else {
				vs = (VigenereService) Naming.lookup("cypher-service");
			}			
			VigenereBreaker vb = vs.getVigenere();
			result = vb.decrypt(req.getCypherText(),  req.getMaxKeySize());
			out.put(req.getJobNumber(), result);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public String returnResult() {
		return out.get(req.getJobNumber());
	}
}
