package com.digitalgd.bigdata.business.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthLetterRecordMapperTest {

    private AuthLetterRecordMapper authLetterRecordMapper;

    @BeforeEach
    public void setUp() {
        authLetterRecordMapper = new AuthLetterRecordMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(authLetterRecordMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(authLetterRecordMapper.fromId(null)).isNull();
    }
}
