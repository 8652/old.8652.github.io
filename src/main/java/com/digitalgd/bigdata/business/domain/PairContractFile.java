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
 * @Description: 开放利用协议扫描附件\n@Version: V1.0
 */
@Entity
@Table(name = "pair_contract_file")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PairContractFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 主键id
     */
    @Type(type = "uuid-char")
    @Column(name = "pkid", length = 36)
    private UUID pkid;

    /**
     * 开放利用协议id
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "pair_contract_id", length = 40, nullable = false)
    private String pairContractId;

    /**
     * 协议文件地址
     */
    @Size(max = 200)
    @Column(name = "file_path", length = 200)
    private String filePath;

    /**
     * 协议文件名称
     */
    @Size(max = 50)
    @Column(name = "file_name", length = 50)
    private String fileName;

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

    public PairContractFile pkid(UUID pkid) {
        this.pkid = pkid;
        return this;
    }

    public void setPkid(UUID pkid) {
        this.pkid = pkid;
    }

    public String getPairContractId() {
        return pairContractId;
    }

    public PairContractFile pairContractId(String pairContractId) {
        this.pairContractId = pairContractId;
        return this;
    }

    public void setPairContractId(String pairContractId) {
        this.pairContractId = pairContractId;
    }

    public String getFilePath() {
        return filePath;
    }

    public PairContractFile filePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public PairContractFile fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Boolean isDelFlag() {
        return delFlag;
    }

    public PairContractFile delFlag(Boolean delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public PairContractFile createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PairContractFile)) {
            return false;
        }
        return id != null && id.equals(((PairContractFile) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PairContractFile{" +
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
