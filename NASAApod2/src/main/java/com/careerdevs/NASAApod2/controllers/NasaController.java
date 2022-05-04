package com.careerdevs.NASAApod2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/nasa")
public class NasaController {

    @Autowired
    private Environment env;

    private String myNasaKey = "NASA_API_KEY";
    private String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=";

    @GetMapping("/apod")
    public Object apodHandler (RestTemplate restTemplate) {
        String url = nasaApodEndpoint + env.getProperty(myNasaKey);
        return restTemplate.getForObject(url, Object.class);
    }


}
