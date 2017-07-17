package main;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class NsApiMainRequestHandler {
    public static final int maxThreads = 100;
    public static final int minThreads = 10;
    public static final int idleTimeout = 120;
    
	public static void main(String[] args) {
		// Main process to handle incoming Requests
		final QueuedThreadPool threadPool = new QueuedThreadPool(maxThreads, minThreads, idleTimeout);
		final Server server = new Server(threadPool);
		ServerConnector connector = new ServerConnector(server);
		connector.setHost("127.0.0.1");
		connector.setPort(8090);
		server.setConnectors(new Connector[] {connector});
		
		
		

	}

}
