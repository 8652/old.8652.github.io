package com.digitalgd.bigdata.business.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class BizItemInfoResDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BizItemInfoResDTO.class);
        BizItemInfoResDTO bizItemInfoResDTO1 = new BizItemInfoResDTO();
        bizItemInfoResDTO1.setId(1L);
        BizItemInfoResDTO bizItemInfoResDTO2 = new BizItemInfoResDTO();
        assertThat(bizItemInfoResDTO1).isNotEqualTo(bizItemInfoResDTO2);
        bizItemInfoResDTO2.setId(bizItemInfoResDTO1.getId());
        assertThat(bizItemInfoResDTO1).isEqualTo(bizItemInfoResDTO2);
        bizItemInfoResDTO2.setId(2L);
        assertThat(bizItemInfoResDTO1).isNotEqualTo(bizItemInfoResDTO2);
        bizItemInfoResDTO1.setId(null);
        assertThat(bizItemInfoResDTO1).isNotEqualTo(bizItemInfoResDTO2);
    }
}
