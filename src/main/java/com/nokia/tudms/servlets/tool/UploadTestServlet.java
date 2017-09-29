package com.nokia.tudms.servlets.tool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "UploadTestServlet",urlPatterns = {"/upload"})
//下面的注解中location的值为上传的文件的临时存放位置
@MultipartConfig(location = "D://uploadtest")
public class UploadTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("uploaderName"));

        Part part=request.getPart("file"); //通过表单中的name属性获取表单域中的文件
        part.write("D://uploadtest//aaa.txt"); //将文件移动到特定的磁盘路径

        String fname=part.getSubmittedFileName();
        System.out.println("文件名："+fname);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}