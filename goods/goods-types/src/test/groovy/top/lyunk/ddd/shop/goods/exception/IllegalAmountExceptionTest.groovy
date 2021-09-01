package top.lyunk.ddd.shop.goods.exception

import spock.lang.Specification

class IllegalAmountExceptionTest extends Specification {
    def "金额信息正确性检查"() {
        when:
        def err = IllegalAmountException.ofAmount(new BigDecimal(amout))

        then:
        err.getMessage() == msg;

        where:
        amout    || msg
        "10"     || "不合法的金额:[10]"
        "11.11"  || "不合法的金额:[11.11]"
        "-10"    || "不合法的金额:[-10]"
        "-10.11" || "不合法的金额:[-10.11]"
        "0"      || "不合法的金额:[0]"
    }

    def "精度信息正确性检查"() {
        when:
        def err = IllegalAmountException.ofScale(amout)

        then:
        err.getMessage() == msg;

        where:
        amout || msg
        10    || "不合法的金额精度:[10]"
        -10   || "不合法的金额精度:[-10]"
        0     || "不合法的金额精度:[0]"
    }
}
