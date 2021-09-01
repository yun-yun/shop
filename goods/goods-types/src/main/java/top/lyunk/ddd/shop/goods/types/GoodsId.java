package top.lyunk.ddd.shop.goods.types;

import java.util.Objects;

public final class GoodsId {
    private final Long value;

    public GoodsId(Long value) {
        this.value = value;
    }

    public Long value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (GoodsId) obj;
        return Objects.equals(this.value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "GoodsId[" +
                "value=" + value + ']';
    }


}
