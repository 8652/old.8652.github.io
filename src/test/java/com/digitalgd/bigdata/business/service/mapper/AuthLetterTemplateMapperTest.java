package com.digitalgd.bigdata.business.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthLetterTemplateMapperTest {

    private AuthLetterTemplateMapper authLetterTemplateMapper;

    @BeforeEach
    public void setUp() {
        authLetterTemplateMapper = new AuthLetterTemplateMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(authLetterTemplateMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(authLetterTemplateMapper.fromId(null)).isNull();
    }
}
