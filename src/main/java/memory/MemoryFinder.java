package memory;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

/**
 * JVM 메모리 정보 실시간 조회
 */
@Slf4j
public class MemoryFinder {

    public Memory get() {
        long max = Runtime.getRuntime().maxMemory(); //JVM 이 사용할 수 있는 최대 메모리
        long total = Runtime.getRuntime().totalMemory(); //JVM 이 확보한 전체 메모리
        long free = Runtime.getRuntime().freeMemory(); //JVM 이 확보한 전체 메모리 중에 사용하지 않은 메모리
        long used = total - free; //JVM 이 사용중인 메모리

        return new Memory(used, max);
    }

    @PostConstruct
    public void init() {
        log.info("init memoryFinder");
    }
}
