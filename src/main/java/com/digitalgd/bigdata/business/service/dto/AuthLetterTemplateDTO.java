package com.digitalgd.bigdata.business.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.digitalgd.bigdata.business.domain.AuthLetterTemplate} entity.
 */
@ApiModel(description = "@Description: 授权书模板\n@Version: V1.0")
public class AuthLetterTemplateDTO implements Serializable {
    
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
     * 开放利用协议(双方授权协议)id
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "开放利用协议(双方授权协议)id", required = true)
    private String pairContractId;

    /**
     * 开放利用协议(双方授权协议)名称
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "开放利用协议(双方授权协议)名称", required = true)
    private String pairContractName;

    /**
     * 模板名称
     */
    @Size(max = 50)
    @ApiModelProperty(value = "模板名称")
    private String templateName;

    /**
     * 模板类型，PERSON：个人；COMPANY：企业
     */
    @Size(max = 10)
    @ApiModelProperty(value = "模板类型，PERSON：个人；COMPANY：企业")
    private String templateType;

    /**
     * 模板word文件路径
     */
    @Size(max = 200)
    @ApiModelProperty(value = "模板word文件路径")
    private String filePath;

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

    public String getPairContractId() {
        return pairContractId;
    }

    public void setPairContractId(String pairContractId) {
        this.pairContractId = pairContractId;
    }

    public String getPairContractName() {
        return pairContractName;
    }

    public void setPairContractName(String pairContractName) {
        this.pairContractName = pairContractName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
        if (!(o instanceof AuthLetterTemplateDTO)) {
            return false;
        }

        return id != null && id.equals(((AuthLetterTemplateDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AuthLetterTemplateDTO{" +
            "id=" + getId() +
            ", pkid='" + getPkid() + "'" +
            ", bizItemId='" + getBizItemId() + "'" +
            ", pairContractId='" + getPairContractId() + "'" +
            ", pairContractName='" + getPairContractName() + "'" +
            ", templateName='" + getTemplateName() + "'" +
            ", templateType='" + getTemplateType() + "'" +
            ", filePath='" + getFilePath() + "'" +
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
