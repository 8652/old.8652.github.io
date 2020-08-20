package com.digitalgd.bigdata.business.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class AuthLetterRecordTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AuthLetterRecord.class);
        AuthLetterRecord authLetterRecord1 = new AuthLetterRecord();
        authLetterRecord1.setId(1L);
        AuthLetterRecord authLetterRecord2 = new AuthLetterRecord();
        authLetterRecord2.setId(authLetterRecord1.getId());
        assertThat(authLetterRecord1).isEqualTo(authLetterRecord2);
        authLetterRecord2.setId(2L);
        assertThat(authLetterRecord1).isNotEqualTo(authLetterRecord2);
        authLetterRecord1.setId(null);
        assertThat(authLetterRecord1).isNotEqualTo(authLetterRecord2);
    }
}
