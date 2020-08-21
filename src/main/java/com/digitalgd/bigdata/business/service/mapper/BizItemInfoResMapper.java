package com.digitalgd.bigdata.business.service.mapper;


import com.digitalgd.bigdata.business.domain.*;
import com.digitalgd.bigdata.business.service.dto.BizItemInfoResDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link BizItemInfoRes} and its DTO {@link BizItemInfoResDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BizItemInfoResMapper extends EntityMapper<BizItemInfoResDTO, BizItemInfoRes> {



    default BizItemInfoRes fromId(Long id) {
        if (id == null) {
            return null;
        }
        BizItemInfoRes bizItemInfoRes = new BizItemInfoRes();
        bizItemInfoRes.setId(id);
        return bizItemInfoRes;
    }
}
