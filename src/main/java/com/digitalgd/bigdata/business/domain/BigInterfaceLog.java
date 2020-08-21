package com.digitalgd.bigdata.business.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * @Description: 数据调用记录表\n@Version: V1.0
 */
@Entity
@Table(name = "big_interface_log")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BigInterfaceLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 应用接入账号
     */
    @Size(max = 40)
    @Column(name = "app_key", length = 40)
    private String appKey;

    /**
     * 数据接入方
     */
    @NotNull
    @Size(max = 50)
    @Column(name = "consumer_name", length = 50, nullable = false)
    private String consumerName;

    /**
     * 接口id
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "interface_id", length = 40, nullable = false)
    private String interfaceId;

    /**
     * 服务接口接口编码
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "interface_code", length = 40, nullable = false)
    private String interfaceCode;

    /**
     * 服务接口名字
     */
    @NotNull
    @Size(max = 100)
    @Column(name = "interface_name", length = 100, nullable = false)
    private String interfaceName;

    /**
     * 数据提供方编码（列表，以逗号间隔）
     */
    @NotNull
    @Size(max = 300)
    @Column(name = "data_prov_ids", length = 300, nullable = false)
    private String dataProvIds;

    /**
     * 接口调用时间
     */
    @Column(name = "use_time")
    private ZonedDateTime useTime;

    /**
     * 接口调用状态
     */
    @Size(max = 10)
    @Column(name = "status", length = 10)
    private String status;

    /**
     * 本地接口路径
     */
    @Size(max = 100)
    @Column(name = "interface_path", length = 100)
    private String interfacePath;

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

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppKey() {
        return appKey;
    }

    public BigInterfaceLog appKey(String appKey) {
        this.appKey = appKey;
        return this;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public BigInterfaceLog consumerName(String consumerName) {
        this.consumerName = consumerName;
        return this;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getInterfaceId() {
        return interfaceId;
    }

    public BigInterfaceLog interfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
        return this;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public BigInterfaceLog interfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
        return this;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public BigInterfaceLog interfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
        return this;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getDataProvIds() {
        return dataProvIds;
    }

    public BigInterfaceLog dataProvIds(String dataProvIds) {
        this.dataProvIds = dataProvIds;
        return this;
    }

    public void setDataProvIds(String dataProvIds) {
        this.dataProvIds = dataProvIds;
    }

    public ZonedDateTime getUseTime() {
        return useTime;
    }

    public BigInterfaceLog useTime(ZonedDateTime useTime) {
        this.useTime = useTime;
        return this;
    }

    public void setUseTime(ZonedDateTime useTime) {
        this.useTime = useTime;
    }

    public String getStatus() {
        return status;
    }

    public BigInterfaceLog status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInterfacePath() {
        return interfacePath;
    }

    public BigInterfaceLog interfacePath(String interfacePath) {
        this.interfacePath = interfacePath;
        return this;
    }

    public void setInterfacePath(String interfacePath) {
        this.interfacePath = interfacePath;
    }

    public String getGlobalUniqueId() {
        return globalUniqueId;
    }

    public BigInterfaceLog globalUniqueId(String globalUniqueId) {
        this.globalUniqueId = globalUniqueId;
        return this;
    }

    public void setGlobalUniqueId(String globalUniqueId) {
        this.globalUniqueId = globalUniqueId;
    }

    public Boolean isDelFlag() {
        return delFlag;
    }

    public BigInterfaceLog delFlag(Boolean delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public BigInterfaceLog createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateById() {
        return createById;
    }

    public BigInterfaceLog createById(String createById) {
        this.createById = createById;
        return this;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public BigInterfaceLog createByName(String createByName) {
        this.createByName = createByName;
        return this;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getCreateByOrgId() {
        return createByOrgId;
    }

    public BigInterfaceLog createByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
        return this;
    }

    public void setCreateByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
    }

    public String getCreateByOrgName() {
        return createByOrgName;
    }

    public BigInterfaceLog createByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
        return this;
    }

    public void setCreateByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BigInterfaceLog)) {
            return false;
        }
        return id != null && id.equals(((BigInterfaceLog) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BigInterfaceLog{" +
            "id=" + getId() +
            ", appKey='" + getAppKey() + "'" +
            ", consumerName='" + getConsumerName() + "'" +
            ", interfaceId='" + getInterfaceId() + "'" +
            ", interfaceCode='" + getInterfaceCode() + "'" +
            ", interfaceName='" + getInterfaceName() + "'" +
            ", dataProvIds='" + getDataProvIds() + "'" +
            ", useTime='" + getUseTime() + "'" +
            ", status='" + getStatus() + "'" +
            ", interfacePath='" + getInterfacePath() + "'" +
            ", globalUniqueId='" + getGlobalUniqueId() + "'" +
            ", delFlag='" + isDelFlag() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", createById='" + getCreateById() + "'" +
            ", createByName='" + getCreateByName() + "'" +
            ", createByOrgId='" + getCreateByOrgId() + "'" +
            ", createByOrgName='" + getCreateByOrgName() + "'" +
            "}";
    }
}
