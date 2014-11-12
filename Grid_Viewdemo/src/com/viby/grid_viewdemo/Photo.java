package com.viby.grid_viewdemo;

import java.io.Serializable;
import java.util.Arrays;

public class Photo implements Serializable
{
	String names;
	int ImgId;
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public int getImgId() {
		return ImgId;
	}
	public void setImgId(int imgId) {
		ImgId = imgId;
	}
	public Photo() {
		super();
	}
	public Photo(String names, int imgId) {
		super();
		this.names = names;
		ImgId = imgId;
	}
	@Override
	public String toString() {
		return "Photo [names=" + names + ", ImgId=" + ImgId + "]";
	}
	
	
}
