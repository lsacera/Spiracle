package com.waratek.spiracle.xss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class XSSWebAppSRPWDelay extends HttpServlet {


    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ReadHTML.readHTML(out, req.getParameter("taintedtext"), req);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
