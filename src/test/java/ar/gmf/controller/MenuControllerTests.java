package ar.gmf.controller;


import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import ar.gmf.RestoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestoApplication.class)
@WebIntegrationTest("server.port:9999")
public class MenuControllerTests {

	RestTemplate template = new TestRestTemplate();

	@Test
	public void findMenuId1() throws Exception {
		ResponseEntity<String> responseEntity = template.getForEntity("http://localhost:9999/menu/1/", String.class);
		
		Assert.isTrue(responseEntity.getStatusCode().is2xxSuccessful(), "shoul be successfull http status");
		
		String body = responseEntity.getBody();
		Assert.hasText(body);
		Assert.isTrue(StringUtils.contains(body, "Dinner 1"), "should contain menu name");
	}
	
}
