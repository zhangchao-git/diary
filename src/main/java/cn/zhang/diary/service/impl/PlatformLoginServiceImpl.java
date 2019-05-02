package cn.zhang.diary.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import cn.zhang.diary.constant.Constants;
import cn.zhang.diary.exception.CommonException;
import cn.zhang.diary.exception.ErrorCode;
import cn.zhang.diary.model.PlatformUser;
import cn.zhang.diary.service.PlatformLoginService;
import cn.zhang.diary.service.PlatformUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 平台用户登录服务实现类
 *
 * @Auther: zhangchao
 * @Date: 2019/2/15 13:43
 */
@Service
public class PlatformLoginServiceImpl implements PlatformLoginService {

    /**
     * 平台运营人员服务接口
     */
    @Resource
    private PlatformUserService platformUserService;

    /**
     * 平台用户登录
     *
     * @param loginName 登录名
     * @param password  密码
     * @return
     */
    @Override
    public PlatformUser login(String loginName, String password) {
        //校验用户名密码
        PlatformUser platformUser = platformUserService.queryByLoginName(loginName);
        if (null == platformUser) {
            throw new CommonException(ErrorCode.USERNAME_NOT_EXIST);
        }
        if (Constants.STATUS_PROHIBIT == platformUser.getUserStatus()) {
            throw new CommonException(ErrorCode.USER_STATUS_PROHIBIT);
        }
        //密码 = MD5(用户名+密码)
        String md5info = loginName + password;
        String realPassword = SecureUtil.md5(md5info);
        if (!realPassword.equals(platformUser.getPassword())) {
            throw new CommonException(ErrorCode.USER_PASSWORD_ERROR);
        }

        //更新登录时间
        platformUser.setLoginTime(DateUtil.date());
        platformUserService.modifyUser(platformUser);
        //敏感字段处理
        platformUser.setPassword(null);
        return platformUser;
    }
}
