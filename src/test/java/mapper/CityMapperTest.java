package mapper;

import com.instaclustr.springbootdemo.SpringBootDemoApplication;
import com.instaclustr.springbootdemo.mapper.CityMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class CityMapperTest {
    @Autowired
    private CityMapper cityMapper;

    @Test
    public void testCityMapper(){
        cityMapper.getAllCities();
    }
}
