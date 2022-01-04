package br.com.codeflix.videos.application.web.rest.response;

import br.com.codeflix.videos.infrastructure.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GenreResponseTest {

    private GenreResponse response1;
    private GenreResponse response2;

    /**
     * Setup Initial
     */
    @BeforeEach
    public void init() {
        response1 = new GenreResponse();
        response1.setId(TestUtil.ID);
        response1.setName(TestUtil.NAME);
        response1.setIsActive(TestUtil.IS_ACTIVE_TRUE);

        response2 = new GenreResponse();
        response2.setId(TestUtil.ID);
        response2.setName(TestUtil.NAME);
        response2.setIsActive(TestUtil.IS_ACTIVE_TRUE);
    }

    /**
     * Test method Equals.
     */
    @Test
    void testEquals() {
        Assertions.assertEquals(response1, response2);

        response2.setId(TestUtil.ID2);
        Assertions.assertNotEquals(response1, response2);
    }

    /**
     * Test method hashCode.
     */
    @Test
    void testHashCode() {
        Assertions.assertEquals(response1.hashCode(), response2.hashCode());

        response2.setId(TestUtil.ID2);
        Assertions.assertNotEquals(response1.hashCode(), response2.hashCode());
    }

    /**
     * Test methodo getId
     */
    @Test
    void getId() {
        Assertions.assertEquals(TestUtil.ID, response1.getId());
    }

    /**
     * Test methodo getName
     */
    @Test
    void getName() {
        Assertions.assertEquals(TestUtil.NAME, response1.getName());
    }

    /**
     * Test methodo getisActive
     */
    @Test
    void getIsActive() {
        Assertions.assertEquals(TestUtil.IS_ACTIVE_TRUE, response1.getIsActive());
    }

}
