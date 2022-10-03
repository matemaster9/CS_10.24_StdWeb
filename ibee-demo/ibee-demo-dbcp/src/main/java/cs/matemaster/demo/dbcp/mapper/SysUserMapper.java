package cs.matemaster.demo.dbcp.mapper;

import cs.matemaster.demo.dbcp.domain.SystemUserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author matemaster
 */
@Mapper
public interface SysUserMapper {

    @Insert({"insert into sys_user (username, passwd, register_phone) " +
            "values " +
            "(#{user.username},#{user.password},#{user.registerPhone})"
    })
    int insertUser(SystemUserDto user);

    int deleteUser(SystemUserDto user);

    int updateUser(SystemUserDto user);
}
