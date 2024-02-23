package org.joksin.bf.gameengine.security;

import io.micronaut.context.BeanContext;
import io.micronaut.inject.qualifiers.Qualifiers;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.filters.AuthenticationFetcher;
import lombok.AllArgsConstructor;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.ExecutorService;

@AllArgsConstructor
public abstract class ImperativeAuthenticationFetcher<T> implements AuthenticationFetcher<T> {

  private final BeanContext beanContext;

  @Override
  public Publisher<Authentication> fetchAuthentication(T request) {
    var authentication = Mono.fromCallable(() -> fetchAuthenticationImperative(request));
    return authentication.subscribeOn(getScheduler());
  }

  private Scheduler getScheduler() {
    return beanContext
        .findBean(ExecutorService.class, Qualifiers.byName(getExecutorName()))
        .map(Schedulers::fromExecutor)
        .orElseThrow();
  }

  protected abstract String getExecutorName();

  protected abstract Authentication fetchAuthenticationImperative(T request);
}
