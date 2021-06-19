package br.com.codeflix.videos.domain.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.codeflix.videos.infrastructure.util.TestUtil;

@SpringBootTest
class CategoryDTOTest {

    private CategoryDTO dto1;
    private CategoryDTO dto2;

    /**
     * Setup Initial
     */
    @BeforeEach
    void init() {
        dto1 = new CategoryDTO();
        dto1.setId(TestUtil.ID);
        dto1.setName(TestUtil.NAME);
        dto1.setDescription(TestUtil.DESCRIPTION);
        dto1.setIsActive(TestUtil.IS_ACTIVE_TRUE);

        dto2 = new CategoryDTO();
        dto2.setId(TestUtil.ID);
        dto2.setName(TestUtil.NAME);
        dto2.setDescription(TestUtil.DESCRIPTION);
        dto2.setIsActive(TestUtil.IS_ACTIVE_TRUE);
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

    /**
     * Test methodo getName
     */
    @Test
    void getName() {
        Assertions.assertEquals(TestUtil.NAME, dto1.getName());
    }

    /**
     * Test methodo getDescription
     */
    @Test
    void getDescription() {
        Assertions.assertEquals(TestUtil.DESCRIPTION, dto1.getDescription());
    }

    /**
     * Test methodo getisActive
     */
    @Test
    void getIsActive() {
        Assertions.assertEquals(TestUtil.IS_ACTIVE_TRUE, dto1.getIsActive());
    }

}
