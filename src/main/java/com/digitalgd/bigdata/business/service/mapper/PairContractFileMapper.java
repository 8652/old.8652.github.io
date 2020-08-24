package com.digitalgd.bigdata.business.service.mapper;


import com.digitalgd.bigdata.business.domain.*;
import com.digitalgd.bigdata.business.service.dto.PairContractFileDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PairContractFile} and its DTO {@link PairContractFileDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PairContractFileMapper extends EntityMapper<PairContractFileDTO, PairContractFile> {



    default PairContractFile fromId(Long id) {
        if (id == null) {
            return null;
        }
        PairContractFile pairContractFile = new PairContractFile();
        pairContractFile.setId(id);
        return pairContractFile;
    }
}
