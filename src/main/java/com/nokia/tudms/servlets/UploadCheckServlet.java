package com.nokia.tudms.servlets;

import com.nokia.tudms.dao.ToolNameCheckDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

/**
 * Created by Administrator on 2017/6/25.
 */
@WebServlet(name="uploadCheckServlet",urlPatterns = "/UploadCheckServlet")
public class UploadCheckServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String toolName = request.getParameter("toolName");
        boolean flag = ToolNameCheckDAO.toolNameCheck(toolName);
        response.getWriter().print(flag);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException,IOException{
        doGet(request,response);
    }
}
