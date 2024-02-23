package org.joksin.bf.gameengine.security;

import io.micronaut.core.async.publisher.Publishers;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.filters.AuthenticationFetcher;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;

@Slf4j
//@Singleton
public class MockedUsedAuthenticationFetcher implements AuthenticationFetcher<HttpRequest<Object>> {

  @Override
  public Publisher<Authentication> fetchAuthentication(HttpRequest<Object> request) {
    log.info("Injecting mocked user");
    return Publishers.just(Authentication.build("TEST_USER"));
  }
}
