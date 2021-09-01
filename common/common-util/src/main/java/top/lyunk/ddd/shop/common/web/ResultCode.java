package top.lyunk.ddd.shop.common.web;

public enum ResultCode {
    SUCCESS(200, "SUCCESS");

    int code;
    String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据name找到对应的ResultCode
     * @param name ResultCode的某个枚举类名称
     * @return ResultCode
     */
    public static ResultCode of(String name){
        ResultCode[] values = ResultCode.values();
        for (ResultCode value : values) {
            if (value.name().equals(name)) {
                return value;
            }
        }
        return null;
    }

    public <D> Result<D> of(D data){
        return new Result<>(this.code, data, this.msg);
    }
}
