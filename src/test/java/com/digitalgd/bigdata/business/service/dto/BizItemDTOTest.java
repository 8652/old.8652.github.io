package com.digitalgd.bigdata.business.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class BizItemDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BizItemDTO.class);
        BizItemDTO bizItemDTO1 = new BizItemDTO();
        bizItemDTO1.setId(1L);
        BizItemDTO bizItemDTO2 = new BizItemDTO();
        assertThat(bizItemDTO1).isNotEqualTo(bizItemDTO2);
        bizItemDTO2.setId(bizItemDTO1.getId());
        assertThat(bizItemDTO1).isEqualTo(bizItemDTO2);
        bizItemDTO2.setId(2L);
        assertThat(bizItemDTO1).isNotEqualTo(bizItemDTO2);
        bizItemDTO1.setId(null);
        assertThat(bizItemDTO1).isNotEqualTo(bizItemDTO2);
    }
}
