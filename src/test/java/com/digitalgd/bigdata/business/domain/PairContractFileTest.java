package com.digitalgd.bigdata.business.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class PairContractFileTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PairContractFile.class);
        PairContractFile pairContractFile1 = new PairContractFile();
        pairContractFile1.setId(1L);
        PairContractFile pairContractFile2 = new PairContractFile();
        pairContractFile2.setId(pairContractFile1.getId());
        assertThat(pairContractFile1).isEqualTo(pairContractFile2);
        pairContractFile2.setId(2L);
        assertThat(pairContractFile1).isNotEqualTo(pairContractFile2);
        pairContractFile1.setId(null);
        assertThat(pairContractFile1).isNotEqualTo(pairContractFile2);
    }
}
