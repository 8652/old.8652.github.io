package com.digitalgd.bigdata.business.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link com.digitalgd.bigdata.business.domain.BigInterfaceLog} entity.
 */
@ApiModel(description = "@Description: 数据调用记录表\n@Version: V1.0")
public class BigInterfaceLogDTO implements Serializable {
    
    private Long id;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private UUID pkid;

    /**
     * 应用接入账号
     */
    @Size(max = 40)
    @ApiModelProperty(value = "应用接入账号")
    private String appKey;

    /**
     * 数据接入方
     */
    @NotNull
    @Size(max = 50)
    @ApiModelProperty(value = "数据接入方", required = true)
    private String consumerName;

    /**
     * 接口id
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "接口id", required = true)
    private String interfaceId;

    /**
     * 服务接口接口编码
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "服务接口接口编码", required = true)
    private String interfaceCode;

    /**
     * 服务接口名字
     */
    @NotNull
    @Size(max = 100)
    @ApiModelProperty(value = "服务接口名字", required = true)
    private String interfaceName;

    /**
     * 数据提供方编码（列表，以逗号间隔）
     */
    @NotNull
    @Size(max = 300)
    @ApiModelProperty(value = "数据提供方编码（列表，以逗号间隔）", required = true)
    private String dataProvIds;

    /**
     * 接口调用时间
     */
    @ApiModelProperty(value = "接口调用时间")
    private ZonedDateTime useTime;

    /**
     * 接口调用状态
     */
    @Size(max = 10)
    @ApiModelProperty(value = "接口调用状态")
    private String status;

    /**
     * 本地接口路径
     */
    @Size(max = 100)
    @ApiModelProperty(value = "本地接口路径")
    private String interfacePath;

    /**
     * 全局唯一id
     */
    @Size(max = 40)
    @ApiModelProperty(value = "全局唯一id")
    private String globalUniqueId;

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

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getPkid() {
        return pkid;
    }

    public void setPkid(UUID pkid) {
        this.pkid = pkid;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getDataProvIds() {
        return dataProvIds;
    }

    public void setDataProvIds(String dataProvIds) {
        this.dataProvIds = dataProvIds;
    }

    public ZonedDateTime getUseTime() {
        return useTime;
    }

    public void setUseTime(ZonedDateTime useTime) {
        this.useTime = useTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInterfacePath() {
        return interfacePath;
    }

    public void setInterfacePath(String interfacePath) {
        this.interfacePath = interfacePath;
    }

    public String getGlobalUniqueId() {
        return globalUniqueId;
    }

    public void setGlobalUniqueId(String globalUniqueId) {
        this.globalUniqueId = globalUniqueId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BigInterfaceLogDTO)) {
            return false;
        }

        return id != null && id.equals(((BigInterfaceLogDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BigInterfaceLogDTO{" +
            "id=" + getId() +
            ", pkid='" + getPkid() + "'" +
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
