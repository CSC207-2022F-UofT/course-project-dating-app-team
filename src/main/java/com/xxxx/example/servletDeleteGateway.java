package com.xxxx.example;

import database_connection.Database;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteGateway")
public class servletDeleteGateway extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database myDatabase = new Database("", "DatingAppStaging");
        String Username = req.getParameter("username");
        String delete_id = req.getParameter("id");
        String status;

        Document post_sender = myDatabase.find_post_by_id(delete_id);

        String sender = post_sender.getString("user_nickname");
        if(sender.equals(Username)){
            status = "success";
            myDatabase.delete_post_by_id(delete_id);
        }
        else {
            status = "fail";
        }
        req.setAttribute("status",status);
        req.getRequestDispatcher("/deleteResponse").forward(req,resp);
    }
}
