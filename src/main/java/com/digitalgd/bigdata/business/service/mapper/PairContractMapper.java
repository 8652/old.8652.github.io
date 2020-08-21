package com.digitalgd.bigdata.business.service.mapper;


import com.digitalgd.bigdata.business.domain.*;
import com.digitalgd.bigdata.business.service.dto.PairContractDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PairContract} and its DTO {@link PairContractDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PairContractMapper extends EntityMapper<PairContractDTO, PairContract> {



    default PairContract fromId(Long id) {
        if (id == null) {
            return null;
        }
        PairContract pairContract = new PairContract();
        pairContract.setId(id);
        return pairContract;
    }
}
