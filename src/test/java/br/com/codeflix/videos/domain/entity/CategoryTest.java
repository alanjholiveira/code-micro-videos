package br.com.codeflix.videos.domain.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.codeflix.videos.infrastructure.util.TestUtil;

@SpringBootTest
class CategoryTest {

    private Category entity1;
    private Category entity2;

    /**
     * Setup Initial
     */
    @BeforeEach
    public void init() {
        entity1 = new Category();
        entity1.setId(TestUtil.ID);
        entity1.setName(TestUtil.NAME);
        entity1.setDescription(TestUtil.DESCRIPTION);
        entity1.setIsActive(TestUtil.IS_ACTIVE_TRUE);

        entity2 = new Category();
        entity2.setId(TestUtil.ID);
        entity2.setName(TestUtil.NAME);
        entity2.setDescription(TestUtil.DESCRIPTION);
        entity2.setIsActive(TestUtil.IS_ACTIVE_TRUE);
    }

    /**
     * Test method Equals.
     */
    @Test
    void testEquals() {
        Assertions.assertEquals(entity1, entity2);

        entity2.setId(TestUtil.ID2);
        Assertions.assertNotEquals(entity1, entity2);
    }
//
//    /**
//     * Test method hashCode.
//     */
//    @Test
//    void testHashCode() {
//        Assertions.assertEquals(entity1.hashCode(), entity2.hashCode());
//
//        entity2.setId(TestUtil.ID2);
//        Assertions.assertNotEquals(entity1.hashCode(), entity2.hashCode());
//    }

    /**
     * Test methodo getId
     */
    @Test
    void getId() {
        Assertions.assertEquals(TestUtil.ID, entity1.getId());
    }

    /**
     * Test methodo getName
     */
    @Test
    void getName() {
        Assertions.assertEquals(TestUtil.NAME, entity1.getName());
    }

    /**
     * Test methodo getDescription
     */
    @Test
    void getDescription() {
        Assertions.assertEquals(TestUtil.DESCRIPTION, entity1.getDescription());
    }

    /**
     * Test methodo getisActive
     */
    @Test
    void getIsActive() {
        Assertions.assertEquals(TestUtil.IS_ACTIVE_TRUE, entity1.getIsActive());
    }

}
