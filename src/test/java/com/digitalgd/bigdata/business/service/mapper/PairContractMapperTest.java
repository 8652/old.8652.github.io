package com.digitalgd.bigdata.business.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PairContractMapperTest {

    private PairContractMapper pairContractMapper;

    @BeforeEach
    public void setUp() {
        pairContractMapper = new PairContractMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(pairContractMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(pairContractMapper.fromId(null)).isNull();
    }
}
