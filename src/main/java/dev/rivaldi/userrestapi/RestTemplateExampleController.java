package dev.rivaldi.userrestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateExampleController {

    private final RestTemplate restTemplate;

    public RestTemplateExampleController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/anime")
    public RandomAnimeQuoteResponse callRandomAnimeQuote() {
        return restTemplate.getForEntity(
            "https://animechan.vercel.app/api/random",
            RandomAnimeQuoteResponse.class
        ).getBody();
    }
}
