package test;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

@SuppressWarnings("serial")

public class MailSendServlet extends HttpServlet{
	 public void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
			  
			    Properties props = new Properties();
			  Session session = Session.getDefaultInstance(props, null);
			   try {
				   String val = req.getParameter("to");
			    Message msg = new MimeMessage(session);
			    msg.setFrom(new InternetAddress(val));
			    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(val));
			    ((MimeMessage)msg).setSubject("標題","UTF-8");
			    msg.setText("お買い上げありがとうございました");
			    Transport.send(msg);
			   } catch (MessagingException e) {
			    e.printStackTrace();
			   }
			   RequestDispatcher rd = req.getRequestDispatcher("/mailsend.jsp");
			     rd.forward(req, resp);
			 }
}
