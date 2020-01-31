package com.sap.cx.productservice.data;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
public class CategoryData implements Serializable{
	
	private static final long serialVersionUID = -3678353342663117553L;
	private String code;
	private String name;
}
