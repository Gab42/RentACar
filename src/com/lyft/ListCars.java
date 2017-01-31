package com.lyft;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

@Path("/carlist")
public class ListCars {
	@GET
	//@Produces("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String dbtest() throws Exception{
		// Open a connection to the database
		DB.openCon();
		
		// Query the database for accounts
		JSONArray jsonArray = DB.query("SELECT * FROM accounts");	

		// Close connection
		DB.closeCon();

		return jsonArray.toString();
	}
	
	public String test() {
		String result = "test";
		return result;
	}
	
	
}
