package com.google.sps.servlets;
import java.util.ArrayList;

/** Represents a question. */
public final class Question {

  private final long id;
  private final String text;
  private final long timestamp;

  // Holds the resopnses
  private ArrayList<Long> responses;

  public Question(long id, String text, long time) {
    this.id = id;
    this.text = text;
    this.timestamp = time;
  }

  // Adds a response to the question
  public void addResponse(long responseID) {
    responses.add(responseID);
  }

  public long getID() {
      return id;
  }

  public String getText() {
      return text;
  }

  public long getTimestamp() {
      return timestamp;
  }
}
