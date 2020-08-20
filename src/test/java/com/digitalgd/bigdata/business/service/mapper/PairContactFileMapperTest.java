package com.digitalgd.bigdata.business.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PairContactFileMapperTest {

    private PairContactFileMapper pairContactFileMapper;

    @BeforeEach
    public void setUp() {
        pairContactFileMapper = new PairContactFileMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(pairContactFileMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(pairContactFileMapper.fromId(null)).isNull();
    }
}
