package com.digitalgd.bigdata.business.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.digitalgd.bigdata.business.domain.PairContractFile} entity.
 */
@ApiModel(description = "@Description: 开放利用协议扫描附件\n@Version: V1.0")
public class PairContractFileDTO implements Serializable {
    
    private Long id;

    /**
     * 开放利用协议id
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "开放利用协议id", required = true)
    private String pairContractId;

    /**
     * 协议文件id
     */
    @Size(max = 40)
    @ApiModelProperty(value = "协议文件id")
    private String fileId;

    /**
     * 协议文件类型
     */
    @Size(max = 10)
    @ApiModelProperty(value = "协议文件类型")
    private String fileType;

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

    public String getPairContractId() {
        return pairContractId;
    }

    public void setPairContractId(String pairContractId) {
        this.pairContractId = pairContractId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
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
            ", pairContractId='" + getPairContractId() + "'" +
            ", fileId='" + getFileId() + "'" +
            ", fileType='" + getFileType() + "'" +
            ", filePath='" + getFilePath() + "'" +
            ", fileName='" + getFileName() + "'" +
            ", delFlag='" + isDelFlag() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            "}";
    }
}
