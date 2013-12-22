package com.boroborome.dataexchange;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Com_boroborome_dataexchangeServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
