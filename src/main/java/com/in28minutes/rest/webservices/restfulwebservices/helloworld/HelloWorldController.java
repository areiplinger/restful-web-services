package com.in28minutes.rest.webservices.restfulwebservices.helloworld;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;



@RestController
public class HelloWorldController {

    // Get
    // URI /hello-world
    // Method -> "Hello World"

    @Autowired
    private MessageSource messageSource;

    //@RequestMapping(method = RequestMethod.GET, path="/hello-world")
    @GetMapping(path="/hello-world")
    public String HelloWorld(){
        return "Hello World";
    }

    //hello-world-bean
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    //hello-world-bean
    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVar(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping(path="/hello-world-internationalized")
    public String HelloWorldInt(){
        return messageSource.getMessage("good.morning.message",
                null,LocaleContextHolder.getLocale());
    }

}

