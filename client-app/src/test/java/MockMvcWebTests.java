import com.instaclustr.springbootdemo.SpringBootDemoApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
@WebAppConfiguration
public class MockMvcWebTests {
    @Autowired
    private WebApplicationContext webContext;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
    }

    @Test
    public void testHeartbeat() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                MockMvcRequestBuilders.get("/heartbeat"))
                .andReturn().getResponse();

        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals("{\"name\":\"Spring boot demo app\"}", response.getContentAsString());
    }
}
