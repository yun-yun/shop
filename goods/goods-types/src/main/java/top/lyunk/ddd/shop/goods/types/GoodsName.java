package top.lyunk.ddd.shop.goods.types;

import java.util.Objects;

public final class GoodsName {
    private final String value;

    public GoodsName(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (GoodsName) obj;
        return Objects.equals(this.value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "GoodsName[" +
                "value=" + value + ']';
    }


}
