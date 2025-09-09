package com.boot.datasource;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.List;

/**
 * application.properties 에 설정한 변수를 담을 객체
 */
@Slf4j
public class MyDataSource {

    private String url;
    private String username;
    private String password;
    private int maxConnection;
    private Duration timeout;
    private List<String> options;

    public MyDataSource(String url, String username, String password, int maxConnection, Duration timeout, List<String> options) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.maxConnection = maxConnection;
        this.timeout = timeout;
        this.options = options;
    }

    @PostConstruct
    public void init() {
        log.info("url={}", url); //접속 URL
        log.info("username={}", username); //이름
        log.info("password={}", password); //비밀번호
        log.info("maxConnection={}", maxConnection); //최대 연결 수
        log.info("timeout={}", timeout); //응답 지연 타임아웃
        log.info("options={}", options); //연결시 사용하는 기타 옵션들

    }
}
