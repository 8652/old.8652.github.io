package com.digitalgd.bigdata.business.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link com.digitalgd.bigdata.business.domain.PairContractFile} entity.
 */
@ApiModel(description = "@Description: 开放利用协议扫描附件\n@Version: V1.0")
public class PairContractFileDTO implements Serializable {
    
    private Long id;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private UUID pkid;

    /**
     * 开放利用协议id
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "开放利用协议id", required = true)
    private String pairContractId;

    /**
     * 协议文件地址
     */
    @Size(max = 200)
    @ApiModelProperty(value = "协议文件地址")
    private String filePath;

    /**
     * 协议文件名称
     */
    @Size(max = 50)
    @ApiModelProperty(value = "协议文件名称")
    private String fileName;

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

    public String getPairContractId() {
        return pairContractId;
    }

    public void setPairContractId(String pairContractId) {
        this.pairContractId = pairContractId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PairContractFileDTO)) {
            return false;
        }

        return id != null && id.equals(((PairContractFileDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PairContractFileDTO{" +
            "id=" + getId() +
            ", pkid='" + getPkid() + "'" +
            ", pairContractId='" + getPairContractId() + "'" +
            ", filePath='" + getFilePath() + "'" +
            ", fileName='" + getFileName() + "'" +
            ", delFlag='" + isDelFlag() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            "}";
    }
}