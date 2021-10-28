package com.botcamp.userside.Service;

import com.botcamp.userside.repository.RequestLogRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestLogService {
    private final RequestLogRepository requestLogRepository;


    public RequestLogService(RequestLogRepository requestLogRepository) {
        this.requestLogRepository = requestLogRepository;
    }

    public void test() {
        System.out.println(requestLogRepository.findAll());
    }
}
