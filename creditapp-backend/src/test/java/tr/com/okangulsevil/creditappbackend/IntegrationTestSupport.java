package tr.com.okangulsevil.creditappbackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import tr.com.okangulsevil.creditappbackend.dto.converter.CreditDtoConverter;
import tr.com.okangulsevil.creditappbackend.dto.converter.UserDtoConverter;
import tr.com.okangulsevil.creditappbackend.repository.CreditRepository;
import tr.com.okangulsevil.creditappbackend.repository.UserRepository;
import tr.com.okangulsevil.creditappbackend.service.CreditService;
import tr.com.okangulsevil.creditappbackend.service.UserService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.properties")
@DirtiesContext
@AutoConfigureMockMvc
public class IntegrationTestSupport extends TestSupport {

    @Autowired
    public UserService userService;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public UserDtoConverter userDtoConverter;

    @Autowired
    public CreditService creditService;
    @Autowired
    public CreditRepository creditRepository;
    @Autowired
    public CreditDtoConverter creditDtoConverter;

    public final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
    }
}
