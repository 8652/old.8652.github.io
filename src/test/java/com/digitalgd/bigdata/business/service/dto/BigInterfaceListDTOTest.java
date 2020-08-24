package com.digitalgd.bigdata.business.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class BigInterfaceListDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BigInterfaceListDTO.class);
        BigInterfaceListDTO bigInterfaceListDTO1 = new BigInterfaceListDTO();
        bigInterfaceListDTO1.setId(1L);
        BigInterfaceListDTO bigInterfaceListDTO2 = new BigInterfaceListDTO();
        assertThat(bigInterfaceListDTO1).isNotEqualTo(bigInterfaceListDTO2);
        bigInterfaceListDTO2.setId(bigInterfaceListDTO1.getId());
        assertThat(bigInterfaceListDTO1).isEqualTo(bigInterfaceListDTO2);
        bigInterfaceListDTO2.setId(2L);
        assertThat(bigInterfaceListDTO1).isNotEqualTo(bigInterfaceListDTO2);
        bigInterfaceListDTO1.setId(null);
        assertThat(bigInterfaceListDTO1).isNotEqualTo(bigInterfaceListDTO2);
    }
}
