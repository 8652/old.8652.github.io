package com.digitalgd.bigdata.business.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BigInterfaceListMapperTest {

    private BigInterfaceListMapper bigInterfaceListMapper;

    @BeforeEach
    public void setUp() {
        bigInterfaceListMapper = new BigInterfaceListMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(bigInterfaceListMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(bigInterfaceListMapper.fromId(null)).isNull();
    }
}
