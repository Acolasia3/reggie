package tao.reggie.common;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据统一封装。通用返回结果，服务端响应的数据最终都会封装成此对象（通用结果类）
 * @param <T>
 */
@Data
public class R<T> implements Serializable{
    //code: 实际上就是和前端约定好的状态码。
    private Integer code; //编码：1成功，0和其它数字为失败
    
    //msg:错误信息，在使用error函数中常常设置错误信息返回给前端
    private String msg; //错误信息
    
    //data:访问成功时，返回的数据信息。使用了泛型可以根据不同情况，返回不同类型的数据。
    private T data; //数据
    
    //动态向结果集中填充一些额外的数据
    private Map map = new HashMap(); //动态数据
    
    //R.success(返回的数据对象) 即可返回携带返回数据 设置好状态码的R对象。
    //通过springMVC中的@ResponseBody注解将返回的R对象转化为json类型数据
    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    //R.error(返回的错误信息) 即可返回携带提示信息 设置好状态码的R对象。
    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }
    //add():用于向结果集中添加额外的动态信息。
    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
