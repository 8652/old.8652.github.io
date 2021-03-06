package com.digitalgd.bigdata.business.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * @Description: 授权书记录\n@Version: V1.0
 */
@Entity
@Table(name = "auth_letter_record")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AuthLetterRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 全局唯一id
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "global_unique_id", length = 40, nullable = false)
    private String globalUniqueId;

    /**
     * 业务事项id
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "biz_item_id", length = 40, nullable = false)
    private String bizItemId;

    /**
     * 开放利用协议(双方授权协议)id
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "pair_contract_id", length = 40, nullable = false)
    private String pairContractId;

    /**
     * 开放利用协议(双方授权协议)名称
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "pair_contract_name", length = 40, nullable = false)
    private String pairContractName;

    /**
     * 模板id
     */
    @Size(max = 40)
    @Column(name = "template_id", length = 40)
    private String templateId;

    /**
     * 模板名称
     */
    @Size(max = 50)
    @Column(name = "template_name", length = 50)
    private String templateName;

    /**
     * 模板类型，PERSON：个人；COMPANY：企业
     */
    @Size(max = 10)
    @Column(name = "template_type", length = 10)
    private String templateType;

    /**
     * 未授权文件路径
     */
    @Size(max = 200)
    @Column(name = "file_path", length = 200)
    private String filePath;

    /**
     * 未授权文件id
     */
    @Size(max = 200)
    @Column(name = "file_id", length = 200)
    private String fileId;

    /**
     * 授权文件id
     */
    @Size(max = 50)
    @Column(name = "auth_file_id", length = 50)
    private String authFileId;

    /**
     * 授权时间
     */
    @Column(name = "auth_time")
    private ZonedDateTime authTime;

    /**
     * 授权状态
     */
    @Size(max = 10)
    @Column(name = "auth_status", length = 10)
    private String authStatus;

    /**
     * 授权人id
     */
    @Size(max = 50)
    @Column(name = "person_id", length = 50)
    private String personId;

    /**
     * 授权人名称
     */
    @Size(max = 20)
    @Column(name = "person_name", length = 20)
    private String personName;

    /**
     * 授权人身份证号
     */
    @Size(max = 50)
    @Column(name = "person_id_card", length = 50)
    private String personIdCard;

    /**
     * 授权人手机号
     */
    @Size(max = 11)
    @Column(name = "person_phone", length = 11)
    private String personPhone;

    /**
     * 企业名称
     */
    @Size(max = 50)
    @Column(name = "company_name", length = 50)
    private String companyName;

    /**
     * 企业统一社会信用代码
     */
    @Size(max = 50)
    @Column(name = "company_social_code", length = 50)
    private String companySocialCode;

    /**
     * 授权触点（渠道）
     */
    @Size(max = 10)
    @Column(name = "auth_channel", length = 10)
    private String authChannel;

    /**
     * 来源
     */
    @Size(max = 20)
    @Column(name = "auth_origin", length = 20)
    private String authOrigin;

    /**
     * appKey
     */
    @Size(max = 40)
    @Column(name = "app_key", length = 40)
    private String appKey;

    /**
     * 逻辑删除标志位,false：未删除；true：已删除
     */
    @NotNull
    @Column(name = "del_flag", nullable = false)
    private Boolean delFlag;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private ZonedDateTime createTime;

    /**
     * 创建人id
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "create_by_id", length = 40, nullable = false)
    private String createById;

    /**
     * 创建人姓名
     */
    @NotNull
    @Size(max = 80)
    @Column(name = "create_by_name", length = 80, nullable = false)
    private String createByName;

    /**
     * 创建人组织id
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "create_by_org_id", length = 40, nullable = false)
    private String createByOrgId;

    /**
     * 创建人组织名称
     */
    @Size(max = 80)
    @Column(name = "create_by_org_name", length = 80)
    private String createByOrgName;

    /**
     * 最后更新时间
     */
    @Column(name = "last_up_time")
    private ZonedDateTime lastUpTime;

    /**
     * 最后更新人id
     */
    @Size(max = 40)
    @Column(name = "last_up_id", length = 40)
    private String lastUpId;

    /**
     * 最后更新人姓名
     */
    @Size(max = 80)
    @Column(name = "last_up_name", length = 80)
    private String lastUpName;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGlobalUniqueId() {
        return globalUniqueId;
    }

    public AuthLetterRecord globalUniqueId(String globalUniqueId) {
        this.globalUniqueId = globalUniqueId;
        return this;
    }

    public void setGlobalUniqueId(String globalUniqueId) {
        this.globalUniqueId = globalUniqueId;
    }

    public String getBizItemId() {
        return bizItemId;
    }

    public AuthLetterRecord bizItemId(String bizItemId) {
        this.bizItemId = bizItemId;
        return this;
    }

    public void setBizItemId(String bizItemId) {
        this.bizItemId = bizItemId;
    }

    public String getPairContractId() {
        return pairContractId;
    }

    public AuthLetterRecord pairContractId(String pairContractId) {
        this.pairContractId = pairContractId;
        return this;
    }

    public void setPairContractId(String pairContractId) {
        this.pairContractId = pairContractId;
    }

    public String getPairContractName() {
        return pairContractName;
    }

    public AuthLetterRecord pairContractName(String pairContractName) {
        this.pairContractName = pairContractName;
        return this;
    }

    public void setPairContractName(String pairContractName) {
        this.pairContractName = pairContractName;
    }

    public String getTemplateId() {
        return templateId;
    }

    public AuthLetterRecord templateId(String templateId) {
        this.templateId = templateId;
        return this;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public AuthLetterRecord templateName(String templateName) {
        this.templateName = templateName;
        return this;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateType() {
        return templateType;
    }

    public AuthLetterRecord templateType(String templateType) {
        this.templateType = templateType;
        return this;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getFilePath() {
        return filePath;
    }

    public AuthLetterRecord filePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileId() {
        return fileId;
    }

    public AuthLetterRecord fileId(String fileId) {
        this.fileId = fileId;
        return this;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getAuthFileId() {
        return authFileId;
    }

    public AuthLetterRecord authFileId(String authFileId) {
        this.authFileId = authFileId;
        return this;
    }

    public void setAuthFileId(String authFileId) {
        this.authFileId = authFileId;
    }

    public ZonedDateTime getAuthTime() {
        return authTime;
    }

    public AuthLetterRecord authTime(ZonedDateTime authTime) {
        this.authTime = authTime;
        return this;
    }

    public void setAuthTime(ZonedDateTime authTime) {
        this.authTime = authTime;
    }

    public String getAuthStatus() {
        return authStatus;
    }

    public AuthLetterRecord authStatus(String authStatus) {
        this.authStatus = authStatus;
        return this;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    public String getPersonId() {
        return personId;
    }

    public AuthLetterRecord personId(String personId) {
        this.personId = personId;
        return this;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public AuthLetterRecord personName(String personName) {
        this.personName = personName;
        return this;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonIdCard() {
        return personIdCard;
    }

    public AuthLetterRecord personIdCard(String personIdCard) {
        this.personIdCard = personIdCard;
        return this;
    }

    public void setPersonIdCard(String personIdCard) {
        this.personIdCard = personIdCard;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public AuthLetterRecord personPhone(String personPhone) {
        this.personPhone = personPhone;
        return this;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public AuthLetterRecord companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanySocialCode() {
        return companySocialCode;
    }

    public AuthLetterRecord companySocialCode(String companySocialCode) {
        this.companySocialCode = companySocialCode;
        return this;
    }

    public void setCompanySocialCode(String companySocialCode) {
        this.companySocialCode = companySocialCode;
    }

    public String getAuthChannel() {
        return authChannel;
    }

    public AuthLetterRecord authChannel(String authChannel) {
        this.authChannel = authChannel;
        return this;
    }

    public void setAuthChannel(String authChannel) {
        this.authChannel = authChannel;
    }

    public String getAuthOrigin() {
        return authOrigin;
    }

    public AuthLetterRecord authOrigin(String authOrigin) {
        this.authOrigin = authOrigin;
        return this;
    }

    public void setAuthOrigin(String authOrigin) {
        this.authOrigin = authOrigin;
    }

    public String getAppKey() {
        return appKey;
    }

    public AuthLetterRecord appKey(String appKey) {
        this.appKey = appKey;
        return this;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public Boolean isDelFlag() {
        return delFlag;
    }

    public AuthLetterRecord delFlag(Boolean delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public AuthLetterRecord createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateById() {
        return createById;
    }

    public AuthLetterRecord createById(String createById) {
        this.createById = createById;
        return this;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public AuthLetterRecord createByName(String createByName) {
        this.createByName = createByName;
        return this;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getCreateByOrgId() {
        return createByOrgId;
    }

    public AuthLetterRecord createByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
        return this;
    }

    public void setCreateByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
    }

    public String getCreateByOrgName() {
        return createByOrgName;
    }

    public AuthLetterRecord createByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
        return this;
    }

    public void setCreateByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
    }

    public ZonedDateTime getLastUpTime() {
        return lastUpTime;
    }

    public AuthLetterRecord lastUpTime(ZonedDateTime lastUpTime) {
        this.lastUpTime = lastUpTime;
        return this;
    }

    public void setLastUpTime(ZonedDateTime lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    public String getLastUpId() {
        return lastUpId;
    }

    public AuthLetterRecord lastUpId(String lastUpId) {
        this.lastUpId = lastUpId;
        return this;
    }

    public void setLastUpId(String lastUpId) {
        this.lastUpId = lastUpId;
    }

    public String getLastUpName() {
        return lastUpName;
    }

    public AuthLetterRecord lastUpName(String lastUpName) {
        this.lastUpName = lastUpName;
        return this;
    }

    public void setLastUpName(String lastUpName) {
        this.lastUpName = lastUpName;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AuthLetterRecord)) {
            return false;
        }
        return id != null && id.equals(((AuthLetterRecord) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AuthLetterRecord{" +
            "id=" + getId() +
            ", globalUniqueId='" + getGlobalUniqueId() + "'" +
            ", bizItemId='" + getBizItemId() + "'" +
            ", pairContractId='" + getPairContractId() + "'" +
            ", pairContractName='" + getPairContractName() + "'" +
            ", templateId='" + getTemplateId() + "'" +
            ", templateName='" + getTemplateName() + "'" +
            ", templateType='" + getTemplateType() + "'" +
            ", filePath='" + getFilePath() + "'" +
            ", fileId='" + getFileId() + "'" +
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
            ", appKey='" + getAppKey() + "'" +
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
