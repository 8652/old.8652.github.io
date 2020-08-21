package com.digitalgd.bigdata.business.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.digitalgd.bigdata.business.domain.BizItem} entity.
 */
@ApiModel(description = "@Description: 业务事项\n@Version: V1.0")
public class BizItemDTO implements Serializable {
    
    private Long id;

    /**
     * 业务事项编码
     */
    @NotNull
    @Size(max = 8)
    @ApiModelProperty(value = "业务事项编码", required = true)
    private String itemCode;

    /**
     * 业务事项名称
     */
    @NotNull
    @Size(max = 100)
    @ApiModelProperty(value = "业务事项名称", required = true)
    private String itemName;

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
     * 开放利用协议(双方授权协议)id
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "开放利用协议(双方授权协议)id", required = true)
    private String pairContractId;

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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public String getPairContractId() {
        return pairContractId;
    }

    public void setPairContractId(String pairContractId) {
        this.pairContractId = pairContractId;
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
        if (!(o instanceof BizItemDTO)) {
            return false;
        }

        return id != null && id.equals(((BizItemDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BizItemDTO{" +
            "id=" + getId() +
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
