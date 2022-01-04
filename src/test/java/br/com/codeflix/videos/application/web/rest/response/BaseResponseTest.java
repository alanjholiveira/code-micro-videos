package br.com.codeflix.videos.application.web.rest.response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.codeflix.videos.infrastructure.util.TestUtil;

@SpringBootTest
class BaseResponseTest {

    private BaseResponse response1;
    private BaseResponse response2;

    /**
     * Setup Initial
     */
    @BeforeEach
    public void init() {
        response1 = new BaseResponse();
        response1.setId(TestUtil.ID);

        response2 = new BaseResponse();
        response2.setId(TestUtil.ID);
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

}
