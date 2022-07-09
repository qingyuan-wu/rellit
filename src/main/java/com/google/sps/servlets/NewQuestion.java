package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet responsible for creating new questions. */
@WebServlet("/new-question")
public class NewQuestion extends HttpServlet {

@Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String text = request.getParameter("question");
    long timestamp = System.currentTimeMillis();

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Question");
    FullEntity entity =
        Entity.newBuilder(keyFactory.newKey())
            .set("text", text)
            .set("time", timestamp)
            // Somehow need to get the following info here:
            .set("location", 0)
            .set("radius", 0)
            .set("user", 0)
            .build();
    datastore.put(entity);

    response.sendRedirect("https://summer22-sps-52.appspot.com");
  }
}
