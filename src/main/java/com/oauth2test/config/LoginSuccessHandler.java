package com.oauth2test.config;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken.TokenType;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.core.http.converter.OAuth2AccessTokenResponseHttpMessageConverter;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
  private final HttpMessageConverter<OAuth2AccessTokenResponse> accessTokenHttpResponseConverter = new OAuth2AccessTokenResponseHttpMessageConverter();

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException {
    // TODO: AUTH WITH GOOGLE PROVIDER
    if (authentication instanceof OAuth2AuthenticationToken) {
      if ("github".equals(((OAuth2AuthenticationToken) authentication).getAuthorizedClientRegistrationId())) {
        System.out.println("IT IS AUTHENTICANTING WITH GITHUB");
        DefaultOAuth2User oauhtUser = (DefaultOAuth2User) authentication.getPrincipal();
        Map<String, Object> userAttributes = oauhtUser.getAttributes();
        System.out.println("USER Logged with attributes:" + userAttributes.get("name"));
        System.out.println("USER Logged with attributes:" + userAttributes.get("email"));

      }
    }
    System.out.println("Logged user: " + authentication.getName());
    response.setHeader("token", "ASDASDASDASDASDAS");
    response.addHeader("token", "AASASDASDAS");
    response.containsHeader("header nameh");
    response.sendRedirect("http://localhost:5173");

    OAuth2AccessTokenResponse.Builder builder = OAuth2AccessTokenResponse.withToken("ADASDASDASDASJJ")
        .tokenType(TokenType.BEARER);

    OAuth2AccessTokenResponse accessTokenResponse = builder.build();
    ServletServerHttpResponse httpResponse = new ServletServerHttpResponse(response);
    this.accessTokenHttpResponseConverter.write(accessTokenResponse, null, httpResponse);

  }

}
