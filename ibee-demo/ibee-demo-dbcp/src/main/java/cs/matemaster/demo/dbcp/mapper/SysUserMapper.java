package cs.matemaster.demo.dbcp.mapper;

import cs.matemaster.demo.dbcp.domain.SystemUserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author matemaster
 */
@Mapper
public interface SysUserMapper {

    @Insert({"insert into sys_user (username, passwd, register_phone) " +
            "values " +
            "(#{user.username},#{user.password},#{user.registerPhone}) "
    })
    int insertUser(@Param("user") SystemUserDto user);

    @Update({"update sys_user " +
            "set delete_flag = 1 " +
            "where register_phone = #{user.registerPhone} and passwd = #{user.password} and delete_flag = 0 "
    })
    int deleteUser(@Param("user") SystemUserDto user);

    @Update({"update sys_user " +
            "set passwd = #{user.password}, register_phone = #{user.registerPhone} " +
            "where username = #{user.username} and delete_flag = 0 "
    })
    int updateUser(@Param("user") SystemUserDto user);
}
