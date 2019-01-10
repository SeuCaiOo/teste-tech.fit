package br.com.seucaioo.testetechfit.model;

import com.google.gson.annotations.SerializedName;

public class Breed{

	@SerializedName("suppressed_tail")
	private int suppressedTail;

	@SerializedName("wikipedia_url")
	private String wikipediaUrl;

	@SerializedName("origin")
	private String origin;

	@SerializedName("description")
	private String description;

	@SerializedName("experimental")
	private int experimental;

	@SerializedName("life_span")
	private String lifeSpan;

	@SerializedName("rare")
	private int rare;

	@SerializedName("id")
	private String id;

	@SerializedName("short_legs")
	private int shortLegs;

	@SerializedName("shedding_level")
	private int sheddingLevel;

	@SerializedName("dog_friendly")
	private int dogFriendly;

	@SerializedName("natural")
	private int natural;

	@SerializedName("rex")
	private int rex;

	@SerializedName("health_issues")
	private int healthIssues;

	@SerializedName("hairless")
	private int hairless;

	@SerializedName("alt_names")
	private String altNames;

	@SerializedName("adaptability")
	private int adaptability;

	@SerializedName("vocalisation")
	private int vocalisation;

	@SerializedName("intelligence")
	private int intelligence;

	@SerializedName("social_needs")
	private int socialNeeds;

	@SerializedName("country_code")
	private String countryCode;

	@SerializedName("weight_imperial")
	private String weightImperial;

	@SerializedName("child_friendly")
	private int childFriendly;

	@SerializedName("temperament")
	private String temperament;

	@SerializedName("grooming")
	private int grooming;

	@SerializedName("hypoallergenic")
	private int hypoallergenic;

	@SerializedName("name")
	private String name;

	@SerializedName("energy_level")
	private int energyLevel;

	@SerializedName("stranger_friendly")
	private int strangerFriendly;

	@SerializedName("affection_level")
	private int affectionLevel;

	public void setSuppressedTail(int suppressedTail){
		this.suppressedTail = suppressedTail;
	}

	public int getSuppressedTail(){
		return suppressedTail;
	}

	public void setWikipediaUrl(String wikipediaUrl){
		this.wikipediaUrl = wikipediaUrl;
	}

	public String getWikipediaUrl(){
		return wikipediaUrl;
	}

	public void setOrigin(String origin){
		this.origin = origin;
	}

	public String getOrigin(){
		return origin;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setExperimental(int experimental){
		this.experimental = experimental;
	}

	public int getExperimental(){
		return experimental;
	}

	public void setLifeSpan(String lifeSpan){
		this.lifeSpan = lifeSpan;
	}

	public String getLifeSpan(){
		return lifeSpan;
	}

	public void setRare(int rare){
		this.rare = rare;
	}

	public int getRare(){
		return rare;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setShortLegs(int shortLegs){
		this.shortLegs = shortLegs;
	}

	public int getShortLegs(){
		return shortLegs;
	}

	public void setSheddingLevel(int sheddingLevel){
		this.sheddingLevel = sheddingLevel;
	}

	public int getSheddingLevel(){
		return sheddingLevel;
	}

	public void setDogFriendly(int dogFriendly){
		this.dogFriendly = dogFriendly;
	}

	public int getDogFriendly(){
		return dogFriendly;
	}

	public void setNatural(int natural){
		this.natural = natural;
	}

	public int getNatural(){
		return natural;
	}

	public void setRex(int rex){
		this.rex = rex;
	}

	public int getRex(){
		return rex;
	}

	public void setHealthIssues(int healthIssues){
		this.healthIssues = healthIssues;
	}

	public int getHealthIssues(){
		return healthIssues;
	}

	public void setHairless(int hairless){
		this.hairless = hairless;
	}

	public int getHairless(){
		return hairless;
	}

	public void setAltNames(String altNames){
		this.altNames = altNames;
	}

	public String getAltNames(){
		return altNames;
	}

	public void setAdaptability(int adaptability){
		this.adaptability = adaptability;
	}

	public int getAdaptability(){
		return adaptability;
	}

	public void setVocalisation(int vocalisation){
		this.vocalisation = vocalisation;
	}

	public int getVocalisation(){
		return vocalisation;
	}

	public void setIntelligence(int intelligence){
		this.intelligence = intelligence;
	}

	public int getIntelligence(){
		return intelligence;
	}

	public void setSocialNeeds(int socialNeeds){
		this.socialNeeds = socialNeeds;
	}

	public int getSocialNeeds(){
		return socialNeeds;
	}

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public void setWeightImperial(String weightImperial){
		this.weightImperial = weightImperial;
	}

	public String getWeightImperial(){
		return weightImperial;
	}

	public void setChildFriendly(int childFriendly){
		this.childFriendly = childFriendly;
	}

	public int getChildFriendly(){
		return childFriendly;
	}

	public void setTemperament(String temperament){
		this.temperament = temperament;
	}

	public String getTemperament(){
		return temperament;
	}

	public void setGrooming(int grooming){
		this.grooming = grooming;
	}

	public int getGrooming(){
		return grooming;
	}

	public void setHypoallergenic(int hypoallergenic){
		this.hypoallergenic = hypoallergenic;
	}

	public int getHypoallergenic(){
		return hypoallergenic;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEnergyLevel(int energyLevel){
		this.energyLevel = energyLevel;
	}

	public int getEnergyLevel(){
		return energyLevel;
	}

	public void setStrangerFriendly(int strangerFriendly){
		this.strangerFriendly = strangerFriendly;
	}

	public int getStrangerFriendly(){
		return strangerFriendly;
	}

	public void setAffectionLevel(int affectionLevel){
		this.affectionLevel = affectionLevel;
	}

	public int getAffectionLevel(){
		return affectionLevel;
	}

	@Override
 	public String toString(){
		return 
			"Breed{" + 
			"suppressed_tail = '" + suppressedTail + '\'' + 
			",wikipedia_url = '" + wikipediaUrl + '\'' + 
			",origin = '" + origin + '\'' + 
			",description = '" + description + '\'' + 
			",experimental = '" + experimental + '\'' + 
			",life_span = '" + lifeSpan + '\'' + 
			",rare = '" + rare + '\'' + 
			",id = '" + id + '\'' + 
			",short_legs = '" + shortLegs + '\'' + 
			",shedding_level = '" + sheddingLevel + '\'' + 
			",dog_friendly = '" + dogFriendly + '\'' + 
			",natural = '" + natural + '\'' + 
			",rex = '" + rex + '\'' + 
			",health_issues = '" + healthIssues + '\'' + 
			",hairless = '" + hairless + '\'' + 
			",alt_names = '" + altNames + '\'' + 
			",adaptability = '" + adaptability + '\'' + 
			",vocalisation = '" + vocalisation + '\'' + 
			",intelligence = '" + intelligence + '\'' + 
			",social_needs = '" + socialNeeds + '\'' + 
			",country_code = '" + countryCode + '\'' + 
			",weight_imperial = '" + weightImperial + '\'' + 
			",child_friendly = '" + childFriendly + '\'' + 
			",temperament = '" + temperament + '\'' + 
			",grooming = '" + grooming + '\'' + 
			",hypoallergenic = '" + hypoallergenic + '\'' + 
			",name = '" + name + '\'' + 
			",energy_level = '" + energyLevel + '\'' + 
			",stranger_friendly = '" + strangerFriendly + '\'' + 
			",affection_level = '" + affectionLevel + '\'' + 
			"}";
		}
}