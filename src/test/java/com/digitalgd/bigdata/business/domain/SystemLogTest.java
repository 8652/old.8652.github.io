package com.digitalgd.bigdata.business.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class SystemLogTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SystemLog.class);
        SystemLog systemLog1 = new SystemLog();
        systemLog1.setId(1L);
        SystemLog systemLog2 = new SystemLog();
        systemLog2.setId(systemLog1.getId());
        assertThat(systemLog1).isEqualTo(systemLog2);
        systemLog2.setId(2L);
        assertThat(systemLog1).isNotEqualTo(systemLog2);
        systemLog1.setId(null);
        assertThat(systemLog1).isNotEqualTo(systemLog2);
    }
}
