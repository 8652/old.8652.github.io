package com.digitalgd.bigdata.business.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class BigInterfaceLogDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BigInterfaceLogDTO.class);
        BigInterfaceLogDTO bigInterfaceLogDTO1 = new BigInterfaceLogDTO();
        bigInterfaceLogDTO1.setId(1L);
        BigInterfaceLogDTO bigInterfaceLogDTO2 = new BigInterfaceLogDTO();
        assertThat(bigInterfaceLogDTO1).isNotEqualTo(bigInterfaceLogDTO2);
        bigInterfaceLogDTO2.setId(bigInterfaceLogDTO1.getId());
        assertThat(bigInterfaceLogDTO1).isEqualTo(bigInterfaceLogDTO2);
        bigInterfaceLogDTO2.setId(2L);
        assertThat(bigInterfaceLogDTO1).isNotEqualTo(bigInterfaceLogDTO2);
        bigInterfaceLogDTO1.setId(null);
        assertThat(bigInterfaceLogDTO1).isNotEqualTo(bigInterfaceLogDTO2);
    }
}
