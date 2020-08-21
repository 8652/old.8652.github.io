package com.digitalgd.bigdata.business.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class PairContactFileTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PairContactFile.class);
        PairContactFile pairContactFile1 = new PairContactFile();
        pairContactFile1.setId(1L);
        PairContactFile pairContactFile2 = new PairContactFile();
        pairContactFile2.setId(pairContactFile1.getId());
        assertThat(pairContactFile1).isEqualTo(pairContactFile2);
        pairContactFile2.setId(2L);
        assertThat(pairContactFile1).isNotEqualTo(pairContactFile2);
        pairContactFile1.setId(null);
        assertThat(pairContactFile1).isNotEqualTo(pairContactFile2);
    }
}
