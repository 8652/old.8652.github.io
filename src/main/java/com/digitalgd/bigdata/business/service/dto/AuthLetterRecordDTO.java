package com.digitalgd.bigdata.business.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.digitalgd.bigdata.business.domain.AuthLetterRecord} entity.
 */
@ApiModel(description = "@Description: 授权书记录\n@Version: V1.0")
public class AuthLetterRecordDTO implements Serializable {
    
    private Long id;

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
     * 模板id
     */
    @Size(max = 40)
    @ApiModelProperty(value = "模板id")
    private String templateId;

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
     * 未授权文件路径
     */
    @Size(max = 200)
    @ApiModelProperty(value = "未授权文件路径")
    private String filePath;

    /**
     * 授权文件id
     */
    @Size(max = 50)
    @ApiModelProperty(value = "授权文件id")
    private String authFileId;

    /**
     * 授权时间
     */
    @ApiModelProperty(value = "授权时间")
    private ZonedDateTime authTime;

    /**
     * 授权状态
     */
    @Size(max = 10)
    @ApiModelProperty(value = "授权状态")
    private String authStatus;

    /**
     * 授权人id
     */
    @Size(max = 50)
    @ApiModelProperty(value = "授权人id")
    private String personId;

    /**
     * 授权人名称
     */
    @Size(max = 20)
    @ApiModelProperty(value = "授权人名称")
    private String personName;

    /**
     * 授权人身份证号
     */
    @Size(max = 50)
    @ApiModelProperty(value = "授权人身份证号")
    private String personIdCard;

    /**
     * 授权人手机号
     */
    @Size(max = 11)
    @ApiModelProperty(value = "授权人手机号")
    private String personPhone;

    /**
     * 企业名称
     */
    @Size(max = 50)
    @ApiModelProperty(value = "企业名称")
    private String companyName;

    /**
     * 企业统一社会信用代码
     */
    @Size(max = 50)
    @ApiModelProperty(value = "企业统一社会信用代码")
    private String companySocialCode;

    /**
     * 授权触点（渠道）
     */
    @Size(max = 10)
    @ApiModelProperty(value = "授权触点（渠道）")
    private String authChannel;

    /**
     * 来源
     */
    @Size(max = 20)
    @ApiModelProperty(value = "来源")
    private String authOrigin;

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

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
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

    public String getAuthFileId() {
        return authFileId;
    }

    public void setAuthFileId(String authFileId) {
        this.authFileId = authFileId;
    }

    public ZonedDateTime getAuthTime() {
        return authTime;
    }

    public void setAuthTime(ZonedDateTime authTime) {
        this.authTime = authTime;
    }

    public String getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonIdCard() {
        return personIdCard;
    }

    public void setPersonIdCard(String personIdCard) {
        this.personIdCard = personIdCard;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanySocialCode() {
        return companySocialCode;
    }

    public void setCompanySocialCode(String companySocialCode) {
        this.companySocialCode = companySocialCode;
    }

    public String getAuthChannel() {
        return authChannel;
    }

    public void setAuthChannel(String authChannel) {
        this.authChannel = authChannel;
    }

    public String getAuthOrigin() {
        return authOrigin;
    }

    public void setAuthOrigin(String authOrigin) {
        this.authOrigin = authOrigin;
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
        if (!(o instanceof AuthLetterRecordDTO)) {
            return false;
        }

        return id != null && id.equals(((AuthLetterRecordDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AuthLetterRecordDTO{" +
            "id=" + getId() +
            ", bizItemId='" + getBizItemId() + "'" +
            ", pairContractId='" + getPairContractId() + "'" +
            ", pairContractName='" + getPairContractName() + "'" +
            ", templateId='" + getTemplateId() + "'" +
            ", templateName='" + getTemplateName() + "'" +
            ", templateType='" + getTemplateType() + "'" +
            ", filePath='" + getFilePath() + "'" +
            ", authFileId='" + getAuthFileId() + "'" +
            ", authTime='" + getAuthTime() + "'" +
            ", authStatus='" + getAuthStatus() + "'" +
            ", personId='" + getPersonId() + "'" +
            ", personName='" + getPersonName() + "'" +
            ", personIdCard='" + getPersonIdCard() + "'" +
            ", personPhone='" + getPersonPhone() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            ", companySocialCode='" + getCompanySocialCode() + "'" +
            ", authChannel='" + getAuthChannel() + "'" +
            ", authOrigin='" + getAuthOrigin() + "'" +
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
