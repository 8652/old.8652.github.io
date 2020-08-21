package com.digitalgd.bigdata.business.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class BizItemTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BizItem.class);
        BizItem bizItem1 = new BizItem();
        bizItem1.setId(1L);
        BizItem bizItem2 = new BizItem();
        bizItem2.setId(bizItem1.getId());
        assertThat(bizItem1).isEqualTo(bizItem2);
        bizItem2.setId(2L);
        assertThat(bizItem1).isNotEqualTo(bizItem2);
        bizItem1.setId(null);
        assertThat(bizItem1).isNotEqualTo(bizItem2);
    }
}
