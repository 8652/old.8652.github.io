package com.digitalgd.bigdata.business.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * @Description: 数据接口控制表\n@Version: V1.0
 */
@Entity
@Table(name = "big_interface_list")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BigInterfaceList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * 数据提供方id列表（以逗号间隔）
     */
    @Size(max = 40)
    @Column(name = "data_prov_ids", length = 40)
    private String dataProvIds;

    /**
     * 数据提供方名称列表（以逗号间隔）
     */
    @Size(max = 500)
    @Column(name = "data_prov_names", length = 500)
    private String dataProvNames;

    /**
     * 大数据中心对应接口
     */
    @NotNull
    @Size(max = 300)
    @Column(name = "big_interface", length = 300, nullable = false)
    private String bigInterface;

    /**
     * 本地接口地址
     */
    @Size(max = 100)
    @Column(name = "local_path", length = 100)
    private String localPath;

    /**
     * 大数据接口地址列表
     */
    @Size(max = 500)
    @Column(name = "provide_path", length = 500)
    private String providePath;

    /**
     * 说明描述
     */
    @Size(max = 300)
    @Column(name = "interface_desc", length = 300)
    private String interfaceDesc;

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

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public BigInterfaceList interfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
        return this;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public BigInterfaceList interfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
        return this;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getDataProvIds() {
        return dataProvIds;
    }

    public BigInterfaceList dataProvIds(String dataProvIds) {
        this.dataProvIds = dataProvIds;
        return this;
    }

    public void setDataProvIds(String dataProvIds) {
        this.dataProvIds = dataProvIds;
    }

    public String getDataProvNames() {
        return dataProvNames;
    }

    public BigInterfaceList dataProvNames(String dataProvNames) {
        this.dataProvNames = dataProvNames;
        return this;
    }

    public void setDataProvNames(String dataProvNames) {
        this.dataProvNames = dataProvNames;
    }

    public String getBigInterface() {
        return bigInterface;
    }

    public BigInterfaceList bigInterface(String bigInterface) {
        this.bigInterface = bigInterface;
        return this;
    }

    public void setBigInterface(String bigInterface) {
        this.bigInterface = bigInterface;
    }

    public String getLocalPath() {
        return localPath;
    }

    public BigInterfaceList localPath(String localPath) {
        this.localPath = localPath;
        return this;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getProvidePath() {
        return providePath;
    }

    public BigInterfaceList providePath(String providePath) {
        this.providePath = providePath;
        return this;
    }

    public void setProvidePath(String providePath) {
        this.providePath = providePath;
    }

    public String getInterfaceDesc() {
        return interfaceDesc;
    }

    public BigInterfaceList interfaceDesc(String interfaceDesc) {
        this.interfaceDesc = interfaceDesc;
        return this;
    }

    public void setInterfaceDesc(String interfaceDesc) {
        this.interfaceDesc = interfaceDesc;
    }

    public Boolean isDelFlag() {
        return delFlag;
    }

    public BigInterfaceList delFlag(Boolean delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public BigInterfaceList createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateById() {
        return createById;
    }

    public BigInterfaceList createById(String createById) {
        this.createById = createById;
        return this;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public BigInterfaceList createByName(String createByName) {
        this.createByName = createByName;
        return this;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getCreateByOrgId() {
        return createByOrgId;
    }

    public BigInterfaceList createByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
        return this;
    }

    public void setCreateByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
    }

    public String getCreateByOrgName() {
        return createByOrgName;
    }

    public BigInterfaceList createByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
        return this;
    }

    public void setCreateByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
    }

    public ZonedDateTime getLastUpTime() {
        return lastUpTime;
    }

    public BigInterfaceList lastUpTime(ZonedDateTime lastUpTime) {
        this.lastUpTime = lastUpTime;
        return this;
    }

    public void setLastUpTime(ZonedDateTime lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    public String getLastUpId() {
        return lastUpId;
    }

    public BigInterfaceList lastUpId(String lastUpId) {
        this.lastUpId = lastUpId;
        return this;
    }

    public void setLastUpId(String lastUpId) {
        this.lastUpId = lastUpId;
    }

    public String getLastUpName() {
        return lastUpName;
    }

    public BigInterfaceList lastUpName(String lastUpName) {
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
        if (!(o instanceof BigInterfaceList)) {
            return false;
        }
        return id != null && id.equals(((BigInterfaceList) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BigInterfaceList{" +
            "id=" + getId() +
            ", interfaceCode='" + getInterfaceCode() + "'" +
            ", interfaceName='" + getInterfaceName() + "'" +
            ", dataProvIds='" + getDataProvIds() + "'" +
            ", dataProvNames='" + getDataProvNames() + "'" +
            ", bigInterface='" + getBigInterface() + "'" +
            ", localPath='" + getLocalPath() + "'" +
            ", providePath='" + getProvidePath() + "'" +
            ", interfaceDesc='" + getInterfaceDesc() + "'" +
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
