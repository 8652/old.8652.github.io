package com.digitalgd.bigdata.business.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.digitalgd.bigdata.business.domain.BigInterfaceBiz} entity.
 */
@ApiModel(description = "@Description: 数据接口与业务事项关系\n@Version: V1.0")
public class BigInterfaceBizDTO implements Serializable {
    
    private Long id;

    /**
     * 主键
     */
    @Size(max = 40)
    @ApiModelProperty(value = "主键")
    private String pkid;

    /**
     * 大数据接口id
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "大数据接口id", required = true)
    private String interfaceId;

    /**
     * 业务事项id
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "业务事项id", required = true)
    private String bizId;

    /**
     * 逻辑删除标志位,false：未删除；true：已删除
     */
    @NotNull
    @ApiModelProperty(value = "逻辑删除标志位,false：未删除；true：已删除", required = true)
    private Boolean delFlag;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private ZonedDateTime createTime;

    /**
     * 创建人id
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "创建人id", required = true)
    private String createById;

    /**
     * 创建人姓名
     */
    @NotNull
    @Size(max = 80)
    @ApiModelProperty(value = "创建人姓名", required = true)
    private String createByName;

    /**
     * 创建人组织id
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "创建人组织id", required = true)
    private String createByOrgId;

    /**
     * 创建人组织名称
     */
    @Size(max = 80)
    @ApiModelProperty(value = "创建人组织名称")
    private String createByOrgName;

    /**
     * 最后更新时间
     */
    @ApiModelProperty(value = "最后更新时间")
    private ZonedDateTime lastUpTime;

    /**
     * 最后更新人id
     */
    @Size(max = 40)
    @ApiModelProperty(value = "最后更新人id")
    private String lastUpId;

    /**
     * 最后更新人姓名
     */
    @Size(max = 80)
    @ApiModelProperty(value = "最后更新人姓名")
    private String lastUpName;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Boolean isDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateById() {
        return createById;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getCreateByOrgId() {
        return createByOrgId;
    }

    public void setCreateByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
    }

    public String getCreateByOrgName() {
        return createByOrgName;
    }

    public void setCreateByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
    }

    public ZonedDateTime getLastUpTime() {
        return lastUpTime;
    }

    public void setLastUpTime(ZonedDateTime lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    public String getLastUpId() {
        return lastUpId;
    }

    public void setLastUpId(String lastUpId) {
        this.lastUpId = lastUpId;
    }

    public String getLastUpName() {
        return lastUpName;
    }

    public void setLastUpName(String lastUpName) {
        this.lastUpName = lastUpName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BigInterfaceBizDTO)) {
            return false;
        }

        return id != null && id.equals(((BigInterfaceBizDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BigInterfaceBizDTO{" +
            "id=" + getId() +
            ", pkid='" + getPkid() + "'" +
            ", interfaceId='" + getInterfaceId() + "'" +
            ", bizId='" + getBizId() + "'" +
            ", delFlag='" + isDelFlag() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", createById='" + getCreateById() + "'" +
            ", createByName='" + getCreateByName() + "'" +
            ", createByOrgId='" + getCreateByOrgId() + "'" +
            ", createByOrgName='" + getCreateByOrgName() + "'" +
            ", lastUpTime='" + getLastUpTime() + "'" +
            ", lastUpId='" + getLastUpId() + "'" +
            ", lastUpName='" + getLastUpName() + "'" +
            "}";
    }
}
