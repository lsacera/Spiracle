package com.waratek.spiracle.sql.servlet.mysql;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waratek.spiracle.sql.servlet.util.ParameterNullFix;
import com.waratek.spiracle.sql.util.SelectUtil;

/**
 * Servlet implementation class Implicit_Join_Namespace
 */

public class MySql_Implicit_Join_Namespace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySql_Implicit_Join_Namespace() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        executeRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        executeRequest(request, response);
	}

    private void executeRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {          
        ServletContext application = this.getServletConfig().getServletContext();
        List queryStringList = new ArrayList();
        queryStringList.add("id");
        
        Map nullSanitizedMap = ParameterNullFix.sanitizeNull(queryStringList, request);
        
        String id = (String)nullSanitizedMap.get("id");
        
        String sql = "SELECT * FROM test.users, test.address WHERE test.users.id = " + id + " AND test.users.id = test.address.id"; 

        Boolean showErrors = Boolean.TRUE;
        Boolean allResults = Boolean.TRUE;
        Boolean showOutput = Boolean.TRUE;

        SelectUtil.executeQuery(sql, application, request, response, showErrors, allResults, showOutput);
    }
}
