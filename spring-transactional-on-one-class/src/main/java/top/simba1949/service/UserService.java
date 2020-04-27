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
 * 非事务方法调用事务方法：没有事务产生，调用具有事务的方法也没有事务产生
 * 事务方法调用事务方法：只对当前有事务的方法有事务产生，但是调用具有事务的方法没有事务产生
 * @Author Theodore
 * @Date 2020/4/26 18:56
 */
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * PROPAGATION_REQUIRED ：如果当前没有事务，就新创建一个事务。
     *                        如果已经存在一个事务中，加入到这个事务中。
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void propagationRequired() {
        User user = User.builder().username("李白").age(18).build();
        user.setCreator(BaseCommon.CREATOR_SYSTEM);
        user.setCreateTime(LocalDateTime.now());
        user.setDelete(BaseCommon.DELETE_NO);

        userMapper.insert(user);
    }

    /** 非事务方法调用事务方法：没有事务产生，调用具有事务的方法也没有事务产生 */
    public void propagationRequired00() {
        propagationRequired();
    }
    /** 事务方法调用事务方法：有事务产生，但是调用具有事务的方法没有事务产生 */
    @Transactional(rollbackFor = Exception.class)
    public void propagationRequired01() {
        propagationRequired();
    }
    /***********************************************************************************/

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

    /** 非事务方法调用事务方法：没有事务产生，调用具有事务的方法也没有事务产生 */
    public void propagationSupports00(){
        propagationSupports();
    }
    /** 事务方法调用事务方法：有事务产生，但是调用具有事务的方法没有事务产生  */
    @Transactional(rollbackFor = Exception.class)
    public void propagationSupports01(){
        propagationSupports();
    }
    /***********************************************************************************/
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
    /** 非事务方法调用事务方法：没有事务产生，调用具有事务的方法也没有事务产生 */
    public void propagationMandatory00(){
        propagationMandatory();
    }
    /** 事务方法调用事务方法：有事务产生，但是调用具有事务的方法没有事务产生  */
    @Transactional(rollbackFor = Exception.class)
    public void propagationMandatory01(){
        propagationMandatory();
    }

    /***********************************************************************************/
    /**
     * PROPAGATION_REQUIRES_NEW ：新创建事务。
     *                           如果当前存在事务，就把当前事务暂时挂起（Suspending current transaction），
     *                           回复事务（ Resuming suspended transaction）。
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void propagationRequiresNew() {
        User user = User.builder().username("李白").age(18).build();
        user.setCreator(BaseCommon.CREATOR_SYSTEM);
        user.setCreateTime(LocalDateTime.now());
        user.setDelete(BaseCommon.DELETE_NO);

        userMapper.insert(user);
    }
    /** 非事务方法调用事务方法：没有事务产生，调用具有事务的方法也没有事务产生 */
    public void propagationRequiresNew00(){
        propagationRequiresNew();
    }
    /** 事务方法调用事务方法：有事务产生，但是调用具有事务的方法没有事务产生  */
    @Transactional(rollbackFor = Exception.class)
    public void propagationRequiresNew01(){
        propagationRequiresNew();
    }

    /***********************************************************************************/
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
    public void propagationNotSupported() {
        User user = User.builder().username("李白").age(18).build();
        user.setCreator(BaseCommon.CREATOR_SYSTEM);
        user.setCreateTime(LocalDateTime.now());
        user.setDelete(BaseCommon.DELETE_NO);

        userMapper.insert(user);
    }
    /** 非事务方法调用事务方法：没有事务产生，调用具有事务的方法也没有事务产生 */
    public void propagationNotSupported00(){
        propagationNotSupported();
    }
    /** 事务方法调用事务方法：有事务产生，但是调用具有事务的方法没有事务产生  */
    @Transactional(rollbackFor = Exception.class)
    public void propagationNotSupported01(){
        propagationNotSupported();
    }
    /***********************************************************************************/
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NEVER)
    public void propagationNever() {
        User user = User.builder().username("李白").age(18).build();
        user.setCreator(BaseCommon.CREATOR_SYSTEM);
        user.setCreateTime(LocalDateTime.now());
        user.setDelete(BaseCommon.DELETE_NO);

        userMapper.insert(user);
    }
    /** 非事务方法调用事务方法：没有事务产生，调用具有事务的方法也没有事务产生 */
    public void propagationNever00(){
        propagationNever();
    }
    /** 事务方法调用事务方法：有事务产生，但是调用具有事务的方法没有事务产生  */
    @Transactional(rollbackFor = Exception.class)
    public void propagationNever01(){
        propagationNever();
    }
    /***********************************************************************************/
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public void propagationNested() {
        User user = User.builder().username("李白").age(18).build();
        user.setCreator(BaseCommon.CREATOR_SYSTEM);
        user.setCreateTime(LocalDateTime.now());
        user.setDelete(BaseCommon.DELETE_NO);

        userMapper.insert(user);
    }
    /** 非事务方法调用事务方法：没有事务产生，调用具有事务的方法也没有事务产生 */
    public void propagationNested00(){
        propagationNested();
    }
    /** 事务方法调用事务方法：有事务产生，但是调用具有事务的方法没有事务产生  */
    @Transactional(rollbackFor = Exception.class)
    public void propagationNested01(){
        propagationNested();
    }
}