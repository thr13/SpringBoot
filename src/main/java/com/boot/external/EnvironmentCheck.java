package com.boot.external;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 커맨드 라인 옵션 인수, 자바 시스템 속성 모두 스프링이 제공하는 Environment 를 통해 읽을 수 있다
 */
@Slf4j
@Component
public class EnvironmentCheck {

    private final Environment env;

    public EnvironmentCheck(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void init() {
        String url = env.getProperty("url");
        String username = env.getProperty("username");
        String password = env.getProperty("password");

        log.info("env url={}", url);
        log.info("env username={}", username);
        log.info("env password={}", password);
    }
}
