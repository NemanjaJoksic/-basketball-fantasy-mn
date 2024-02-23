package org.joksin.bf.gameengine.security;

import io.micronaut.security.authentication.AuthenticationRequest;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class Token implements Serializable, AuthenticationRequest<String, String> {

  private final String token;

  @Override
  public String getIdentity() {
    return token;
  }

  @Override
  public String getSecret() {
    return null;
  }
}
