package com.pickme.beeze.login.service;

import com.pickme.beeze.login.dao.SnsLoginDao;
import com.pickme.beeze.login.dto.SnsLoginDto;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Objects;

@Service
public class SnsLoginService {

    private final SnsLoginDao dao;
    private final Environment env;
    private final RestTemplate restTemplate = new RestTemplate();
    
    public SnsLoginService(Environment env, SnsLoginDao dao) {
        this.env = env;
        this.dao = dao;
    }

    /**
     * 
     * @param code
     * @param registrationId
     * @return SnsLoginDto
     * 받은 code 토큰을 발급받아서
     * 토큰으로 로그인 정보에 접근해서 로그인 정보를 JSON으로 받은 후
     * 그 값을 알맞게 사용하는 곳.
     */
    public SnsLoginDto socialLogin(String code, String registrationId) {
//        System.out.println("code = " + code);
//        System.out.println("registrationId = " + registrationId);

        String accessToken = getAccessToken(code, registrationId);
//        System.out.println("accessToken = " + accessToken);

        JsonNode userResourceNode = getUserResource(accessToken, registrationId);
//        System.out.println("userResourceNode = " + userResourceNode);

        SnsLoginDto snsLogin = null;
        String id = "";
        String email = "";
        String name = "";
        switch (registrationId) {
            case "google" -> {
                System.out.println("구글 로그인");

                id = userResourceNode.get("id").asText();
                email = userResourceNode.get("email").asText();
                name = userResourceNode.get("name").asText();
                
//                System.out.println("id = " + id);
//                System.out.println("email = " + email);
//                System.out.println("name = " + name);

                snsLogin = new SnsLoginDto(id, email, name, "google");

                int findGoogleId = dao.findBySnsId(snsLogin);
                if (findGoogleId == 0) {
//                    System.out.println("사용된 구글 계정 엄슴");
                    dao.insertSnsId(snsLogin);
                }
            }
            case "kakao" -> {
                System.out.println("카카오 로그인");

                id = userResourceNode.get("id").asText();
                email = userResourceNode.get("kakao_account").get("email").asText();
                name = userResourceNode.get("kakao_account").get("profile").get("nickname").asText();
                
//                System.out.println("id = " + id);
//                System.out.println("email = " + email);
//                System.out.println("name = " + name);
                snsLogin = new SnsLoginDto(id, email, name, "kakao");

                int findGoogleId = dao.findBySnsId(snsLogin);
                if (findGoogleId == 0) {
//                    System.out.println("사용된 카카오 계정 엄슴");
                    dao.insertSnsId(snsLogin);
                } 
            }
            case "naver" -> {
                System.out.println("네이버 로그인");

                id = userResourceNode.get("response").get("id").asText();
                email = userResourceNode.get("response").get("email").asText();
                name = userResourceNode.get("response").get("name").asText();
                
//                System.out.println("id = " + id);
//                System.out.println("email = " + email);
//                System.out.println("name = " + name);

                snsLogin = new SnsLoginDto(id, email, name, "naver");

                int findGoogleId = dao.findBySnsId(snsLogin);
                if (findGoogleId == 0) {
//                    System.out.println("사용된 네이버 계정 엄슴.");
                    dao.insertSnsId(snsLogin);
                } 
            }
        }
        return snsLogin;
    }

    /**
     * @param authorizationCode
     * @param registrationId
     * @return String
     * 받은 코드와 구분한 플랫폼으로 해당 플랫폼에게 토큰을 내놓으라고 협박한다.
     * 나도 보고 대충 가져와서 쓴거고 다른건 다 똑같이 가져다 사용하면 되는데
     * oauth2." + registrationId + ".client-id 이부분이 각 플랫폼에 요청 날릴 값들을 만들어주는 곳인데
     * 어플리케이션 프로퍼티에 따로 지정해 둔 부분이니까 이부분만 조심하자.
     * 나머지는 이해 안가도 대충 값들을 만들어서 restTemplate으로 날려서 응답 된 값이 토큰이라고 알면 되겠다.
     * restTemplate이건 스프링꺼니까 궁금하면 검색 
     */
    private String getAccessToken(String authorizationCode, String registrationId) {
        String clientId = env.getProperty("oauth2." + registrationId + ".client-id");
        String clientSecret = env.getProperty("oauth2." + registrationId + ".client-secret");
        String redirectUri = env.getProperty("oauth2." + registrationId + ".redirect-uri");
        String tokenUri = env.getProperty("oauth2." + registrationId + ".token-uri");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", authorizationCode);
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", redirectUri);
        params.add("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity entity = new HttpEntity(params, headers);

        ResponseEntity<JsonNode> responseNode = restTemplate.exchange(Objects.requireNonNull(tokenUri), HttpMethod.POST, entity, JsonNode.class);
        JsonNode accessTokenNode = responseNode.getBody();
        return Objects.requireNonNull(accessTokenNode).get("access_token").asText();
    }

    /**
     * 
     * @param accessToken
     * @param registrationId
     * @return JsonNode
     * 위에서 만든 토큰하고 플랫폼을 날려서 우리가 필요한 로그인 정보들을 받는 곳이다.
     * 이곳에서 메일 이름 아이디등등을 받아준다. 
     * restTemplate은 JSON, XML, String 등으로 받을 수 있다. 토큰은 String으로 받았고 로그인 정보들은 json
     */
    private JsonNode getUserResource(String accessToken, String registrationId) {
        String resourceUri = env.getProperty("oauth2." + registrationId + ".resource-uri");
       
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity entity = new HttpEntity(headers);
        return restTemplate.exchange(Objects.requireNonNull(resourceUri), HttpMethod.GET, entity, JsonNode.class).getBody();
    }
}