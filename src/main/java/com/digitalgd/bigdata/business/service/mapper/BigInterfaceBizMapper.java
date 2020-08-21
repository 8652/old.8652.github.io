package com.digitalgd.bigdata.business.service.mapper;


import com.digitalgd.bigdata.business.domain.*;
import com.digitalgd.bigdata.business.service.dto.BigInterfaceBizDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link BigInterfaceBiz} and its DTO {@link BigInterfaceBizDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BigInterfaceBizMapper extends EntityMapper<BigInterfaceBizDTO, BigInterfaceBiz> {



    default BigInterfaceBiz fromId(Long id) {
        if (id == null) {
            return null;
        }
        BigInterfaceBiz bigInterfaceBiz = new BigInterfaceBiz();
        bigInterfaceBiz.setId(id);
        return bigInterfaceBiz;
    }
}
