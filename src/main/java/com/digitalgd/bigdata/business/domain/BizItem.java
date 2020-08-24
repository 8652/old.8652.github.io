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
 * @Description: 业务事项\n@Version: V1.0
 */
@Entity
@Table(name = "biz_item")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BizItem implements Serializable {

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
     * 业务事项编码
     */
    @NotNull
    @Size(max = 8)
    @Column(name = "item_code", length = 8, nullable = false)
    private String itemCode;

    /**
     * 业务事项名称
     */
    @NotNull
    @Size(max = 100)
    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    /**
     * 数据提供方编码（列表，以逗号间隔）
     */
    @NotNull
    @Size(max = 300)
    @Column(name = "data_prov_ids", length = 300, nullable = false)
    private String dataProvIds;

    /**
     * 数据提供方名称（列表，以逗号间隔）
     */
    @NotNull
    @Size(max = 500)
    @Column(name = "data_prov_names", length = 500, nullable = false)
    private String dataProvNames;

    /**
     * 数据接入方名称
     */
    @NotNull
    @Size(max = 50)
    @Column(name = "consumer_name", length = 50, nullable = false)
    private String consumerName;

    /**
     * 数据接入方统一社会信用代码
     */
    @NotNull
    @Size(max = 50)
    @Column(name = "consumer_code", length = 50, nullable = false)
    private String consumerCode;

    /**
     * 开放利用协议(双方授权协议)id
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "pair_contract_id", length = 40, nullable = false)
    private String pairContractId;

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

    public BizItem pkid(UUID pkid) {
        this.pkid = pkid;
        return this;
    }

    public void setPkid(UUID pkid) {
        this.pkid = pkid;
    }

    public String getItemCode() {
        return itemCode;
    }

    public BizItem itemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public BizItem itemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDataProvIds() {
        return dataProvIds;
    }

    public BizItem dataProvIds(String dataProvIds) {
        this.dataProvIds = dataProvIds;
        return this;
    }

    public void setDataProvIds(String dataProvIds) {
        this.dataProvIds = dataProvIds;
    }

    public String getDataProvNames() {
        return dataProvNames;
    }

    public BizItem dataProvNames(String dataProvNames) {
        this.dataProvNames = dataProvNames;
        return this;
    }

    public void setDataProvNames(String dataProvNames) {
        this.dataProvNames = dataProvNames;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public BizItem consumerName(String consumerName) {
        this.consumerName = consumerName;
        return this;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerCode() {
        return consumerCode;
    }

    public BizItem consumerCode(String consumerCode) {
        this.consumerCode = consumerCode;
        return this;
    }

    public void setConsumerCode(String consumerCode) {
        this.consumerCode = consumerCode;
    }

    public String getPairContractId() {
        return pairContractId;
    }

    public BizItem pairContractId(String pairContractId) {
        this.pairContractId = pairContractId;
        return this;
    }

    public void setPairContractId(String pairContractId) {
        this.pairContractId = pairContractId;
    }

    public Boolean isDelFlag() {
        return delFlag;
    }

    public BizItem delFlag(Boolean delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public BizItem createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateById() {
        return createById;
    }

    public BizItem createById(String createById) {
        this.createById = createById;
        return this;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public BizItem createByName(String createByName) {
        this.createByName = createByName;
        return this;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getCreateByOrgId() {
        return createByOrgId;
    }

    public BizItem createByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
        return this;
    }

    public void setCreateByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
    }

    public String getCreateByOrgName() {
        return createByOrgName;
    }

    public BizItem createByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
        return this;
    }

    public void setCreateByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
    }

    public ZonedDateTime getLastUpTime() {
        return lastUpTime;
    }

    public BizItem lastUpTime(ZonedDateTime lastUpTime) {
        this.lastUpTime = lastUpTime;
        return this;
    }

    public void setLastUpTime(ZonedDateTime lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    public String getLastUpId() {
        return lastUpId;
    }

    public BizItem lastUpId(String lastUpId) {
        this.lastUpId = lastUpId;
        return this;
    }

    public void setLastUpId(String lastUpId) {
        this.lastUpId = lastUpId;
    }

    public String getLastUpName() {
        return lastUpName;
    }

    public BizItem lastUpName(String lastUpName) {
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
        if (!(o instanceof BizItem)) {
            return false;
        }
        return id != null && id.equals(((BizItem) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BizItem{" +
            "id=" + getId() +
            ", pkid='" + getPkid() + "'" +
            ", itemCode='" + getItemCode() + "'" +
            ", itemName='" + getItemName() + "'" +
            ", dataProvIds='" + getDataProvIds() + "'" +
            ", dataProvNames='" + getDataProvNames() + "'" +
            ", consumerName='" + getConsumerName() + "'" +
            ", consumerCode='" + getConsumerCode() + "'" +
            ", pairContractId='" + getPairContractId() + "'" +
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
