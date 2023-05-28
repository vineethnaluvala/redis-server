package in.vini.binding;

import java.io.Serializable;

import lombok.Data;

@Data
public class Country implements Serializable{

	private Integer id;
	private String countryName;
	private String countryCode;

}
