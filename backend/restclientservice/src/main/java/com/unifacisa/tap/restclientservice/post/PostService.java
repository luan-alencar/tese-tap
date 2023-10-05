package com.unifacisa.tap.restclientservice.post;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

import static com.unifacisa.tap.restclientservice.utils.ConstantsUtils.BASE_URL_JSON;

@Service
@RequiredArgsConstructor
public class PostService {

    private final RestClient restClient;

    public PostService() {
        this.restClient = RestClient.builder()
                .baseUrl(BASE_URL_JSON)
                .build();
    }

    public List<Post> findAll() {
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});
    }
}
