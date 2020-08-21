package com.digitalgd.bigdata.business.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BizItemInfoResMapperTest {

    private BizItemInfoResMapper bizItemInfoResMapper;

    @BeforeEach
    public void setUp() {
        bizItemInfoResMapper = new BizItemInfoResMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(bizItemInfoResMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(bizItemInfoResMapper.fromId(null)).isNull();
    }
}
