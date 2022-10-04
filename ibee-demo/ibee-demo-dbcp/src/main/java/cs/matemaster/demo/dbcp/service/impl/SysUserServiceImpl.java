package cs.matemaster.demo.dbcp.service.impl;

import cs.matemaster.demo.dbcp.constant.DbcpErrorCode;
import cs.matemaster.demo.dbcp.domain.SystemUserDto;
import cs.matemaster.demo.dbcp.exception.TransactionException;
import cs.matemaster.demo.dbcp.mapper.SysUserMapper;
import cs.matemaster.demo.dbcp.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author matemaster
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl implements SysUserService {

    private SysUserMapper sysUserMapper;

    @Transactional(rollbackFor = TransactionException.class)
    @Override
    public Boolean logoutUser(SystemUserDto systemUser) {
        try {
            int result = sysUserMapper.deleteUser(systemUser);
            return result == 1;
        } catch (Exception ex) {
            throw new TransactionException(DbcpErrorCode.DELETE_SYS_USER_ERROR);
        }
    }

    @Transactional(rollbackFor = TransactionException.class)
    @Override
    public void register(SystemUserDto systemUser) {
        try {
            sysUserMapper.insertUser(systemUser);
        } catch (Exception ex) {
            throw new TransactionException(DbcpErrorCode.ADD_SYS_USER_ERROR);
        }
    }

    @Transactional(rollbackFor = TransactionException.class)
    @Override
    public Boolean update(SystemUserDto systemUser) {
        try {
            int result = sysUserMapper.updateUser(systemUser);
            return result == 1;
        } catch (Exception ex) {
            throw new TransactionException(DbcpErrorCode.UPDATE_SYS_USER_ERROR);
        }
    }
}
