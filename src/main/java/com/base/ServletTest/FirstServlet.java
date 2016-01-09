package com.base.ServletTest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by liumin on 15/12/1.
 */

public class FirstServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("servlet初始化测试");
    }

/*    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet测试" + req.getHeader("host"));
        super.service(req, resp);
    }*/

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost" + req.getHeader("host"));
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet" + req.getHeader("host"));
        HttpSession session = req.getSession();
        if( session != null ) {
            System.out.println("SessionId:" + req.getSession().getId());
        }
    }

}
