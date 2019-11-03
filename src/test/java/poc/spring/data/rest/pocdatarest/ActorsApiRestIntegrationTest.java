package poc.spring.data.rest.pocdatarest;

import java.util.Collection;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import poc.spring.data.rest.pocdatarest.entities.Actor;


@SpringBootTest(
		webEnvironment = WebEnvironment.RANDOM_PORT
		)
@ExtendWith(SpringExtension.class)
public class ActorsApiRestIntegrationTest {
	
	private final String jwt ="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJhdXRob3JpdGllcyI6WyJyX2FjdG9yIiwid19hY3RvciJdfQ.ZAPXJQwpbqYvu_LTyDvP0_ht2I1zP7-cB6wtehh3wkQ";

	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
	
	
	@SuppressWarnings("rawtypes")
	@Test
	public void test() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", jwt);
		
		ResponseEntity<PagedModel> response = restTemplate.exchange(
				"http://localhost:" + port + "/rest/actors?page=0&size=10"
				, HttpMethod.GET,new HttpEntity<>(headers), PagedModel.class
				);
		PagedModel<LinkedHashMap<String, String>> model = response.getBody();
		Assertions.assertNotNull(model);
		Collection<LinkedHashMap<String, String>> content = model.getContent();
		boolean contienePenelope = content.stream()
				.anyMatch(lm -> lm.get("firstName").equalsIgnoreCase("PENELOPE"));
		Assertions.assertTrue(contienePenelope);
	}

}
