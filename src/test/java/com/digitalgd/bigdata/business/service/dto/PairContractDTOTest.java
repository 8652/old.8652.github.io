package com.digitalgd.bigdata.business.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class PairContractDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PairContractDTO.class);
        PairContractDTO pairContractDTO1 = new PairContractDTO();
        pairContractDTO1.setId(1L);
        PairContractDTO pairContractDTO2 = new PairContractDTO();
        assertThat(pairContractDTO1).isNotEqualTo(pairContractDTO2);
        pairContractDTO2.setId(pairContractDTO1.getId());
        assertThat(pairContractDTO1).isEqualTo(pairContractDTO2);
        pairContractDTO2.setId(2L);
        assertThat(pairContractDTO1).isNotEqualTo(pairContractDTO2);
        pairContractDTO1.setId(null);
        assertThat(pairContractDTO1).isNotEqualTo(pairContractDTO2);
    }
}
