package com.sap.cx.productservice.data;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class FeatureData implements Serializable {
	
	private static final long serialVersionUID = -6817062597575494614L;
	private String code;
    private boolean comparable;
    private FeatureUnit featureUnit;
    private List<FeatureValue> featureValue;
    private String name;
    private boolean range;
    
 
    @Getter 
    @Setter 
    @NoArgsConstructor
    private class FeatureUnit implements Serializable {
		private static final long serialVersionUID = 6517563435908279306L;
		private String name;
    	private String symbol;
    	private String unitType;
    }
    
    @Getter 
    @Setter 
    @NoArgsConstructor
    private class FeatureValue implements Serializable {
		private static final long serialVersionUID = -7016384613421863230L;
		private String value;
    }
}
