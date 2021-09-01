package top.lyunk.ddd.shop.common.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Function;

public class Optional<T> {
    private static final Optional<?> EMPTY = new Optional<>(null);

    private final T value;

    private Optional(T value) {
        this.value = value;
    }

    /**
     * 允许传入一个可能为空的值，返回Optional实例
     * @param t 一个可能为空的值
     * @param <T> 值的类型
     * @return 如果值不为空，返回Optional
     */
    public static <T> Optional<T> ofNullable(T t){
        @SuppressWarnings("unchecked")
        Optional<T> empty = (Optional<T>) EMPTY;
        return t == null ? empty : new Optional<>(t);
    }
    /**
     * 如果值不是空的，那么就执行函数接口
     * 如果值是空的，那么就返回null
     * @param func 当值不为空，执行该函数接口
     * @param <E> 函数接口的返回值类型
     * @return 函数接口的返回值 或 null
     */
    public <E> E doIfPresent(@Nonnull Function<T, E> func){
        return doIfPresent(func, null);
    }

    /**
     * 如果值不是空的，那么就执行函数接口
     * 如果值是空的，那么就返回默认值
     * @param func 当值不为空，执行该函数接口
     * @param defaultVal 当值为空，返回默认值
     * @param <E> 函数接口的返回值类型与默认值类型
     * @return 函数接口的返回值/默认值
     */
    public <E> E doIfPresent(@Nonnull Function<T, E> func, @Nullable E defaultVal){
        Objects.requireNonNull(func);
        if (this.value == null){
            return defaultVal;
        }
        return func.apply(this.value);
    }


}
