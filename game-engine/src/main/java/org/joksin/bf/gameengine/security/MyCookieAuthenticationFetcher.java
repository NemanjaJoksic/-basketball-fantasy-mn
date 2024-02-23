package org.joksin.bf.gameengine.security;

import io.micronaut.context.BeanContext;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.security.authentication.Authentication;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@Requires(property = "app.security.my-cookie.enabled", value = "true", defaultValue = "false")
public class MyCookieAuthenticationFetcher
    extends ImperativeAuthenticationFetcher<HttpRequest<Object>> {

  public MyCookieAuthenticationFetcher(BeanContext beanContext) {
    super(beanContext);
    log.info("MyCookieAuthenticationFetcher created");
  }

  @Override
  protected String getExecutorName() {
    return TaskExecutors.BLOCKING;
  }

  @Override
  protected Authentication fetchAuthenticationImperative(HttpRequest request) {
    log.info("Validate cookie");
    return Authentication.build("TEST_USER");
  }
}
