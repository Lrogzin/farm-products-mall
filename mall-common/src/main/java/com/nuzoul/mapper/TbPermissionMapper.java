package com.nuzoul.mapper;

import com.nuzoul.pojo.TbPermission;
import com.nuzoul.pojo.TbPermissionExample;
import com.nuzoul.common.mybatis.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPermissionMapper extends BaseMapper {
    long countByExample(TbPermissionExample example);

    int deleteByExample(TbPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPermission record);

    int insertSelective(TbPermission record);

    List<TbPermission> selectByExample(TbPermissionExample example);

    TbPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPermission record, @Param("example") TbPermissionExample example);

    int updateByExample(@Param("record") TbPermission record, @Param("example") TbPermissionExample example);

    int updateByPrimaryKeySelective(TbPermission record);

    int updateByPrimaryKey(TbPermission record);
}