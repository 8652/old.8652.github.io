package com.digitalgd.bigdata.business.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PairContractFileMapperTest {

    private PairContractFileMapper pairContractFileMapper;

    @BeforeEach
    public void setUp() {
        pairContractFileMapper = new PairContractFileMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(pairContractFileMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(pairContractFileMapper.fromId(null)).isNull();
    }
}
