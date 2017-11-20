package microsec.freddysbbq.customer_app;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2SsoProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import microsec.test.SecurityIntegrationTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "security.require-ssl=true")
public class CustomerApplicationSecurityTests extends SecurityIntegrationTest {
	
    @Autowired
    private OAuth2SsoProperties ssoProperties;

    @Test
    public void testHomepageSecurity() throws Exception {
        checkRequiresHttpsAndOauthSso("/", ssoProperties.getLoginPath());
    }

    @Test
    public void testMenuSecurity() throws Exception {
        checkRequiresHttpsAndOauthSso("/menu", ssoProperties.getLoginPath());
    }

    @Test
    public void testMyOrdersSecurity() throws Exception {
        checkRequiresHttpsAndOauthSso("/myorders", ssoProperties.getLoginPath());
    }

}