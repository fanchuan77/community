// @author:樊川
// @email:945001786@qq.com
package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.enity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface userMapper extends BaseMapper<User> {

    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    int insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(Long id);

    @Select("Select * from user where account_id = #{accountId}")
    User findByAccountId(Long accountId);

    @Update("update user set token = #{token},gmt_modified = #{gmtModified},name = #{name},avatar_url = #{avatarUrl} where account_id = #{accountId}")
    void update(User user);
}
