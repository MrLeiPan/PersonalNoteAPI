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
@ApiModel(value = "Userschools对象", description = "")
public class Userschools implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer uid;

    private Integer sid;

    private String degree;

    private LocalDateTime enterDate;

    private LocalDateTime graduateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
    public LocalDateTime getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(LocalDateTime enterDate) {
        this.enterDate = enterDate;
    }
    public LocalDateTime getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(LocalDateTime graduateDate) {
        this.graduateDate = graduateDate;
    }

    @Override
    public String toString() {
        return "Userschools{" +
            "id=" + id +
            ", uid=" + uid +
            ", sid=" + sid +
            ", degree=" + degree +
            ", enterDate=" + enterDate +
            ", graduateDate=" + graduateDate +
        "}";
    }
}
