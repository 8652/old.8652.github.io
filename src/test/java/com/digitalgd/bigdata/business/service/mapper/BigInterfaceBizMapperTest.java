package com.digitalgd.bigdata.business.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BigInterfaceBizMapperTest {

    private BigInterfaceBizMapper bigInterfaceBizMapper;

    @BeforeEach
    public void setUp() {
        bigInterfaceBizMapper = new BigInterfaceBizMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(bigInterfaceBizMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(bigInterfaceBizMapper.fromId(null)).isNull();
    }
}
