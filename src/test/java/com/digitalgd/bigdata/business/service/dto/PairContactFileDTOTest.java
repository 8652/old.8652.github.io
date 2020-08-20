package com.digitalgd.bigdata.business.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class PairContactFileDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PairContactFileDTO.class);
        PairContactFileDTO pairContactFileDTO1 = new PairContactFileDTO();
        pairContactFileDTO1.setId(1L);
        PairContactFileDTO pairContactFileDTO2 = new PairContactFileDTO();
        assertThat(pairContactFileDTO1).isNotEqualTo(pairContactFileDTO2);
        pairContactFileDTO2.setId(pairContactFileDTO1.getId());
        assertThat(pairContactFileDTO1).isEqualTo(pairContactFileDTO2);
        pairContactFileDTO2.setId(2L);
        assertThat(pairContactFileDTO1).isNotEqualTo(pairContactFileDTO2);
        pairContactFileDTO1.setId(null);
        assertThat(pairContactFileDTO1).isNotEqualTo(pairContactFileDTO2);
    }
}
