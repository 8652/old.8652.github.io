package com.digitalgd.bigdata.business.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class BigInterfaceLogTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BigInterfaceLog.class);
        BigInterfaceLog bigInterfaceLog1 = new BigInterfaceLog();
        bigInterfaceLog1.setId(1L);
        BigInterfaceLog bigInterfaceLog2 = new BigInterfaceLog();
        bigInterfaceLog2.setId(bigInterfaceLog1.getId());
        assertThat(bigInterfaceLog1).isEqualTo(bigInterfaceLog2);
        bigInterfaceLog2.setId(2L);
        assertThat(bigInterfaceLog1).isNotEqualTo(bigInterfaceLog2);
        bigInterfaceLog1.setId(null);
        assertThat(bigInterfaceLog1).isNotEqualTo(bigInterfaceLog2);
    }
}
