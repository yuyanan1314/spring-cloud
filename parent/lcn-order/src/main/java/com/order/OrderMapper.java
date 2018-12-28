package com.order;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * User映射类
 * Created by Administrator on 2017/11/24.
 */
@Mapper
public interface OrderMapper {

    @Select("SELECT * FROM t_order WHERE PHONE = '${phone}'")
    Order findUserByPhone(@Param("phone") String phone);

    @Insert("INSERT INTO t_order(NAME, PASSWORD, PHONE) VALUES('${name}', '${password}', '${phone}')")
    int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);

}
