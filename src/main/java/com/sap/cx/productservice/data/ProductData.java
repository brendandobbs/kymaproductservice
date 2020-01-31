package com.sap.cx.productservice.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ProductData implements Serializable {

	private static final long serialVersionUID = 6591204446969259759L;

	private boolean availableForPickup;
	private float averageRating;

	private String code;
	private boolean configurable;
	private String description;
	private String manufacturer;
	private String name;
	private float numberOfReviews;
	private PriceData price;
	private PriceRangeData priceRange;
	private boolean purchasable;
	private StockData StockObject;
	private String summary;
	private String url;

	private List<Object> baseOptions;
	private List<CategoryData> categories;
	private List<ClassificationData> classifications;
	private List<ImageData> images;
	private List<PromotionData> potentialPromotions;
	private List<ProductReferenceData> productReferences;
	private List<ReviewData> reviews;

	@Getter
	@Setter
	@NoArgsConstructor
	@JsonInclude(Include.NON_NULL)
	static private class ImageData implements Serializable {

		private static final long serialVersionUID = -210146991557955093L;
		private String altText;
	    private String format;
	    private String imageType;
	    private String url;
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@JsonInclude(Include.NON_NULL)
	static private class PriceData implements Serializable {

		private static final long serialVersionUID = -5420465452763233486L;
		private String currencyIso;
		private String formattedValue;
		private String priceType;
		private float value;
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@JsonInclude(Include.NON_NULL)
	static private class PriceRangeData implements Serializable{
		private static final long serialVersionUID = -3362733724726789270L;
		
		private PriceData minPrice;
		private PriceData maxPrice;
	}
	
	@Getter 
	@Setter 
	@NoArgsConstructor 
	@JsonInclude(Include.NON_NULL)
	static private class ReviewData implements Serializable {

		private static final long serialVersionUID = 7401267398022379451L;
		private String alias;
		private String comment;
		private String date;
		private String headline;
		private String id;
		private PrincipalData principal;
		private float rating;
		
		@Getter
		@Setter
		@NoArgsConstructor
		@JsonInclude(Include.NON_NULL)
		private class PrincipalData implements Serializable{

			private static final long serialVersionUID = -7630833812077199730L;
			private String name;
			private String uid;
		}	
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@JsonInclude(Include.NON_NULL)
	static private class PromotionData implements Serializable {	
		private static final long serialVersionUID = 7915980934218919738L;
		private String code;
		private String title;
		private String promotionType;
		private String startDate;
		private String endDate;		
		private String description;		
		private List<String> couldFireMessages;		
		private List<String> firedMessages;		
		private ImageData productBanner;		
		private Boolean enabled;		
		private Integer priority;		
		private String promotionGroup;
	}
	
	@Setter
	@Getter
	@NoArgsConstructor
	@JsonInclude(Include.NON_NULL)
	static private class StockData implements Serializable {

		private static final long serialVersionUID = -6484359543974961350L;
		private float stockLevel;
		private String stockLevelStatus;
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@JsonInclude(Include.NON_NULL)
	static private class ProductReferenceData implements Serializable{
		private static final long serialVersionUID = 8017588936177326420L;	
		private Boolean preselected; 
		private String referenceType;
		private String description;
		private Integer quantity;	
		private ProductData target;
	}

}
	
	
