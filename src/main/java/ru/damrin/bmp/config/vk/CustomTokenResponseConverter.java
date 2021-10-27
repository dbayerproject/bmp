package ru.damrin.bmp.config.vk;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;

import java.util.HashMap;
import java.util.Map;

// необходим для авторизации в VK. замена accessTokenType=null на BEARER
public class CustomTokenResponseConverter implements Converter<Map<String, String>, OAuth2AccessTokenResponse> {
    @Override
    public OAuth2AccessTokenResponse convert(Map<String, String> tokenResponseParameters) {
        String accessToken = tokenResponseParameters.get(OAuth2ParameterNames.ACCESS_TOKEN);
        OAuth2AccessToken.TokenType accessTokenType = OAuth2AccessToken.TokenType.BEARER;
        Map<String, Object> additionalParameters = new HashMap<>(tokenResponseParameters);
        return OAuth2AccessTokenResponse.withToken(accessToken)
                .tokenType(accessTokenType)
                .additionalParameters(additionalParameters)
                .build();
    }
}