package mina.core;

import mina.context.MinaContextHolder;
import org.slf4j.Marker;
import org.slf4j.event.Level;


public final class Mina {
    private Mina() {
    }

    public static void useGlobalContext() {
        MinaContextHolder.useGlobalContext();
    }

    public static void useThreadLocalContext() {
        MinaContextHolder.assertParallelAccessToGlobalContext();
        MinaContextHolder.useThreadLocalContext();
    }

    public static ConditionStep on(
            String loggerName,
            Level level,
            Marker marker,
            String messagePattern
    ) {
        MinaContextHolder.assertParallelAccessToGlobalContext();
        return new ConditionStep(
                MinaContextHolder.getContext(),
                new Condition(loggerName, level, marker, messagePattern)
        );
    }

    public static ConditionStep on(
            Class<?> loggerClass,
            Level level,
            Marker marker,
            String messagePattern
    ) {
        return on(
                loggerClass != null ? loggerClass.getName() : null,
                level, marker, messagePattern
        );
    }

    public static ConditionStep on(
            Class<?> loggerClass,
            Level level,
            Marker marker
    ) {
        return on(loggerClass, level, marker, null);
    }

    public static ConditionStep on(
            Class<?> loggerClass,
            Level level,
            String messagePattern
    ) {
        return on(loggerClass, level, null, messagePattern);
    }

    public static ConditionStep on(
            Class<?> loggerClass,
            Level level
    ) {
        return on(loggerClass, level, null, null);
    }

    public static ConditionStep on(
            Class<?> loggerClass,
            Marker marker,
            String messagePattern
    ) {
        return on(
                loggerClass, null, marker, messagePattern
        );
    }

    public static ConditionStep on(
            Class<?> loggerClass,
            Marker marker
    ) {
        return on(loggerClass, null, marker, null);
    }

    public static ConditionStep on(
            Class<?> loggerClass,
            String messagePattern
    ) {
        return on(loggerClass, null, null, messagePattern);
    }

    public static ConditionStep on(
            Class<?> loggerClass
    ) {
        return on(loggerClass, null, null, null);
    }

    public static ConditionStep on(
            Level level,
            Marker marker,
            String messagePattern
    ) {
        return on((String) null, level, marker, messagePattern);
    }

    public static ConditionStep on(
            Level level,
            Marker marker
    ) {
        return on((String) null, level, marker, null);
    }

    public static ConditionStep on(
            Level level,
            String messagePattern
    ) {
        return on((String) null, level, null, messagePattern);
    }

    public static ConditionStep on(
            Level level
    ) {
        return on((String) null, level, null, null);
    }

    public static ConditionStep on(
            Marker marker,
            String messagePattern
    ) {
        return on((String) null, null, marker, messagePattern);
    }

    public static ConditionStep on(
            Marker marker
    ) {
        return on((String) null, null, marker, null);
    }

    public static ConditionStep on(
            String messagePattern
    ) {
        return on((String) null, null, null, messagePattern);
    }

    public static ConditionStep on() {
        return on((String) null, null, null, null);
    }

    public static void assertAllCalled() {
        MinaContextHolder.getContext().verifyLost();
    }

    public static void clean() {
        MinaContextHolder.removeContext();
    }
}
