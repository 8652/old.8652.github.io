package com.digitalgd.bigdata.business.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class BizItemInfoResTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BizItemInfoRes.class);
        BizItemInfoRes bizItemInfoRes1 = new BizItemInfoRes();
        bizItemInfoRes1.setId(1L);
        BizItemInfoRes bizItemInfoRes2 = new BizItemInfoRes();
        bizItemInfoRes2.setId(bizItemInfoRes1.getId());
        assertThat(bizItemInfoRes1).isEqualTo(bizItemInfoRes2);
        bizItemInfoRes2.setId(2L);
        assertThat(bizItemInfoRes1).isNotEqualTo(bizItemInfoRes2);
        bizItemInfoRes1.setId(null);
        assertThat(bizItemInfoRes1).isNotEqualTo(bizItemInfoRes2);
    }
}
