package com.digitalgd.bigdata.business.service.mapper;


import com.digitalgd.bigdata.business.domain.*;
import com.digitalgd.bigdata.business.service.dto.AuthLetterRecordDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AuthLetterRecord} and its DTO {@link AuthLetterRecordDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AuthLetterRecordMapper extends EntityMapper<AuthLetterRecordDTO, AuthLetterRecord> {



    default AuthLetterRecord fromId(Long id) {
        if (id == null) {
            return null;
        }
        AuthLetterRecord authLetterRecord = new AuthLetterRecord();
        authLetterRecord.setId(id);
        return authLetterRecord;
    }
}
