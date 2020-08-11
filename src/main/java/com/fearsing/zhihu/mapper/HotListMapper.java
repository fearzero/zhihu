package com.fearsing.zhihu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface HotListMapper {
    int insert(Map<String, Object> map);




}
