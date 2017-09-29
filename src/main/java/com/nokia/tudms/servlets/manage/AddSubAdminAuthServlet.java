package com.nokia.tudms.servlets.manage;

import com.nokia.tudms.beans.LoggedUser;
import com.nokia.tudms.dao.admin.SubAdminManagementDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Rin
 * @Date 2017/5/4
 */
@WebServlet(name = "AddSubAdminAuthServlet",urlPatterns = {"/api/add_sub_admin_auth"})
public class AddSubAdminAuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoggedUser loggedUser = (LoggedUser)request.getAttribute("loggedUserBean");
        if(loggedUser!=null&&loggedUser.getUserLevel()==2) {
            int targetUid=Integer.parseInt(request.getParameter("uid"));
            int categoryId=Integer.parseInt(request.getParameter("category"));

            SubAdminManagementDAO.setSubAdmin(targetUid,categoryId);

            String lastPage = request.getHeader("Referer");
            if(lastPage!=null)
                response.sendRedirect(lastPage);
            else
                response.sendRedirect("/");
        }else{
            response.sendRedirect("/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
