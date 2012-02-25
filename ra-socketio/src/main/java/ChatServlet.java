import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.http.HttpServletRequest;

import com.glines.socketio.server.SocketIOInbound;
import com.glines.socketio.server.SocketIOServlet;

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
public final class ChatServlet extends SocketIOServlet {
	private final BlockingQueue<Endpoint> endpoints = new LinkedBlockingQueue<Endpoint>();

	@Override
	protected SocketIOInbound doSocketIOConnect(HttpServletRequest request) {
		String user = (String) request.getSession().getAttribute("user");
		return user == null ? null : new Endpoint(this, user, request);
	}

	void broadcast(String data) {
		for (Endpoint endpoint : endpoints) {
			endpoint.send(data);
		}
	}

	void add(Endpoint endpoint) {
		endpoints.offer(endpoint);
	}

	void remove(Endpoint endpoint) {
		endpoints.remove(endpoint);
	}
}