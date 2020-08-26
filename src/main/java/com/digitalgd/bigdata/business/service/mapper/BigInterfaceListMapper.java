package com.digitalgd.bigdata.business.service.mapper;


import com.digitalgd.bigdata.business.domain.*;
import com.digitalgd.bigdata.business.service.dto.BigInterfaceListDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link BigInterfaceList} and its DTO {@link BigInterfaceListDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BigInterfaceListMapper extends EntityMapper<BigInterfaceListDTO, BigInterfaceList> {



    default BigInterfaceList fromId(Long id) {
        if (id == null) {
            return null;
        }
        BigInterfaceList bigInterfaceList = new BigInterfaceList();
        bigInterfaceList.setId(id);
        return bigInterfaceList;
    }
}
