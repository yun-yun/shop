package top.lyunk.ddd.shop.goods.types;

import java.util.Objects;

public final class Currency {
    private final String value;

    public Currency(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("货币单位不能为空");
        }
        this.value = value;
    }

    public String value() {
        return value;
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
