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
@ApiModel(value = "Knowledges对象", description = "")
public class Knowledges implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer uid;

    private Integer aid;

    private Integer type;

    private LocalDateTime shareDate;
    private Integer symbol;

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
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public LocalDateTime getShareDate() {
        return shareDate;
    }

    public void setShareDate(LocalDateTime shareDate) {
        this.shareDate = shareDate;
    }

    @Override
    public String toString() {
        return "Knowledges{" +
            "id=" + id +
            ", uid=" + uid +
            ", aid=" + aid +
            ", type=" + type +
            ", shareDate=" + shareDate +
        "}";
    }
}
