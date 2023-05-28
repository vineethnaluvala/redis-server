package in.vini.rest;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vini.binding.Country;

@RestController
public class CountryRestController {

	private HashOperations<String, Integer, Country> opsForHash = null;

	public CountryRestController(RedisTemplate<String, Country> rt) {
		this.opsForHash = rt.opsForHash();
	}
	@PostMapping("/add")
	public String addCountry(@RequestBody Country country) {
		opsForHash.put("countries", country.getId(), country);
		return "added successfully";
	}
	@GetMapping("/view")
	public Collection<Country> getCountries() {
		Map<Integer, Country> entries = opsForHash.entries("countries");
		Collection<Country> values = entries.values();
		return values;
	}
}
