package top.lyunk.ddd.shop.common.util;

/**
 * 懒加载属性
 * @param <R> 懒加载属性返回值
 */
@SuppressWarnings({"unused", "AlibabaClassMustHaveAuthor"})
public abstract class LazyField<R> {
    private volatile R value;

    /**
     * 懒加载获取获取
     * @return 属性值
     */
    public R get(){
        if (this.value == null){
            synchronized (this){
                if (this.value == null){
                    this.value = doGet();
                }
            }
        }
        return this.value;
    }

    protected abstract R doGet();
}
