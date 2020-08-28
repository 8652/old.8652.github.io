package com.digitalgd.bigdata.business.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class PairContractTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PairContract.class);
        PairContract pairContract1 = new PairContract();
        pairContract1.setId(1L);
        PairContract pairContract2 = new PairContract();
        pairContract2.setId(pairContract1.getId());
        assertThat(pairContract1).isEqualTo(pairContract2);
        pairContract2.setId(2L);
        assertThat(pairContract1).isNotEqualTo(pairContract2);
        pairContract1.setId(null);
        assertThat(pairContract1).isNotEqualTo(pairContract2);
    }
}
