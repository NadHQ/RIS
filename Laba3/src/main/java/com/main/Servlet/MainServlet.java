package com.main.Servlet;

import com.main.Container.MainContainer;
import com.main.Service.IMainService;
import com.main.Service.MainEntityDuplicate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("search");
        System.out.println("point1");
        if (!id.isEmpty()) {
            System.out.println("point4");
            IMainService iMainService = MainContainer.getInstance().createService();
            System.out.println("point3");
            try {
                MainEntityDuplicate mainEntityDuplicate = iMainService.findByID(Integer.parseInt(id));
                System.out.println("point2");
                if (mainEntityDuplicate != null) {
                    req.setAttribute("id", id);
                    req.setAttribute("name", mainEntityDuplicate.getFio());
                    req.setAttribute("phnumber", mainEntityDuplicate.getPhnumber());
                    req.setAttribute("fnumber", mainEntityDuplicate.getFnumber());
                }
            } catch (Exception exception) {
            }
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
