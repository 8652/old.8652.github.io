package com.digitalgd.bigdata.business.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.digitalgd.bigdata.business.domain.BizItemInfoRes} entity.
 */
@ApiModel(description = "@Description: 业务事项—信息资源信息\n@Version: V1.0")
public class BizItemInfoResDTO implements Serializable {
    
    private Long id;

    /**
     * 主键
     */
    @Size(max = 40)
    @ApiModelProperty(value = "主键")
    private String pkid;

    /**
     * 业务事项id
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "业务事项id", required = true)
    private String bizItemId;

    /**
     * 数源部门
     */
    @Size(max = 20)
    @ApiModelProperty(value = "数源部门")
    private String originDep;

    /**
     * 信息类名称
     */
    @Size(max = 50)
    @ApiModelProperty(value = "信息类名称")
    private String categoryName;

    /**
     * 信息类编码
     */
    @Size(max = 50)
    @ApiModelProperty(value = "信息类编码")
    private String categoryCode;

    /**
     * 信息项名称
     */
    @Size(max = 50)
    @ApiModelProperty(value = "信息项名称")
    private String termName;

    /**
     * 信息项编码
     */
    @Size(max = 50)
    @ApiModelProperty(value = "信息项编码")
    private String termCode;

    /**
     * 共享类型
     */
    @Size(max = 20)
    @ApiModelProperty(value = "共享类型")
    private String shareType;

    /**
     * 开放属性
     */
    @Size(max = 20)
    @ApiModelProperty(value = "开放属性")
    private String openAttr;

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

    public String getBizItemId() {
        return bizItemId;
    }

    public void setBizItemId(String bizItemId) {
        this.bizItemId = bizItemId;
    }

    public String getOriginDep() {
        return originDep;
    }

    public void setOriginDep(String originDep) {
        this.originDep = originDep;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getTermCode() {
        return termCode;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public String getOpenAttr() {
        return openAttr;
    }

    public void setOpenAttr(String openAttr) {
        this.openAttr = openAttr;
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
        if (!(o instanceof BizItemInfoResDTO)) {
            return false;
        }

        return id != null && id.equals(((BizItemInfoResDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BizItemInfoResDTO{" +
            "id=" + getId() +
            ", pkid='" + getPkid() + "'" +
            ", bizItemId='" + getBizItemId() + "'" +
            ", originDep='" + getOriginDep() + "'" +
            ", categoryName='" + getCategoryName() + "'" +
            ", categoryCode='" + getCategoryCode() + "'" +
            ", termName='" + getTermName() + "'" +
            ", termCode='" + getTermCode() + "'" +
            ", shareType='" + getShareType() + "'" +
            ", openAttr='" + getOpenAttr() + "'" +
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
