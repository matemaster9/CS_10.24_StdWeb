package cs.matemaster.demo.dbcp.mapper;

import cs.matemaster.demo.dbcp.domain.SystemUserDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author matemaster
 */
@Mapper
public interface SysUserMapper {

    int insertUser(SystemUserDto user);

    int deleteUser(SystemUserDto user);

    int updateUser(SystemUserDto user);
}
