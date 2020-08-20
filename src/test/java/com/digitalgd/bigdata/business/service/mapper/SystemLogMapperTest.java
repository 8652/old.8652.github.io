package com.digitalgd.bigdata.business.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SystemLogMapperTest {

    private SystemLogMapper systemLogMapper;

    @BeforeEach
    public void setUp() {
        systemLogMapper = new SystemLogMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(systemLogMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(systemLogMapper.fromId(null)).isNull();
    }
}
