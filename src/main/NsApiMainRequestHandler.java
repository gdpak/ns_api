package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class NsApiMainRequestHandler {
    public static final int maxThreads = 100;
    public static final int minThreads = 10;
    public static final int idleTimeout = 120;
    
    public static class TCallBackHandler extends AbstractHandler
	{
		static int h=0;
		int hello=h++;

		@Override
		public void handle(String arg0, Request base_request, HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			// TODO Auto-generated method stub
			//Request base_request = (request instanceof Request) ? (Request)request : HttpConnection.getCurrentConnection().getRequest();
			base_request.setHandled(true);
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/html");
			response.getWriter().println("<h1> Hello Welcome to NS API </h1>"+hello+"");
			
		}
	}
    
	public static void main(String[] args) throws Exception {
		// Main process to handle incoming Requests
		final QueuedThreadPool threadPool = new QueuedThreadPool(maxThreads, minThreads, idleTimeout);
		final Server server = new Server(threadPool);
		ServerConnector connector = new ServerConnector(server);
		connector.setHost("127.0.0.1");
		connector.setPort(8090);
		server.setConnectors(new Connector[] {connector});
		
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		ContextHandler tcontext = new ContextHandler();
		tcontext.setContextPath("/context");
		Handler tCallbackHandler = new TCallBackHandler();
		tcontext.setHandler(tCallbackHandler);
		contexts.addHandler(tcontext);
		
		HandlerCollection handlers = null;
		handlers = new HandlerCollection();
		handlers.setHandlers(new Handler[] {contexts, new DefaultHandler() });
		server.setHandler(handlers);
		server.start();
		server.setStopAtShutdown(true);
		}
}

