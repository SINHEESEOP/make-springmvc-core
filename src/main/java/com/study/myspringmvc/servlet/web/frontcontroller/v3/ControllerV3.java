package com.study.myspringmvc.servlet.web.frontcontroller.v3;

import com.study.myspringmvc.servlet.web.frontcontroller.ModelView;
import com.study.myspringmvc.servlet.web.frontcontroller.MyView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);

}
