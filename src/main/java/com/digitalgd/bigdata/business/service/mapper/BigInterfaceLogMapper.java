package com.digitalgd.bigdata.business.service.mapper;


import com.digitalgd.bigdata.business.domain.*;
import com.digitalgd.bigdata.business.service.dto.BigInterfaceLogDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link BigInterfaceLog} and its DTO {@link BigInterfaceLogDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BigInterfaceLogMapper extends EntityMapper<BigInterfaceLogDTO, BigInterfaceLog> {



    default BigInterfaceLog fromId(Long id) {
        if (id == null) {
            return null;
        }
        BigInterfaceLog bigInterfaceLog = new BigInterfaceLog();
        bigInterfaceLog.setId(id);
        return bigInterfaceLog;
    }
}
