package com.digitalgd.bigdata.business.service.mapper;


import com.digitalgd.bigdata.business.domain.*;
import com.digitalgd.bigdata.business.service.dto.PairContactFileDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PairContactFile} and its DTO {@link PairContactFileDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PairContactFileMapper extends EntityMapper<PairContactFileDTO, PairContactFile> {



    default PairContactFile fromId(Long id) {
        if (id == null) {
            return null;
        }
        PairContactFile pairContactFile = new PairContactFile();
        pairContactFile.setId(id);
        return pairContactFile;
    }
}
