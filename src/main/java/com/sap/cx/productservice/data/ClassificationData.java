package com.sap.cx.productservice.data;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
public class ClassificationData implements Serializable{
	
	private static final long serialVersionUID = 7583645989294601143L;
	private String code;
	private List<FeatureData> features;
	
}
