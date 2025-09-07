package com.boot.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 설정 정보 대상을 동적으로 선택하는 인터페이스 ImportSelector 구현
 */
public class HelloImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.boot.selector.HelloConfig"};
    }
}
