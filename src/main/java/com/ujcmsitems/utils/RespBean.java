package com.ujcmsitems.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共的返回对象
 * @author 谷科阳
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {

    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回结果
     * @param message
     * @return
     */
    public static  RespBean success(String message){
        return new RespBean(200,message,null);
    }
    /**
     * 成功返回结果
     * @param message
     * @param obj
     * @return
     */
    public static  RespBean success(String message,Object obj){
        return new RespBean(200,message,obj);
    }


    /**
     * 失败返回结果
     * @param message
     * @return
     */

    public static RespBean error(String message){
        return new RespBean(500,message,null);
    }

    /**
     * 失败返回结果
     * @param message
     * @param obj
     * @return
     */
    public static RespBean error(String message,Object obj){
        return new RespBean(500,message,obj);
    }


    public long getCode() {
        return code;
    }

    public RespBean setCode(long code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RespBean setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public RespBean setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}
