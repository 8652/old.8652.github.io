package com.digitalgd.bigdata.business.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class AuthLetterTemplateDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AuthLetterTemplateDTO.class);
        AuthLetterTemplateDTO authLetterTemplateDTO1 = new AuthLetterTemplateDTO();
        authLetterTemplateDTO1.setId(1L);
        AuthLetterTemplateDTO authLetterTemplateDTO2 = new AuthLetterTemplateDTO();
        assertThat(authLetterTemplateDTO1).isNotEqualTo(authLetterTemplateDTO2);
        authLetterTemplateDTO2.setId(authLetterTemplateDTO1.getId());
        assertThat(authLetterTemplateDTO1).isEqualTo(authLetterTemplateDTO2);
        authLetterTemplateDTO2.setId(2L);
        assertThat(authLetterTemplateDTO1).isNotEqualTo(authLetterTemplateDTO2);
        authLetterTemplateDTO1.setId(null);
        assertThat(authLetterTemplateDTO1).isNotEqualTo(authLetterTemplateDTO2);
    }
}
