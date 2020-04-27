package top.simba1949.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.simba1949.mapper.UserMapper;
import top.simba1949.model.BaseCommon;
import top.simba1949.model.User;

import java.time.LocalDateTime;

/**
 * @Author Theodore
 * @Date 2020/4/26 18:56
 */
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     *
     * PROPAGATION_REQUIRED ：如果当前没有事务，就会创建一个事务；
     *                        如果已经存在一个事务中，加入到这个事务中。(Participating in existing transaction)
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void propagationRequired() {
        User user = User.builder().username("李白").age(18).build();
        user.setCreator(BaseCommon.CREATOR_SYSTEM);
        user.setCreateTime(LocalDateTime.now());
        user.setDelete(BaseCommon.DELETE_NO);

        userMapper.insert(user);
    }

    /**
     * PROPAGATION_SUPPORTS ：支持当前事务(Participating in existing transaction)，如果当前没有事务，就以非事务执行
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    public void propagationSupports() {
        User user = User.builder().username("李白").age(18).build();
        user.setCreator(BaseCommon.CREATOR_SYSTEM);
        user.setCreateTime(LocalDateTime.now());
        user.setDelete(BaseCommon.DELETE_NO);

        userMapper.insert(user);
    }

    /**
     * PROPAGATION_MANDATORY : 使用当前事务。如果当前没有事务，就抛出异常。
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void propagationMandatory() {
        User user = User.builder().username("李白").age(18).build();
        user.setCreator(BaseCommon.CREATOR_SYSTEM);
        user.setCreateTime(LocalDateTime.now());
        user.setDelete(BaseCommon.DELETE_NO);

        userMapper.insert(user);
    }

    /**
     * PROPAGATION_REQUIRES_NEW ：新创建事务。
     *                           如果当前存在事务，就把当前事务暂时挂起（Suspending current transaction），
     *                           恢复事务（ Resuming suspended transaction）。
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void propagationRequiresNew() {
        User user = User.builder().username("李白").age(18).build();
        user.setCreator(BaseCommon.CREATOR_SYSTEM);
        user.setCreateTime(LocalDateTime.now());
        user.setDelete(BaseCommon.DELETE_NO);

        userMapper.insert(user);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
    public void propagationNotSupported() {
        User user = User.builder().username("李白").age(18).build();
        user.setCreator(BaseCommon.CREATOR_SYSTEM);
        user.setCreateTime(LocalDateTime.now());
        user.setDelete(BaseCommon.DELETE_NO);

        userMapper.insert(user);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NEVER)
    public void propagationNever() {
        User user = User.builder().username("李白").age(18).build();
        user.setCreator(BaseCommon.CREATOR_SYSTEM);
        user.setCreateTime(LocalDateTime.now());
        user.setDelete(BaseCommon.DELETE_NO);

        userMapper.insert(user);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public void propagationNested() {
        User user = User.builder().username("李白").age(18).build();
        user.setCreator(BaseCommon.CREATOR_SYSTEM);
        user.setCreateTime(LocalDateTime.now());
        user.setDelete(BaseCommon.DELETE_NO);

        userMapper.insert(user);
    }
}