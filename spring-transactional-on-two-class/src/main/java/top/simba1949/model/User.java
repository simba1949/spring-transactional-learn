package top.simba1949.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author Theodore
 * @Date 2020/4/26 18:56
 */
@Data
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseCommon{

    private static final long serialVersionUID = 5005314465009041344L;
    private Integer id;
    private String username;
    private String realName;
    private String nickname;
    private Integer age;
}