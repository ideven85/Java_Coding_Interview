package com.cleo.design_patterns.BuilderPattern;

public class NutritionFacts {

	private final int servingSize,servings,calories,fat,sodium,carbohydrates;

	public static final class Builder{

		//Required
		private final int servingSize,servings,calories;

		//Optional
		private int fat,sodium,carbohydrates;

		public Builder(int servingSize, int servings,int calories) {
			this.servingSize = servingSize;
			this.servings = servings;
			this.calories=calories;
		}


		public Builder fat(int val){
			this.fat=val;
			return this;
		}
		public Builder sodium(int val){
			this.sodium=val;
			return this;
		}
		public Builder carbohydrates(int val){
			this.carbohydrates=val;
			return this;
		}
		public NutritionFacts build(){
			return new NutritionFacts(this);
		}
	}

	private NutritionFacts(Builder builder){
		servingSize= builder.servingSize;
		servings= builder.servings;
		this.calories=builder.calories;
		fat=builder.fat;
		sodium=builder.sodium;
		carbohydrates=builder.carbohydrates;
	}

	@Override
	public String toString() {
		return "ServingSize: " + servingSize + " Servings:" + servings;
	}

	public static void main(String[] args) {
		NutritionFacts cocaCola = new Builder(240,8,200)
				.sodium(25).build();
		System.out.println(cocaCola);

	}
}
