package br.com.luciano.aulaspring.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teste")
public class TestResource {

    @GetMapping
    public String testRest(){
        return "Meu primeiro rest!";
    }
}
