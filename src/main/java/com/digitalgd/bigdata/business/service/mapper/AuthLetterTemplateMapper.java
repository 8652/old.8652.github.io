package com.digitalgd.bigdata.business.service.mapper;


import com.digitalgd.bigdata.business.domain.*;
import com.digitalgd.bigdata.business.service.dto.AuthLetterTemplateDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AuthLetterTemplate} and its DTO {@link AuthLetterTemplateDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AuthLetterTemplateMapper extends EntityMapper<AuthLetterTemplateDTO, AuthLetterTemplate> {



    default AuthLetterTemplate fromId(Long id) {
        if (id == null) {
            return null;
        }
        AuthLetterTemplate authLetterTemplate = new AuthLetterTemplate();
        authLetterTemplate.setId(id);
        return authLetterTemplate;
    }
}
