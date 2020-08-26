package com.digitalgd.bigdata.business.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class BigInterfaceBizTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BigInterfaceBiz.class);
        BigInterfaceBiz bigInterfaceBiz1 = new BigInterfaceBiz();
        bigInterfaceBiz1.setId(1L);
        BigInterfaceBiz bigInterfaceBiz2 = new BigInterfaceBiz();
        bigInterfaceBiz2.setId(bigInterfaceBiz1.getId());
        assertThat(bigInterfaceBiz1).isEqualTo(bigInterfaceBiz2);
        bigInterfaceBiz2.setId(2L);
        assertThat(bigInterfaceBiz1).isNotEqualTo(bigInterfaceBiz2);
        bigInterfaceBiz1.setId(null);
        assertThat(bigInterfaceBiz1).isNotEqualTo(bigInterfaceBiz2);
    }
}
