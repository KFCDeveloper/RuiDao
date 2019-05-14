package com.neuedu.model.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    void addMoney(@Param("id") int id, @Param("money") double money);
    void deductMoney(@Param("id") int id, @Param("money") double money);
}
