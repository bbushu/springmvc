package org.example.springbootexam.controller;

import org.example.springbootexam.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class GetController {
    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    public String getHello() {
        return "hello world";
    }

    @GetMapping(value = "/name")
    public String getName() {
        return "Flature";
    }

    @GetMapping(value = "/memberId/{number}")
    public int variablePath(@PathVariable int number) {
        return number;
    }

    @GetMapping(value = "/memberName/{name}")
    public String StringVariable(@PathVariable("name") String n) {
        return n;
    }

    @GetMapping(value = "/request1")
    public String getRequest(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String level) {
        return name + " " + email + " " + level;
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(entry -> {
            sb.append(entry.getKey() + " : " + entry.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
