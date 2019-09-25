package com.spring.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.boot.entity.Count;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : Hens
 * @date : 2019/9/24 10:42
 */
@Mapper
public interface CountMapper extends BaseMapper<Count> {
}
