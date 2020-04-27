package top.simba1949.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import top.simba1949.model.User;

/**
 * @Author Theodore
 * @Date 2020/4/26 18:56
 */
public interface UserMapper {
    /**
     * 插入
     * @param user
     */
    @Insert("insert into t_user(username, age, creator, create_time) " +
        "value(#{user.username}, #{user.age}, #{user.creator}, #{user.createTime})")
    void insert(@Param("user") User user);
}
