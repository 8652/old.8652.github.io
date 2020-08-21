package com.digitalgd.bigdata.business.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BizItemMapperTest {

    private BizItemMapper bizItemMapper;

    @BeforeEach
    public void setUp() {
        bizItemMapper = new BizItemMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(bizItemMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(bizItemMapper.fromId(null)).isNull();
    }
}
