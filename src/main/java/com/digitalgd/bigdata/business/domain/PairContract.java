package com.digitalgd.bigdata.business.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * @Description: 开放利用协议（双方授权协议）\n@Version: V1.0
 */
@Entity
@Table(name = "pair_contract")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PairContract implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 主键
     */
    @Size(max = 40)
    @Column(name = "pkid", length = 40)
    private String pkid;

    /**
     * 协议名称
     */
    @NotNull
    @Size(max = 100)
    @Column(name = "contract_name", length = 100, nullable = false)
    private String contractName;

    /**
     * 协议编码
     */
    @NotNull
    @Size(max = 6)
    @Column(name = "contract_code", length = 6, nullable = false)
    private String contractCode;

    /**
     * 协议状态
     */
    @NotNull
    @Size(max = 10)
    @Column(name = "contract_status", length = 10, nullable = false)
    private String contractStatus;

    /**
     * 协议说明
     */
    @Size(max = 500)
    @Column(name = "contract_desc", length = 500)
    private String contractDesc;

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
     * 数据接入方账号
     */
    @Size(max = 40)
    @Column(name = "consumer_account", length = 40)
    private String consumerAccount;

    /**
     * 生效时间
     */
    @Column(name = "start_time")
    private ZonedDateTime startTime;

    /**
     * 失效时间
     */
    @Column(name = "end_time")
    private ZonedDateTime endTime;

    /**
     * 公钥
     */
    @Size(max = 1000)
    @Column(name = "public_key", length = 1000)
    private String publicKey;

    /**
     * 私钥
     */
    @Size(max = 1000)
    @Column(name = "private_key", length = 1000)
    private String privateKey;

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

    public String getPkid() {
        return pkid;
    }

    public PairContract pkid(String pkid) {
        this.pkid = pkid;
        return this;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }

    public String getContractName() {
        return contractName;
    }

    public PairContract contractName(String contractName) {
        this.contractName = contractName;
        return this;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractCode() {
        return contractCode;
    }

    public PairContract contractCode(String contractCode) {
        this.contractCode = contractCode;
        return this;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public PairContract contractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
        return this;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getContractDesc() {
        return contractDesc;
    }

    public PairContract contractDesc(String contractDesc) {
        this.contractDesc = contractDesc;
        return this;
    }

    public void setContractDesc(String contractDesc) {
        this.contractDesc = contractDesc;
    }

    public String getDataProvIds() {
        return dataProvIds;
    }

    public PairContract dataProvIds(String dataProvIds) {
        this.dataProvIds = dataProvIds;
        return this;
    }

    public void setDataProvIds(String dataProvIds) {
        this.dataProvIds = dataProvIds;
    }

    public String getDataProvNames() {
        return dataProvNames;
    }

    public PairContract dataProvNames(String dataProvNames) {
        this.dataProvNames = dataProvNames;
        return this;
    }

    public void setDataProvNames(String dataProvNames) {
        this.dataProvNames = dataProvNames;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public PairContract consumerName(String consumerName) {
        this.consumerName = consumerName;
        return this;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerCode() {
        return consumerCode;
    }

    public PairContract consumerCode(String consumerCode) {
        this.consumerCode = consumerCode;
        return this;
    }

    public void setConsumerCode(String consumerCode) {
        this.consumerCode = consumerCode;
    }

    public String getConsumerAccount() {
        return consumerAccount;
    }

    public PairContract consumerAccount(String consumerAccount) {
        this.consumerAccount = consumerAccount;
        return this;
    }

    public void setConsumerAccount(String consumerAccount) {
        this.consumerAccount = consumerAccount;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public PairContract startTime(ZonedDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public PairContract endTime(ZonedDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public PairContract publicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public PairContract privateKey(String privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public Boolean isDelFlag() {
        return delFlag;
    }

    public PairContract delFlag(Boolean delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public PairContract createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateById() {
        return createById;
    }

    public PairContract createById(String createById) {
        this.createById = createById;
        return this;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public PairContract createByName(String createByName) {
        this.createByName = createByName;
        return this;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getCreateByOrgId() {
        return createByOrgId;
    }

    public PairContract createByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
        return this;
    }

    public void setCreateByOrgId(String createByOrgId) {
        this.createByOrgId = createByOrgId;
    }

    public String getCreateByOrgName() {
        return createByOrgName;
    }

    public PairContract createByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
        return this;
    }

    public void setCreateByOrgName(String createByOrgName) {
        this.createByOrgName = createByOrgName;
    }

    public ZonedDateTime getLastUpTime() {
        return lastUpTime;
    }

    public PairContract lastUpTime(ZonedDateTime lastUpTime) {
        this.lastUpTime = lastUpTime;
        return this;
    }

    public void setLastUpTime(ZonedDateTime lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    public String getLastUpId() {
        return lastUpId;
    }

    public PairContract lastUpId(String lastUpId) {
        this.lastUpId = lastUpId;
        return this;
    }

    public void setLastUpId(String lastUpId) {
        this.lastUpId = lastUpId;
    }

    public String getLastUpName() {
        return lastUpName;
    }

    public PairContract lastUpName(String lastUpName) {
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
        if (!(o instanceof PairContract)) {
            return false;
        }
        return id != null && id.equals(((PairContract) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PairContract{" +
            "id=" + getId() +
            ", pkid='" + getPkid() + "'" +
            ", contractName='" + getContractName() + "'" +
            ", contractCode='" + getContractCode() + "'" +
            ", contractStatus='" + getContractStatus() + "'" +
            ", contractDesc='" + getContractDesc() + "'" +
            ", dataProvIds='" + getDataProvIds() + "'" +
            ", dataProvNames='" + getDataProvNames() + "'" +
            ", consumerName='" + getConsumerName() + "'" +
            ", consumerCode='" + getConsumerCode() + "'" +
            ", consumerAccount='" + getConsumerAccount() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", publicKey='" + getPublicKey() + "'" +
            ", privateKey='" + getPrivateKey() + "'" +
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
