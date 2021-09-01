package top.lyunk.ddd.shop.common.web;

import lombok.Getter;

@Getter
public class Result<D> {
    /** 结果码 */
    private final int code;
    /** 数据 */
    private final D data;
    /** 信息 */
    private final String msg;

    public Result(int code, D data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
