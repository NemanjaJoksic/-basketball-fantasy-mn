package org.joksin.bf.gameengine.security;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.async.publisher.Publishers;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.authentication.Authenticator;
import io.micronaut.security.token.validator.TokenValidator;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.net.http.HttpRequest;

@Slf4j
@Singleton
public class DefaultTokenValidator implements TokenValidator<HttpRequest> {

  private final Authenticator<HttpRequest> authenticator;

  public DefaultTokenValidator(Authenticator<HttpRequest> authenticator) {
      this.authenticator = authenticator;
      log.info("+++");
  }

  @Override
  public Publisher<Authentication> validateToken(String token, @Nullable HttpRequest request) {
    log.info("Validate token");

    var authenticationResponse = Flux.from(authenticator.authenticate(request, new Token(token)));

    return authenticationResponse.switchMap(
        response -> {
          if (response.isAuthenticated() && response.getAuthentication().isPresent()) {
            return Flux.just(response.getAuthentication().get());
          } else {
            return Publishers.empty();
          }
        });
  }
}
