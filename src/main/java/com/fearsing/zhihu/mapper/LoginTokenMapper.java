package com.fearsing.zhihu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Mapper
@Repository
public interface LoginTokenMapper {
    Map<String,Object> selectToken(Map<String,Object> map);
}
