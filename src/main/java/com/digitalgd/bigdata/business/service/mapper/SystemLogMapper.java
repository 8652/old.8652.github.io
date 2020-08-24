package com.digitalgd.bigdata.business.service.mapper;


import com.digitalgd.bigdata.business.domain.*;
import com.digitalgd.bigdata.business.service.dto.SystemLogDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SystemLog} and its DTO {@link SystemLogDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SystemLogMapper extends EntityMapper<SystemLogDTO, SystemLog> {



    default SystemLog fromId(Long id) {
        if (id == null) {
            return null;
        }
        SystemLog systemLog = new SystemLog();
        systemLog.setId(id);
        return systemLog;
    }
}
