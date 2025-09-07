package com.boot.selector;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

public class ImportSelectorTest {

    @DisplayName("정적 설정 정보 추가 테스트")
    @Test
    void staticConfig() {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(StaticConfig.class);
        HelloBean bean = appContext.getBean(HelloBean.class);

        assertThat(bean).isNotNull();
    }

    @DisplayName("동적 설정 정보 추가 테스트")
    @Test
    void selectorConfig() {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SelectorConfig.class);
        HelloBean bean = appContext.getBean(HelloBean.class);

        assertThat(bean).isNotNull();
    }

    /**
     * 정적 설정 정보 추가 - @Import 사용
     */
    @Configuration
    @Import(HelloConfig.class)
    public static class StaticConfig {
    }

    /**
     * 동적 설정 정보 추가 - ImportSelector 인터페이스를 구현체를 @Import 사용
     */
    @Configuration
    @Import(HelloImportSelector.class)
    public static class SelectorConfig {
    }

}
