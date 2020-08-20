package com.digitalgd.bigdata.business.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * @Description: 授权书模板\n@Version: V1.0
 */
@Entity
@Table(name = "auth_letter_template")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AuthLetterTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Column(name = "pair_contact_id", length = 40, nullable = false)
    private String pairContactId;

    /**
     * 开放利用协议(双方授权协议)名称
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "pair_contact_name", length = 40, nullable = false)
    private String pairContactName;

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
     * 模板word文件路径
     */
    @Size(max = 200)
    @Column(name = "file_path", length = 200)
    private String filePath;

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

    public String getBizItemId() {
        return bizItemId;
    }

    public AuthLetterTemplate bizItemId(String bizItemId) {
        this.bizItemId = bizItemId;
        return this;
    }

    public void setBizItemId(String bizItemId) {
        this.bizItemId = bizItemId;
    }

    public String getPairContactId() {
        return pairContactId;
    }

    public AuthLetterTemplate pairContactId(String pairContactId) {
        this.pairContactId = pairContactId;
        return this;
    }

    public void setPairContactId(String pairContactId) {
        this.pairContactId = pairContactId;
    }

    public String getPairContactName() {
        return pairContactName;
    }

    public AuthLetterTemplate pairContactName(String pairContactName) {
        this.pairContactName = pairContactName;
        return this;
    }

    public void setPairContactName(String pairContactName) {
        this.pairContactName = pairContactName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public AuthLetterTemplate templateName(String templateName) {
        this.templateName = templateName;
        return this;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateType() {
        return templateType;
    }

    public AuthLetterTemplate templateType(String templateType) {
        this.templateType = templateType;
        return this;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getFilePath() {
        return filePath;
    }

    public AuthLetterTemplate filePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Boolean isDelFlag() {
        return delFlag;
    }

    public AuthLetterTemplate delFlag(Boolean delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public AuthLetterTemplate createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateById() {
        return createById;
    }

    public AuthLetterTemplate createById(String createById) {
        this.createById = createById;
        return this;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public AuthLetterTemplate createByName(String createByName) {
        this.createByName = createByName;
        return this;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getCreateByOrgId() {
        return createByOrgId;
    }

    public AuthLetterTemplate createByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
        return this;
    }

    public void setCreateByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
    }

    public String getCreateByOrgName() {
        return createByOrgName;
    }

    public AuthLetterTemplate createByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
        return this;
    }

    public void setCreateByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
    }

    public ZonedDateTime getLastUpTime() {
        return lastUpTime;
    }

    public AuthLetterTemplate lastUpTime(ZonedDateTime lastUpTime) {
        this.lastUpTime = lastUpTime;
        return this;
    }

    public void setLastUpTime(ZonedDateTime lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    public String getLastUpId() {
        return lastUpId;
    }

    public AuthLetterTemplate lastUpId(String lastUpId) {
        this.lastUpId = lastUpId;
        return this;
    }

    public void setLastUpId(String lastUpId) {
        this.lastUpId = lastUpId;
    }

    public String getLastUpName() {
        return lastUpName;
    }

    public AuthLetterTemplate lastUpName(String lastUpName) {
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
        if (!(o instanceof AuthLetterTemplate)) {
            return false;
        }
        return id != null && id.equals(((AuthLetterTemplate) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AuthLetterTemplate{" +
            "id=" + getId() +
            ", bizItemId='" + getBizItemId() + "'" +
            ", pairContactId='" + getPairContactId() + "'" +
            ", pairContactName='" + getPairContactName() + "'" +
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
