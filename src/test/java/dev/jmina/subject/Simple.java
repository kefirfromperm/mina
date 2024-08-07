package dev.jmina.subject;

import org.slf4j.*;

import java.util.Arrays;

public class Simple {
    private final Logger log = LoggerFactory.getLogger(Simple.class);
    public static final Marker TEST_MARKER = MarkerFactory.getMarker("TEST");

    public static final Marker MARKER_1 = MarkerFactory.getMarker("MARKER_1");
    public static final Marker MARKER_2 = MarkerFactory.getMarker("MARKER_2");
    public static final Marker MARKER_3 = MarkerFactory.getMarker("MARKER_3");

    public void doSomething() {
        log.trace("Trace something");
        log.debug(TEST_MARKER, "Debug something");
        log.info("This is a {} log", 3);
        log.warn("Warn {}", "problem", new Exception("Test exception"));
        log.error("Test error", new RuntimeException("Test runtime exception"));
    }

    public void doSingleLog() {
        log.info("message");
    }

    public void doMultiArguments() {
        log.info("no arguments");

        log.info("{}", 1);
        log.error("no arguments", new RuntimeException("Test runtime exception 1"));

        log.info("{} {}", 2, "test 1");
        log.error("{}", 3, new RuntimeException("Test runtime exception 2"));

        log.info("{} {} {}", 4, "test 2", 'c');
        log.error("{} {}", 5, "test 3", new RuntimeException("Test runtime exception 3"));

        log.info("{} {} {} {}", 6, "test 6", 'a', 9.);
        log.error("{} {} {}", 7, "test 7", 'b', new RuntimeException("Test runtime exception 7"));

        log.info("{} {} {} {} {}", 8, "test 8", 'c', 'd', 23.56);
        log.error("{} {} {} {}", 9, "test 9", 'c', 'd', new RuntimeException("Test runtime exception 9"));

        log.info("{} {} {} {} {} {}", 10, "test 10", null, 'd', 23.56, "r");
        log.error("{} {} {} {} {}", 11, "test 11", null, 'd', 23.56, new RuntimeException("Test runtime exception 11"));
    }

    public void doConditions() {
        // Logger, level, marker
        log.debug(MARKER_1, "message 1 {}", 1);

        // Logger, marker, message
        log.debug(MARKER_2, "message 2 {}", 2);

        // Logger marker
        log.debug(MARKER_3, "message 3 {}", 3);

        // Logger, message
        log.debug("message 4 {}", 4);

        // Level, marker, message
        log.info(MARKER_1, "message 5 {}", 5);

        // Level, marker
        log.info(MARKER_2, "message 6 {}", 6);

        // Level message
        log.info("message 7 {}", 7);

        // Marker, message
        log.warn(MARKER_1, "message 8 {}", 8);

        // Just marker
        log.warn(TEST_MARKER, "message 9 {}", 9);

        // Just message
        log.warn("message 10 {}", 10);

        // Logger, level, message
        log.error("message 11 {}", 11);
    }

    public void doException() {
        try {
            throw new RuntimeException("Test exception");
        } catch (Exception e) {
            log.error("Test error (c) {} {} {}", "Vitalii", null, "Samolovskikh", e);
        }
    }

    public void doMdc() {
        MDC.put("key", "value");
        log.info("test MDC");
        MDC.remove("key");
    }

    public void doParallel() {
        Arrays.asList(1, 2, 3, 4, 5).parallelStream().forEach(value -> log.info("value {}", value));
    }
}
