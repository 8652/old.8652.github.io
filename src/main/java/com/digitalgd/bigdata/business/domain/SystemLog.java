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
 * A SystemLog.
 */
@Entity
@Table(name = "system_log")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SystemLog implements Serializable {

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
     * 操作人姓名
     */
    @NotNull
    @Size(max = 20)
    @Column(name = "operator_name", length = 20, nullable = false)
    private String operatorName;

    /**
     * 操作人id
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "operator_id", length = 40, nullable = false)
    private String operatorId;

    /**
     * 操作人组织名称
     */
    @Size(max = 20)
    @Column(name = "operator_dept_name", length = 20)
    private String operatorDeptName;

    /**
     * 操作人组织id
     */
    @Size(max = 40)
    @Column(name = "operator_dept_id", length = 40)
    private String operatorDeptId;

    /**
     * 操作时间
     */
    @Column(name = "operate_time")
    private ZonedDateTime operateTime;

    /**
     * 操作类型
     */
    @Size(max = 40)
    @Column(name = "operate_type", length = 40)
    private String operateType;

    /**
     * 操作内容
     */
    @Size(max = 40)
    @Column(name = "content", length = 40)
    private String content;

    /**
     * 备注
     */
    @Size(max = 40)
    @Column(name = "memo", length = 40)
    private String memo;

    /**
     * 接口参数json串
     */
    @Size(max = 40)
    @Column(name = "opreate_params", length = 40)
    private String opreateParams;

    /**
     * 全局唯一id
     */
    @Size(max = 40)
    @Column(name = "global_unique_id", length = 40)
    private String globalUniqueId;

    /**
     * 逻辑删除标志位,false：未删除；true：已删除
     */
    @NotNull
    @Column(name = "del_flag", nullable = false)
    private Boolean delFlag;

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

    public SystemLog pkid(UUID pkid) {
        this.pkid = pkid;
        return this;
    }

    public void setPkid(UUID pkid) {
        this.pkid = pkid;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public SystemLog operatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public SystemLog operatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorDeptName() {
        return operatorDeptName;
    }

    public SystemLog operatorDeptName(String operatorDeptName) {
        this.operatorDeptName = operatorDeptName;
        return this;
    }

    public void setOperatorDeptName(String operatorDeptName) {
        this.operatorDeptName = operatorDeptName;
    }

    public String getOperatorDeptId() {
        return operatorDeptId;
    }

    public SystemLog operatorDeptId(String operatorDeptId) {
        this.operatorDeptId = operatorDeptId;
        return this;
    }

    public void setOperatorDeptId(String operatorDeptId) {
        this.operatorDeptId = operatorDeptId;
    }

    public ZonedDateTime getOperateTime() {
        return operateTime;
    }

    public SystemLog operateTime(ZonedDateTime operateTime) {
        this.operateTime = operateTime;
        return this;
    }

    public void setOperateTime(ZonedDateTime operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateType() {
        return operateType;
    }

    public SystemLog operateType(String operateType) {
        this.operateType = operateType;
        return this;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getContent() {
        return content;
    }

    public SystemLog content(String content) {
        this.content = content;
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMemo() {
        return memo;
    }

    public SystemLog memo(String memo) {
        this.memo = memo;
        return this;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOpreateParams() {
        return opreateParams;
    }

    public SystemLog opreateParams(String opreateParams) {
        this.opreateParams = opreateParams;
        return this;
    }

    public void setOpreateParams(String opreateParams) {
        this.opreateParams = opreateParams;
    }

    public String getGlobalUniqueId() {
        return globalUniqueId;
    }

    public SystemLog globalUniqueId(String globalUniqueId) {
        this.globalUniqueId = globalUniqueId;
        return this;
    }

    public void setGlobalUniqueId(String globalUniqueId) {
        this.globalUniqueId = globalUniqueId;
    }

    public Boolean isDelFlag() {
        return delFlag;
    }

    public SystemLog delFlag(Boolean delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SystemLog)) {
            return false;
        }
        return id != null && id.equals(((SystemLog) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SystemLog{" +
            "id=" + getId() +
            ", pkid='" + getPkid() + "'" +
            ", operatorName='" + getOperatorName() + "'" +
            ", operatorId='" + getOperatorId() + "'" +
            ", operatorDeptName='" + getOperatorDeptName() + "'" +
            ", operatorDeptId='" + getOperatorDeptId() + "'" +
            ", operateTime='" + getOperateTime() + "'" +
            ", operateType='" + getOperateType() + "'" +
            ", content='" + getContent() + "'" +
            ", memo='" + getMemo() + "'" +
            ", opreateParams='" + getOpreateParams() + "'" +
            ", globalUniqueId='" + getGlobalUniqueId() + "'" +
            ", delFlag='" + isDelFlag() + "'" +
            "}";
    }
}
