package com.digitalgd.bigdata.business.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class PairContractFileDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PairContractFileDTO.class);
        PairContractFileDTO pairContractFileDTO1 = new PairContractFileDTO();
        pairContractFileDTO1.setId(1L);
        PairContractFileDTO pairContractFileDTO2 = new PairContractFileDTO();
        assertThat(pairContractFileDTO1).isNotEqualTo(pairContractFileDTO2);
        pairContractFileDTO2.setId(pairContractFileDTO1.getId());
        assertThat(pairContractFileDTO1).isEqualTo(pairContractFileDTO2);
        pairContractFileDTO2.setId(2L);
        assertThat(pairContractFileDTO1).isNotEqualTo(pairContractFileDTO2);
        pairContractFileDTO1.setId(null);
        assertThat(pairContractFileDTO1).isNotEqualTo(pairContractFileDTO2);
    }
}
