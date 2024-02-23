package org.joksin.bf.gameengine.security;

import io.micronaut.context.annotation.Requires;
import io.micronaut.core.async.publisher.Publishers;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.filters.AuthenticationFetcher;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;

@Slf4j
@Singleton
@Requires(missingBeans = {MyCookieAuthenticationFetcher.class})
public class MockedUserAuthenticationFetcher implements AuthenticationFetcher<HttpRequest<Object>> {

  public MockedUserAuthenticationFetcher() {
    log.info("MockedUserAuthenticationFetcher created");
  }

  @Override
  public Publisher<Authentication> fetchAuthentication(HttpRequest<Object> request) {
    log.info("Injecting mocked user [username: TEST_USER]");
    return Publishers.just(Authentication.build("TEST_USER"));
  }
}
