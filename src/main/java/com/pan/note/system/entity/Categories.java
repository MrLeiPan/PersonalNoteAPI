package com.pan.note.system.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

/**
 * <p>
 * 
 * </p>
 *
 * @author Pan
 * @since 2022-04-23
 */
@ApiModel(value = "Categories对象", description = "")
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO) //解决自增的id太长
    private Integer id;

    private String title;

    private String path;

    private Integer pid;

    private String cicon;

    private String createDate;

    private Integer deleted;

    private Integer uid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String getCicon() {
        return cicon;
    }

    public void setCicon(String cicon) {
        this.cicon = cicon;
    }
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Categories{" +
            "id=" + id +
            ", title=" + title +
            ", path=" + path +
            ", pid=" + pid +
            ", cicon=" + cicon +
            ", createDate=" + createDate +
        "}";
    }
}
