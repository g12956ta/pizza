package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


public class LoginServlet  extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {  
        UserService userService = UserServiceFactory.getUserService();

        String thisURL = req.getRequestURI();
        //req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        if (req.getUserPrincipal() != null) {
            resp.getWriter().println("<p>Welcome!<br>このアカウントでログインしています。 <br> " +
                                     req.getUserPrincipal().getName() +
                                     "!  <br>違うアカウントがよければサインアウトしてください。 <a href=\"" +
                                     userService.createLogoutURL(thisURL) +
                                     "\">sign out</a>.</p>");
            PrintWriter out = resp.getWriter();
            //String url = "/index.html";
            String eURL = resp.encodeURL("/index.html");
            out.println("<a href=\""+eURL+"\">買い物ページ</a>");

        } else {
            resp.getWriter().println("<p>Please <a href=\"" +
                                     userService.createLoginURL(thisURL) +
                                     "\">sign in</a></p>");
        }
    }
	/*public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain;charset=UTF-8");
 
        //ユーザーサービスの取得
        UserService us = UserServiceFactory.getUserService();
        User user = us.getCurrentUser();
 
        if( us.isUserLoggedIn() == false ){
            resp.getWriter().println("ログインしていません");
            String url = us.createLoginURL("/userauth");
            resp.getWriter().println("<a herf ='"+ url + "'>ログイン</a>");
        }else{
            resp.getWriter().println("ログイン状態です");
            resp.getWriter().println("認証ドメイン:" + user.getAuthDomain());
            resp.getWriter().println("ニックネーム:" + user.getNickname());
            resp.getWriter().println("ユーザID    :" + user.getUserId());
            resp.getWriter().println("Eメール     :" + user.getEmail());
        }
    }*/
}
