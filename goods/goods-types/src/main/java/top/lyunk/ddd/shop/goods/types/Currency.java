package top.lyunk.ddd.shop.goods.types;

import java.util.Objects;

/**
 * 货币
 */
public record Currency(String value) {

    public Currency {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("货币单位不能为空");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Currency) obj;
        return Objects.equals(this.value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Currency[" +
                "value=" + value + ']';
    }

}
