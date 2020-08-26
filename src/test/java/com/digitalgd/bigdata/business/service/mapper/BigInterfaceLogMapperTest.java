package com.digitalgd.bigdata.business.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BigInterfaceLogMapperTest {

    private BigInterfaceLogMapper bigInterfaceLogMapper;

    @BeforeEach
    public void setUp() {
        bigInterfaceLogMapper = new BigInterfaceLogMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(bigInterfaceLogMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(bigInterfaceLogMapper.fromId(null)).isNull();
    }
}
