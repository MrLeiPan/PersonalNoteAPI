package com.pan.note.system.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@ApiModel(value = "Misnotes对象", description = "")
public class Misnotes implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String content;

    private LocalDateTime createDate;

    private Integer deleted;

    private Integer degree;

    private Integer symbol;

    private Integer uid;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSymbol() {
        return symbol;
    }


    public void setSymbol(Integer symbol) {
        this.symbol = symbol;
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
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Misnotes{" +
            "id=" + id +
            ", title=" + title +
            ", content=" + content +
            ", createDate=" + createDate +
            ", deleted=" + deleted +
            ", degree=" + degree +
        "}";
    }
}
