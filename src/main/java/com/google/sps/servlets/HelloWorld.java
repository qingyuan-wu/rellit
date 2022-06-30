package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/* Handles requests sent to the /hello endpoint. */
@WebServlet("/hello")
public class HelloWorld extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> facts = new ArrayList<String>();
    facts.add("fact 1");
    facts.add("fact 2");
    facts.add("fact 3");

    String json = convertToJsonUsingGson(facts);

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

    /**
     * Converts a ServerStats instance into a JSON string using the Gson library. Note: We first added
     * the Gson library dependency to pom.xml.
     */
    private String convertToJsonUsingGson(ArrayList<String> array) {
        Gson gson = new Gson();
        String json = gson.toJson(array);
        return json;
    }
}
