package mina.core;

@FunctionalInterface
public interface MinaSingleArgumentCheck<T> extends MinaCheck {
    void verify(T argument);

    @Override
    @SuppressWarnings("unchecked")
    default void verify(int index, Object[] arguments, Throwable throwable) {
        if (arguments != null && arguments.length >= 1) {
            verify((T) arguments[0]);
        } else {
            if (throwable != null) {
                verify((T) throwable);
            } else {
                throw new AssertionError(
                        "Call #" + index + ": The verification awaits at least one argument or a throwable but found 0 arguments and no throwable."
                );
            }
        }
    }
}
