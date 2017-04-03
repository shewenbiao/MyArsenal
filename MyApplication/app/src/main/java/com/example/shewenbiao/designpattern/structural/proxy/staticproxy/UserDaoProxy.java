package com.example.shewenbiao.designpattern.structural.proxy.staticproxy;

/**
 * Created by shewenbiao on 17/4/3.
 */

/**
 * 代理对象，静态代理
 */

public class UserDaoProxy implements IUserDao {

    private IUserDao mIUserDao;

    public UserDaoProxy(IUserDao iUserDao) {
        mIUserDao = iUserDao;
    }

    @Override
    public void save() {
        mIUserDao.save();
    }
}
