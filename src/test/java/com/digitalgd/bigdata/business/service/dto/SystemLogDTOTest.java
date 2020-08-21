package com.digitalgd.bigdata.business.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class SystemLogDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SystemLogDTO.class);
        SystemLogDTO systemLogDTO1 = new SystemLogDTO();
        systemLogDTO1.setId(1L);
        SystemLogDTO systemLogDTO2 = new SystemLogDTO();
        assertThat(systemLogDTO1).isNotEqualTo(systemLogDTO2);
        systemLogDTO2.setId(systemLogDTO1.getId());
        assertThat(systemLogDTO1).isEqualTo(systemLogDTO2);
        systemLogDTO2.setId(2L);
        assertThat(systemLogDTO1).isNotEqualTo(systemLogDTO2);
        systemLogDTO1.setId(null);
        assertThat(systemLogDTO1).isNotEqualTo(systemLogDTO2);
    }
}
