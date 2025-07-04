package com.study.myspringmvc.servlet.web.frontcontroller.v4.controller;

import com.study.myspringmvc.servlet.domain.member.Member;
import com.study.myspringmvc.servlet.domain.member.MemberRepository;
import com.study.myspringmvc.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String username = paramMap.get("username");
        int age = Integer.parseInt("age");

        Member member = new Member(username, age);
        memberRepository.save(member);
        model.put("member", member);
        return "save-result";
    }
}
