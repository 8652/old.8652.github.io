package com.digitalgd.bigdata.business.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * @Description: 业务事项—信息资源信息\n@Version: V1.0
 */
@Entity
@Table(name = "biz_item_info_res")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BizItemInfoRes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 主键
     */
    @Type(type = "uuid-char")
    @Column(name = "pkid", length = 36)
    private UUID pkid;

    /**
     * 业务事项id
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "biz_item_id", length = 40, nullable = false)
    private String bizItemId;

    /**
     * 数源部门
     */
    @Size(max = 20)
    @Column(name = "origin_dep", length = 20)
    private String originDep;

    /**
     * 信息类名称
     */
    @Size(max = 50)
    @Column(name = "category_name", length = 50)
    private String categoryName;

    /**
     * 信息类编码
     */
    @Size(max = 50)
    @Column(name = "category_code", length = 50)
    private String categoryCode;

    /**
     * 信息项名称
     */
    @Size(max = 50)
    @Column(name = "term_name", length = 50)
    private String termName;

    /**
     * 信息项编码
     */
    @Size(max = 50)
    @Column(name = "term_code", length = 50)
    private String termCode;

    /**
     * 共享类型
     */
    @Size(max = 20)
    @Column(name = "share_type", length = 20)
    private String shareType;

    /**
     * 开放属性
     */
    @Size(max = 20)
    @Column(name = "open_attr", length = 20)
    private String openAttr;

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

    public UUID getPkid() {
        return pkid;
    }

    public BizItemInfoRes pkid(UUID pkid) {
        this.pkid = pkid;
        return this;
    }

    public void setPkid(UUID pkid) {
        this.pkid = pkid;
    }

    public String getBizItemId() {
        return bizItemId;
    }

    public BizItemInfoRes bizItemId(String bizItemId) {
        this.bizItemId = bizItemId;
        return this;
    }

    public void setBizItemId(String bizItemId) {
        this.bizItemId = bizItemId;
    }

    public String getOriginDep() {
        return originDep;
    }

    public BizItemInfoRes originDep(String originDep) {
        this.originDep = originDep;
        return this;
    }

    public void setOriginDep(String originDep) {
        this.originDep = originDep;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public BizItemInfoRes categoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public BizItemInfoRes categoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
        return this;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getTermName() {
        return termName;
    }

    public BizItemInfoRes termName(String termName) {
        this.termName = termName;
        return this;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getTermCode() {
        return termCode;
    }

    public BizItemInfoRes termCode(String termCode) {
        this.termCode = termCode;
        return this;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public String getShareType() {
        return shareType;
    }

    public BizItemInfoRes shareType(String shareType) {
        this.shareType = shareType;
        return this;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public String getOpenAttr() {
        return openAttr;
    }

    public BizItemInfoRes openAttr(String openAttr) {
        this.openAttr = openAttr;
        return this;
    }

    public void setOpenAttr(String openAttr) {
        this.openAttr = openAttr;
    }

    public Boolean isDelFlag() {
        return delFlag;
    }

    public BizItemInfoRes delFlag(Boolean delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public BizItemInfoRes createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateById() {
        return createById;
    }

    public BizItemInfoRes createById(String createById) {
        this.createById = createById;
        return this;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public BizItemInfoRes createByName(String createByName) {
        this.createByName = createByName;
        return this;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getCreateByOrgId() {
        return createByOrgId;
    }

    public BizItemInfoRes createByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
        return this;
    }

    public void setCreateByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
    }

    public String getCreateByOrgName() {
        return createByOrgName;
    }

    public BizItemInfoRes createByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
        return this;
    }

    public void setCreateByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
    }

    public ZonedDateTime getLastUpTime() {
        return lastUpTime;
    }

    public BizItemInfoRes lastUpTime(ZonedDateTime lastUpTime) {
        this.lastUpTime = lastUpTime;
        return this;
    }

    public void setLastUpTime(ZonedDateTime lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    public String getLastUpId() {
        return lastUpId;
    }

    public BizItemInfoRes lastUpId(String lastUpId) {
        this.lastUpId = lastUpId;
        return this;
    }

    public void setLastUpId(String lastUpId) {
        this.lastUpId = lastUpId;
    }

    public String getLastUpName() {
        return lastUpName;
    }

    public BizItemInfoRes lastUpName(String lastUpName) {
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
        if (!(o instanceof BizItemInfoRes)) {
            return false;
        }
        return id != null && id.equals(((BizItemInfoRes) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BizItemInfoRes{" +
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
