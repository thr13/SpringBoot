package com.boot.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;
import java.util.Set;

/**
 * 커맨드라인: 전달하는 값은 형식이 없고, 단순히 띄어쓰기로 구분, 공백 연결시 "" 사용, --연결시 key=value 형식인 커맨드 라인 옵션 인수 지정
 * 스프링이 제공하는 ApplicationArguments 인터페이스, DefaultApplicationArguments 구현체 -> 커맨드 라인 옵션 인수를 규격대로 파싱
 */
@Slf4j
public class CommandLineV2 {

    public static void main(String[] args) {
        for (String arg : args) {
            log.info("arg {}", arg); //커맨드 라인의 입력 결과
        }

        ApplicationArguments appArgs = new DefaultApplicationArguments(args);
        log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs())); //커맨드 라인 인수들
        log.info("NonOptionArgs = {}", appArgs.getNonOptionArgs()); //커맨드 라인 옵션 인수가 아닌 것
        log.info("OptionNames = {}", appArgs.getOptionNames()); //커맨드 라인 옵션 인수

        Set<String> optionNames = appArgs.getOptionNames();
        for (String optionName : optionNames) {
            log.info("option args {}={}", optionName, appArgs.getOptionValues(optionName));
        }

        List<String> url = appArgs.getOptionValues("url");
        List<String> username = appArgs.getOptionValues("username");
        List<String> password = appArgs.getOptionValues("password");
        List<String> mode = appArgs.getOptionValues("mode");
        log.info("url={}", url);
        log.info("username={}", username);
        log.info("password={}", password);
        log.info("mode={}", mode);
    }
}
