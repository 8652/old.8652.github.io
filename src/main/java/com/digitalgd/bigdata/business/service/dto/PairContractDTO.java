package com.digitalgd.bigdata.business.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.digitalgd.bigdata.business.domain.PairContract} entity.
 */
@ApiModel(description = "@Description: 开放利用协议（双方授权协议）\n@Version: V1.0")
public class PairContractDTO implements Serializable {
    
    private Long id;

    /**
     * 主键
     */
    @Size(max = 40)
    @ApiModelProperty(value = "主键")
    private String pkid;

    /**
     * 协议名称
     */
    @NotNull
    @Size(max = 100)
    @ApiModelProperty(value = "协议名称", required = true)
    private String contractName;

    /**
     * 协议编码
     */
    @NotNull
    @Size(max = 6)
    @ApiModelProperty(value = "协议编码", required = true)
    private String contractCode;

    /**
     * 协议状态
     */
    @NotNull
    @Size(max = 10)
    @ApiModelProperty(value = "协议状态", required = true)
    private String contractStatus;

    /**
     * 协议说明
     */
    @Size(max = 500)
    @ApiModelProperty(value = "协议说明")
    private String contractDesc;

    /**
     * 数据提供方编码（列表，以逗号间隔）
     */
    @NotNull
    @Size(max = 300)
    @ApiModelProperty(value = "数据提供方编码（列表，以逗号间隔）", required = true)
    private String dataProvIds;

    /**
     * 数据提供方名称（列表，以逗号间隔）
     */
    @NotNull
    @Size(max = 500)
    @ApiModelProperty(value = "数据提供方名称（列表，以逗号间隔）", required = true)
    private String dataProvNames;

    /**
     * 数据接入方名称
     */
    @NotNull
    @Size(max = 50)
    @ApiModelProperty(value = "数据接入方名称", required = true)
    private String consumerName;

    /**
     * 数据接入方统一社会信用代码
     */
    @NotNull
    @Size(max = 50)
    @ApiModelProperty(value = "数据接入方统一社会信用代码", required = true)
    private String consumerCode;

    /**
     * 数据接入方账号
     */
    @Size(max = 40)
    @ApiModelProperty(value = "数据接入方账号")
    private String consumerAccount;

    /**
     * 生效时间
     */
    @ApiModelProperty(value = "生效时间")
    private ZonedDateTime startTime;

    /**
     * 失效时间
     */
    @ApiModelProperty(value = "失效时间")
    private ZonedDateTime endTime;

    /**
     * 公钥
     */
    @Size(max = 1000)
    @ApiModelProperty(value = "公钥")
    private String publicKey;

    /**
     * 私钥
     */
    @Size(max = 1000)
    @ApiModelProperty(value = "私钥")
    private String privateKey;

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

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getContractDesc() {
        return contractDesc;
    }

    public void setContractDesc(String contractDesc) {
        this.contractDesc = contractDesc;
    }

    public String getDataProvIds() {
        return dataProvIds;
    }

    public void setDataProvIds(String dataProvIds) {
        this.dataProvIds = dataProvIds;
    }

    public String getDataProvNames() {
        return dataProvNames;
    }

    public void setDataProvNames(String dataProvNames) {
        this.dataProvNames = dataProvNames;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerCode() {
        return consumerCode;
    }

    public void setConsumerCode(String consumerCode) {
        this.consumerCode = consumerCode;
    }

    public String getConsumerAccount() {
        return consumerAccount;
    }

    public void setConsumerAccount(String consumerAccount) {
        this.consumerAccount = consumerAccount;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
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
        if (!(o instanceof PairContractDTO)) {
            return false;
        }

        return id != null && id.equals(((PairContractDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PairContractDTO{" +
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
