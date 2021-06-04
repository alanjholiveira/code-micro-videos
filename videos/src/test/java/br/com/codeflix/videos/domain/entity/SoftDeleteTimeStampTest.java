package br.com.codeflix.videos.domain.entity;

import br.com.codeflix.videos.infrastructure.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SoftDeleteTimeStampTest {

    private SoftDeleteTimeStamp entity1;
    private SoftDeleteTimeStamp entity2;

    /**
     * Setup Initial
     */
    @BeforeEach
    void init() {
        entity1 = new SoftDeleteTimeStamp();
        entity1.setCreatedAt(TestUtil.CREATED_AT);
        entity1.setUpdateAt(TestUtil.UPDATE_AT);
        entity1.setDeleteAt(TestUtil.DELETE_AT);

        entity2 = new SoftDeleteTimeStamp();
        entity2.setCreatedAt(TestUtil.CREATED_AT);
        entity2.setUpdateAt(TestUtil.UPDATE_AT);
        entity2.setDeleteAt(TestUtil.DELETE_AT);
    }

    /**
     * Test method Equals.
     */
    @Test
    void testEquals() {
        Assertions.assertEquals(entity1, entity2);

        entity1.setUpdateAt(null);
        Assertions.assertNotEquals(entity1, entity2);
    }

    /**
     * Test method hashCode.
     */
    @Test
    void testHashCode() {
        Assertions.assertEquals(entity1.hashCode(), entity2.hashCode());

        entity1.setUpdateAt(null);
        Assertions.assertNotEquals(entity1.hashCode(), entity2.hashCode());
    }


    /**
     * Test method getCreated_at
     */
    @Test
    void testGetCreated_at() {
        Assertions.assertEquals(TestUtil.CREATED_AT, entity1.getCreatedAt());
    }

    /**
     * Test method getUpdate_at
     */
    @Test
    void testGetUpdate_at() {
        Assertions.assertEquals(TestUtil.UPDATE_AT, entity1.getUpdateAt());
    }

    /**
     * Test method getUpdate_at
     */
    @Test
    void testGetDelete_at() {
        Assertions.assertEquals(TestUtil.DELETE_AT, entity1.getDeleteAt());
    }
}
