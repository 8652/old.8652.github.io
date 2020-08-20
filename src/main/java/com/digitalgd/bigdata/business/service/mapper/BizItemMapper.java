package com.digitalgd.bigdata.business.service.mapper;


import com.digitalgd.bigdata.business.domain.*;
import com.digitalgd.bigdata.business.service.dto.BizItemDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link BizItem} and its DTO {@link BizItemDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BizItemMapper extends EntityMapper<BizItemDTO, BizItem> {



    default BizItem fromId(Long id) {
        if (id == null) {
            return null;
        }
        BizItem bizItem = new BizItem();
        bizItem.setId(id);
        return bizItem;
    }
}
