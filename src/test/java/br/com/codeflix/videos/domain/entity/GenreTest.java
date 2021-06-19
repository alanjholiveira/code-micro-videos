package br.com.codeflix.videos.domain.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.codeflix.videos.infrastructure.util.TestUtil;

@SpringBootTest
class GenreTest {

    private Genre entity1;
    private Genre entity2;

    /**
     * Setup Initial
     */
    @BeforeEach
    public void init() {
        entity1 = new Genre();
        entity1.setId(TestUtil.ID);
        entity1.setName(TestUtil.NAME);
        entity1.setIsActive(TestUtil.IS_ACTIVE_TRUE);

        entity2 = new Genre();
        entity2.setId(TestUtil.ID);
        entity2.setName(TestUtil.NAME);
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

    /**
     * Test method hashCode.
     */
    @Test
    void testHashCode() {
        Assertions.assertEquals(entity1.hashCode(), entity2.hashCode());

        entity2.setId(TestUtil.ID2);
        Assertions.assertNotEquals(entity1.hashCode(), entity2.hashCode());
    }

    /**
     * Test method getId
     */
    @Test
    void testGetId() {
        Assertions.assertEquals(TestUtil.ID, entity1.getId());
    }

    /**
     * Test method getName
     */
    @Test
    void testGetName() {
        Assertions.assertEquals(TestUtil.NAME, entity1.getName());
    }


    /**
     * Test method getIsActive
     */
    @Test
    void tesGetIsActive() {
        Assertions.assertEquals(TestUtil.IS_ACTIVE_TRUE, entity1.getIsActive());
    }

}
