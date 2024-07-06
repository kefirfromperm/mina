package mina.core;

@FunctionalInterface
public interface MinaArgumentVerification extends MinaVerification {
    @Override
    default void verify(int index, Object[] arguments, Throwable throwable) {
        verify(arguments);
    }

    void verify(Object[] arguments);
}
