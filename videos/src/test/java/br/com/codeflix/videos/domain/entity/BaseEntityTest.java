package br.com.codeflix.videos.domain.entity;

import br.com.codeflix.videos.infrastructure.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BaseEntityTest {

    private BaseEntity entity1;
    private BaseEntity entity2;

    /**
     * Setup Initial
     */
    @BeforeEach
    void init() {
        entity1 = new BaseEntity();
        entity1.setId(TestUtil.ID);
        entity1.setCreated_at(TestUtil.CREATED_AT);
        entity1.setUpdate_at(TestUtil.UPDATE_AT);
        entity1.setDelete_at(TestUtil.DELETE_AT);

        entity2 = new BaseEntity();
        entity2.setId(TestUtil.ID);
        entity2.setCreated_at(TestUtil.CREATED_AT);
        entity2.setUpdate_at(TestUtil.UPDATE_AT);
        entity2.setDelete_at(TestUtil.DELETE_AT);
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
     * Test method getCreated_at
     */
    @Test
    void testGetCreated_at() {
        Assertions.assertEquals(TestUtil.CREATED_AT, entity1.getCreated_at());
    }

    /**
     * Test method getUpdate_at
     */
    @Test
    void testGetUpdate_at() {
        Assertions.assertEquals(TestUtil.UPDATE_AT, entity1.getUpdate_at());
    }

    /**
     * Test method getUpdate_at
     */
    @Test
    void testGetDelete_at() {
        Assertions.assertEquals(TestUtil.DELETE_AT, entity1.getDelete_at());
    }
}
