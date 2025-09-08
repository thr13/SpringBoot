package com.boot.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * OS 환경 변수 값 읽기
 */
@Slf4j
class OsEnvTest {

    public static void main(String[] args) {
        Map<String, String> envMap = System.getenv();
        for (String key : envMap.keySet()) {
            log.info("env {}={}", key, System.getenv(key));
        }
    }
}