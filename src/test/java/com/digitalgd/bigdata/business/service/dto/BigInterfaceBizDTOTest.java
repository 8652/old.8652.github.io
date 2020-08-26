package com.digitalgd.bigdata.business.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class BigInterfaceBizDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BigInterfaceBizDTO.class);
        BigInterfaceBizDTO bigInterfaceBizDTO1 = new BigInterfaceBizDTO();
        bigInterfaceBizDTO1.setId(1L);
        BigInterfaceBizDTO bigInterfaceBizDTO2 = new BigInterfaceBizDTO();
        assertThat(bigInterfaceBizDTO1).isNotEqualTo(bigInterfaceBizDTO2);
        bigInterfaceBizDTO2.setId(bigInterfaceBizDTO1.getId());
        assertThat(bigInterfaceBizDTO1).isEqualTo(bigInterfaceBizDTO2);
        bigInterfaceBizDTO2.setId(2L);
        assertThat(bigInterfaceBizDTO1).isNotEqualTo(bigInterfaceBizDTO2);
        bigInterfaceBizDTO1.setId(null);
        assertThat(bigInterfaceBizDTO1).isNotEqualTo(bigInterfaceBizDTO2);
    }
}
