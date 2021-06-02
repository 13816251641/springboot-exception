package com.lujieni.exception.controller;

import com.lujieni.exception.entity.Student;
import com.lujieni.exception.entity.dto.ResponseDTO;
import com.lujieni.exception.exception.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Package: com.lujieni.exception.controller
 * @ClassName: HelloController
 * @Author: lujieni
 * @Description: hello
 * @Date: 2021-01-05 14:13
 * @Version: 1.0
 */
@RestController
public class HelloController extends BasicController  {

    @PostMapping("/hello")
    public ResponseDTO hello(@RequestBody @Valid Student student){
        return null;
    }


}