package cn.fv.service.serviceImpl;

import cn.fv.annotation.LogAnno;
import cn.fv.pojo.User;
import cn.fv.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private cn.fv.dao.UserMapper userMapper;

    public User getById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @LogAnno(operateType = "获取所有的用户")
    @Transactional(propagation = Propagation.NEVER,isolation = Isolation.READ_UNCOMMITTED)
    public List<User> getAll() {
        logger.info("获取所有用户");
        return userMapper.selectByExample(null);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add(User user) {
        userMapper.insert(user);
    }
}
