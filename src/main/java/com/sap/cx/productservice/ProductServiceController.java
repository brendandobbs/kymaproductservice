package com.sap.cx.productservice;

import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sap.cx.productservice.data.ProductData;

import lombok.extern.slf4j.Slf4j;

@RestController
//@Profile("!Security")
@Slf4j
public class ProductServiceController {
	
	@Value("${version}")
	private String version;
	
	@Value("${GATEWAY_URL}")
	private String commerceService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RedisTemplate<String, ProductData> redisTemplate;
	
	private String KEY = "Products";
	
	private List<String> VALID_FIELDS = Arrays.asList("DEFAULT", "FULL", "BASIC");
	
	@GetMapping("/{baseSiteId}/products/{productCode}")
	ProductData getProduct(@PathVariable("baseSiteId") String baseSiteId, @PathVariable("productCode") String productCode, @RequestParam(name="fields", required = false) String fields) {
        
		if (!VALID_FIELDS.contains(fields))
		{
			fields = "DEFAULT";
		}
		
		HashOperations<String, String, ProductData> hashOperations = redisTemplate.opsForHash();
		
		String productKey = baseSiteId + "-" + "productCode" + "-" + fields;
		log.info("Using key: " + productKey);
		
		ProductData cachedProduct = hashOperations.get(KEY, productKey);
		if (cachedProduct == null)
		{
			log.info("Not Cached");
			ProductData productData = restTemplate.getForObject(commerceService + "/" + baseSiteId + "/products/" + productCode + "?fields=" + fields, ProductData.class);
			hashOperations.put(KEY, productKey, productData);
			return productData;
		}		
		else
        {
			log.info("Cached");
			return cachedProduct;
        }
		
		
    }	
}
