package com.nuzoul.mall.common.service;

/**
 * @Author: nuzoul
 * @Date: 2019/2/9 18:36
 */
public interface RespMsg {

    String SELECT_SUCCESS = "查询成功";

    String SELECT_FAIL = "查询失败" ;

    String PARAMS_MISS = "参数不齐全" ;

    String EMPTY_RESULT = "查询结果为空" ;

    String SYSTEM_ERROR = "系统异常" ;

    String UPDATE_FAIL = "更新失败" ;

    String UPDATE_SUCCESS = "更新成功" ;

    String UPDATE_FAIL_SELECT_NOT_EXIST = "更新失败，无此记录";

    String DELETE_SUCCESS = "删除成功" ;

    String DELETE_FAIL = "删除失败" ;

    String ADD_SUCCESS = "新增成功" ;

    String ADD_FAIL = "新增失败" ;

    String OP_USER_ERROR = "操作用户异常" ;

    String PARAMS_EMPTY = "参数为空" ;

    String DELETE_FAIL_SELECT_NOT_EXIST = "删除失败，无此记录";
}
