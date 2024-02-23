package org.joksin.bf.gameengine.security;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.provider.HttpRequestAuthenticationProvider;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class MockedUserAuthenticationProvider<B> implements HttpRequestAuthenticationProvider<B> {

  @Override
  public @NonNull AuthenticationResponse authenticate(
      @Nullable HttpRequest<B> requestContext,
      @NonNull AuthenticationRequest<String, String> authRequest) {
    log.info("Injecting mocked user");
    return AuthenticationResponse.success("TEST_USER");
  }
}
