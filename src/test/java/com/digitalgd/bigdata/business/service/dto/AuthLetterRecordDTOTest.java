package com.digitalgd.bigdata.business.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class AuthLetterRecordDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AuthLetterRecordDTO.class);
        AuthLetterRecordDTO authLetterRecordDTO1 = new AuthLetterRecordDTO();
        authLetterRecordDTO1.setId(1L);
        AuthLetterRecordDTO authLetterRecordDTO2 = new AuthLetterRecordDTO();
        assertThat(authLetterRecordDTO1).isNotEqualTo(authLetterRecordDTO2);
        authLetterRecordDTO2.setId(authLetterRecordDTO1.getId());
        assertThat(authLetterRecordDTO1).isEqualTo(authLetterRecordDTO2);
        authLetterRecordDTO2.setId(2L);
        assertThat(authLetterRecordDTO1).isNotEqualTo(authLetterRecordDTO2);
        authLetterRecordDTO1.setId(null);
        assertThat(authLetterRecordDTO1).isNotEqualTo(authLetterRecordDTO2);
    }
}
