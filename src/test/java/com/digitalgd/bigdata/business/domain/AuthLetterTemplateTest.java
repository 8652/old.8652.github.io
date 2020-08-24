package com.digitalgd.bigdata.business.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class AuthLetterTemplateTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AuthLetterTemplate.class);
        AuthLetterTemplate authLetterTemplate1 = new AuthLetterTemplate();
        authLetterTemplate1.setId(1L);
        AuthLetterTemplate authLetterTemplate2 = new AuthLetterTemplate();
        authLetterTemplate2.setId(authLetterTemplate1.getId());
        assertThat(authLetterTemplate1).isEqualTo(authLetterTemplate2);
        authLetterTemplate2.setId(2L);
        assertThat(authLetterTemplate1).isNotEqualTo(authLetterTemplate2);
        authLetterTemplate1.setId(null);
        assertThat(authLetterTemplate1).isNotEqualTo(authLetterTemplate2);
    }
}
