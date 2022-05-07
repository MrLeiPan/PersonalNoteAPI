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
@ApiModel(value = "Chats对象", description = "")
public class Chats implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer sendid;

    private Integer accid;

    private LocalDateTime sendDate;

    private LocalDateTime accDate;

    private String sendContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getSendid() {
        return sendid;
    }

    public void setSendid(Integer sendid) {
        this.sendid = sendid;
    }
    public Integer getAccid() {
        return accid;
    }

    public void setAccid(Integer accid) {
        this.accid = accid;
    }
    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }
    public LocalDateTime getAccDate() {
        return accDate;
    }

    public void setAccDate(LocalDateTime accDate) {
        this.accDate = accDate;
    }
    public String getSendContent() {
        return sendContent;
    }

    public void setSendContent(String sendContent) {
        this.sendContent = sendContent;
    }

    @Override
    public String toString() {
        return "Chats{" +
            "id=" + id +
            ", sendid=" + sendid +
            ", accid=" + accid +
            ", sendDate=" + sendDate +
            ", accDate=" + accDate +
            ", sendContent=" + sendContent +
        "}";
    }
}
