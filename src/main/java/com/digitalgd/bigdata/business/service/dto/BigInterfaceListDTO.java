package com.digitalgd.bigdata.business.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.digitalgd.bigdata.business.domain.BigInterfaceList} entity.
 */
@ApiModel(description = "@Description: 数据接口控制表\n@Version: V1.0")
public class BigInterfaceListDTO implements Serializable {
    
    private Long id;

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
     * 数据提供方id列表（以逗号间隔）
     */
    @Size(max = 40)
    @ApiModelProperty(value = "数据提供方id列表（以逗号间隔）")
    private String dataProvIds;

    /**
     * 数据提供方名称列表（以逗号间隔）
     */
    @Size(max = 500)
    @ApiModelProperty(value = "数据提供方名称列表（以逗号间隔）")
    private String dataProvNames;

    /**
     * 大数据中心对应接口
     */
    @NotNull
    @Size(max = 300)
    @ApiModelProperty(value = "大数据中心对应接口", required = true)
    private String bigInterface;

    /**
     * 本地接口地址
     */
    @Size(max = 100)
    @ApiModelProperty(value = "本地接口地址")
    private String localPath;

    /**
     * 大数据接口地址列表
     */
    @Size(max = 500)
    @ApiModelProperty(value = "大数据接口地址列表")
    private String providePath;

    /**
     * 说明描述
     */
    @Size(max = 300)
    @ApiModelProperty(value = "说明描述")
    private String interfaceDesc;

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

    public String getDataProvNames() {
        return dataProvNames;
    }

    public void setDataProvNames(String dataProvNames) {
        this.dataProvNames = dataProvNames;
    }

    public String getBigInterface() {
        return bigInterface;
    }

    public void setBigInterface(String bigInterface) {
        this.bigInterface = bigInterface;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getProvidePath() {
        return providePath;
    }

    public void setProvidePath(String providePath) {
        this.providePath = providePath;
    }

    public String getInterfaceDesc() {
        return interfaceDesc;
    }

    public void setInterfaceDesc(String interfaceDesc) {
        this.interfaceDesc = interfaceDesc;
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
        if (!(o instanceof BigInterfaceListDTO)) {
            return false;
        }

        return id != null && id.equals(((BigInterfaceListDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BigInterfaceListDTO{" +
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
