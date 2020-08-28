package com.digitalgd.bigdata.business.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.digitalgd.bigdata.business.web.rest.TestUtil;

public class BigInterfaceListTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BigInterfaceList.class);
        BigInterfaceList bigInterfaceList1 = new BigInterfaceList();
        bigInterfaceList1.setId(1L);
        BigInterfaceList bigInterfaceList2 = new BigInterfaceList();
        bigInterfaceList2.setId(bigInterfaceList1.getId());
        assertThat(bigInterfaceList1).isEqualTo(bigInterfaceList2);
        bigInterfaceList2.setId(2L);
        assertThat(bigInterfaceList1).isNotEqualTo(bigInterfaceList2);
        bigInterfaceList1.setId(null);
        assertThat(bigInterfaceList1).isNotEqualTo(bigInterfaceList2);
    }
}
