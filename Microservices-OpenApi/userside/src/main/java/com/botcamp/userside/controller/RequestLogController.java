package com.botcamp.userside.controller;

import com.botcamp.userside.Service.RequestLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestLogController {
   private final RequestLogService requestLogService;

    public RequestLogController(RequestLogService requestLogService) {
        this.requestLogService = requestLogService;
    }

    @GetMapping("/test")
    public void test(){
        requestLogService.test();
    }
}
