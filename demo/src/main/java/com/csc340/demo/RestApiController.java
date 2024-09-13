package com.csc340.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RestApiController {

    /**
     * Get a random cat fact from the Cat Facts API
     *
     * @return CatFact object
     */
    @GetMapping("/catfact")
    public CatFact getCatFact() {
        try {
            System.out.println("Making request to Cat Facts API...");
            String url = "https://catfact.ninja/fact";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();
            String jsonResponse = restTemplate.getForObject(url, String.class);
            System.out.println("Response received from API: " + jsonResponse);
            JsonNode root = mapper.readTree(jsonResponse);

            String fact = root.get("fact").asText();
            return new CatFact(fact);
        } catch (Exception ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Get a random programming joke from JokeAPI
     *
     * @return Joke object
     */
    @GetMapping("/joke")
    public Joke getJoke() {
        try {
            System.out.println("Making request to JokeAPI...");
            String url = "https://v2.jokeapi.dev/joke/Programming?type=single";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();
            String jsonResponse = restTemplate.getForObject(url, String.class);
            System.out.println("Response received from API: " + jsonResponse);
            JsonNode root = mapper.readTree(jsonResponse);

            String joke = root.get("joke").asText();
            return new Joke(joke);
        } catch (Exception ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
