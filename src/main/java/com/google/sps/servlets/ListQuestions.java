package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import com.google.sps.servlets.NewQuestion;
import com.google.sps.servlets.Question;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet responsible for listing tasks. */
@WebServlet("/list-questions")
public class ListQuestions extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("Question").build();
    QueryResults<Entity> results = datastore.run(query);

    List<Question> questions = new ArrayList<>();
    while (results.hasNext()) {
      Entity entity = results.next();

      long id = entity.getKey().getId();
      String title = entity.getString("text");
      long timestamp = entity.getLong("timestamp");

      Question question = new Question(id, title, timestamp);
      questions.add(question);
    }

    Gson gson = new Gson();

    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(questions));
  }
}

