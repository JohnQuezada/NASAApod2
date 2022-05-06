package com.careerdevs.NASAApod2.controllers;


import com.careerdevs.NASAApod2.models.ApodModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/getApodByDate/{date}")
    public ApodModel getApodByDate(RestTemplate restTemplate, @PathVariable String date) {
        String url = nasaApodEndpoint + env.getProperty(myNasaKey) + "&date=" + date;
        return restTemplate.getForObject(url, ApodModel.class);
    }

    @GetMapping("/getApodByCount/")
    public Object apodCountByRequestParam (RestTemplate restTemplate, @RequestParam int count) {
        String url = nasaApodEndpoint + env.getProperty(myNasaKey) + "&count=" + count;
        return restTemplate.getForObject(url, Object.class);
    }

}
