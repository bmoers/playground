import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
public final class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String existingUser = (String) session.getAttribute("user");
		String user = req.getParameter("user");
		if (user == null && existingUser == null) {
			resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		else if (existingUser != null && !existingUser.equals(user)) {
			resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		else if (user != null && existingUser == null) {
			session.setAttribute("user", user);
			resp.setStatus(HttpServletResponse.SC_OK);
		}
	}
}
