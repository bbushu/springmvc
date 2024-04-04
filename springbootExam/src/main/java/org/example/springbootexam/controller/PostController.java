package org.example.springbootexam.controller;

import org.example.springbootexam.dto.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {

    @PostMapping(value = "/default")
    public String postMethod() {
        return "Hello World";
    }

    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> member) {
        StringBuilder sb = new StringBuilder();

        member.entrySet().forEach(entry -> {
            sb.append(entry.getKey() + " : " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    @PostMapping(value = "/member2")
    public String postMember2(MemberDTO memberDTO) {
        return memberDTO.toString();
    }

}
