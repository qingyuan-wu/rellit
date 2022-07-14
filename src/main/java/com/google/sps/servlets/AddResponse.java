package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Entity;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet responsible for adding a resopnse. */
@WebServlet("/add-response")
public class AddResponse extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    long id = Long.parseLong(request.getParameter("id"));

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Question");
    Key taskEntityKey = keyFactory.newKey(id);
    // Gets the current question's entity and info
    Entity curQuestion = datastore.get(taskEntityKey);
    long keyId = curQuestion.getKey().getId();
    String text = curQuestion.getString("text");
    long timestamp = curQuestion.getLong("time");

    Question question = new Question(keyId, text, timestamp);

  }
}
