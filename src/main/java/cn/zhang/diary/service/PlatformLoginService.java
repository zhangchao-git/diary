package cn.zhang.diary.service;


import cn.zhang.diary.model.PlatformUser;

/**
 * 平台用户登录服务类
 *
 * @Auther: zhangchao
 * @Date: 2019/2/15 13:39
 */
public interface PlatformLoginService {

    /**
     * 平台用户登录
     *
     * @param loginName 登录名
     * @param password  密码
     * @return
     */
    PlatformUser login(String loginName, String password);
}
