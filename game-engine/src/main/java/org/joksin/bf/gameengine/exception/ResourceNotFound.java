package org.joksin.bf.gameengine.exception;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;

public class ResourceNotFound extends HttpStatusException {

  public ResourceNotFound(String resourceType, long id) {
    super(HttpStatus.NOT_FOUND, String.format("%s with ID %s does not exist", resourceType, id));
  }
}
