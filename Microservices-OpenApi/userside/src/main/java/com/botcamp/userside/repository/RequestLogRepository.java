package com.botcamp.userside.repository;

import com.botcamp.userside.model.RequestLog;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface RequestLogRepository extends JpaRepository<RequestLog, Long> {
}
