package br.com.codeflix.videos.domain.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.codeflix.videos.infrastructure.util.TestUtil;

@SpringBootTest
class BaseDTOTest {

    private BaseDTO dto1;
    private BaseDTO dto2;

    /**
     * Setup Initial
     */
    @BeforeEach
    public void init() {
        dto1 = new BaseDTO();
        dto1.setId(TestUtil.ID);

        dto2 = new BaseDTO();
        dto2.setId(TestUtil.ID);
    }

    /**
     * Test method Equals.
     */
    @Test
    void testEquals() {
        Assertions.assertEquals(dto1, dto2);

        dto2.setId(TestUtil.ID2);
        Assertions.assertNotEquals(dto1, dto2);
    }

    /**
     * Test method hashCode.
     */
    @Test
    void testHashCode() {
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());

        dto2.setId(TestUtil.ID2);
        Assertions.assertNotEquals(dto1.hashCode(), dto2.hashCode());
    }

    /**
     * Test methodo getId
     */
    @Test
    void getId() {
        Assertions.assertEquals(TestUtil.ID, dto1.getId());
    }

}
