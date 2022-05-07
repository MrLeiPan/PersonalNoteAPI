package com.pan.note.system.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Pan
 * @since 2022-04-23
 */
@ApiModel(value = "Comments对象", description = "")
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer pid;

    private Integer uid;

    private Integer toid;

    private String content;

    private LocalDateTime comDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Integer getToid() {
        return toid;
    }

    public void setToid(Integer toid) {
        this.toid = toid;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getComDate() {
        return comDate;
    }

    public void setComDate(LocalDateTime comDate) {
        this.comDate = comDate;
    }

    @Override
    public String toString() {
        return "Comments{" +
            "id=" + id +
            ", pid=" + pid +
            ", uid=" + uid +
            ", toid=" + toid +
            ", content=" + content +
            ", comDate=" + comDate +
        "}";
    }
}
