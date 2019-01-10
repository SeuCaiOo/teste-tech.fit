package br.com.seucaioo.testetechfit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Image implements Parcelable {

	@SerializedName("categories")
	private List<Category> categories;

	@SerializedName("id")
	private String id;

	@SerializedName("url")
	private String url;

	@SerializedName("breeds")
	private List<Breed> breeds;

	protected Image(Parcel in) {
		id = in.readString();
		url = in.readString();
	}

	public static final Creator<Image> CREATOR = new Creator<Image>() {
		@Override
		public Image createFromParcel(Parcel in) {
			return new Image(in);
		}

		@Override
		public Image[] newArray(int size) {
			return new Image[size];
		}
	};

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setBreeds(List<Breed> breeds) {
		this.breeds = breeds;
	}

	public List<Breed> getBreeds() {
		return breeds;
	}

	@Override
	public String toString() {
		return
				"Like{" +
						"categories = '" + categories + '\'' +
						",id = '" + id + '\'' +
						",url = '" + url + '\'' +
						",breeds = '" + breeds + '\'' +
						"}";
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(id);
		dest.writeString(url);
	}
}