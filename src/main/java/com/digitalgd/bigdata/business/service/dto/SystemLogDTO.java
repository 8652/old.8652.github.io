package com.digitalgd.bigdata.business.service.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.digitalgd.bigdata.business.domain.SystemLog} entity.
 */
public class SystemLogDTO implements Serializable {
    
    private Long id;

    /**
     * 操作人姓名
     */
    @NotNull
    @Size(max = 20)
    @ApiModelProperty(value = "操作人姓名", required = true)
    private String operatorName;

    /**
     * 操作人id
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "操作人id", required = true)
    private String operatorId;

    /**
     * 操作人组织名称
     */
    @Size(max = 20)
    @ApiModelProperty(value = "操作人组织名称")
    private String operatorDeptName;

    /**
     * 操作人组织id
     */
    @Size(max = 40)
    @ApiModelProperty(value = "操作人组织id")
    private String operatorDeptId;

    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private ZonedDateTime operateTime;

    /**
     * 操作类型
     */
    @Size(max = 40)
    @ApiModelProperty(value = "操作类型")
    private String operateType;

    /**
     * 操作内容
     */
    @Size(max = 40)
    @ApiModelProperty(value = "操作内容")
    private String content;

    /**
     * 备注
     */
    @Size(max = 40)
    @ApiModelProperty(value = "备注")
    private String memo;

    /**
     * 接口参数json串
     */
    @Size(max = 40)
    @ApiModelProperty(value = "接口参数json串")
    private String opreateParams;

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

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorDeptName() {
        return operatorDeptName;
    }

    public void setOperatorDeptName(String operatorDeptName) {
        this.operatorDeptName = operatorDeptName;
    }

    public String getOperatorDeptId() {
        return operatorDeptId;
    }

    public void setOperatorDeptId(String operatorDeptId) {
        this.operatorDeptId = operatorDeptId;
    }

    public ZonedDateTime getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(ZonedDateTime operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOpreateParams() {
        return opreateParams;
    }

    public void setOpreateParams(String opreateParams) {
        this.opreateParams = opreateParams;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SystemLogDTO)) {
            return false;
        }

        return id != null && id.equals(((SystemLogDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SystemLogDTO{" +
            "id=" + getId() +
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
