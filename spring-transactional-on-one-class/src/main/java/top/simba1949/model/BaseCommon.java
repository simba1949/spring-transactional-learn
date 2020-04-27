package top.simba1949.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author Theodore
 * @Date 2020/4/26 19:06
 */
public class BaseCommon implements Serializable {

    private static final long serialVersionUID = 5632227019358732717L;

    public static final String CREATOR_SYSTEM = "creator_system";
    public static final String UPDATER_SYSTEM = "updater_system";
    public static final int DELETE_NO = 0;
    public static final int DELETE_YES = 1;

    private Integer delete;
    private String creator;
    private LocalDateTime createTime;
    private String updater;
    private LocalDateTime updateTime;

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}