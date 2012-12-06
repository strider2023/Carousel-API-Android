package com.touchmenotapps.carousel.simple;

/*
 * Copyright (C) 2012 
 * Arindam Nath (strider2023@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.util.TypedValue;

public class VerticalCarouselStyle {
	
	public static final int NO_STYLE = 0;
	public static final int STYLE_RIGHT_ALIGNED = 2;
	public static final int STYLE_LEFT_ALIGNED = 3;
	public static final int STYLE_RIGHT_ALIGNED_WITH_ROTATION = 4;
	public static final int STYLE_LEFT_ALIGNED_WITH_ROTATION = 5;

	/* Transparency of incative child view */
	private float mSetInactiveViewTransparency;
	/* Number of pixel between the top of two Views */
	private int mSpaceBetweenViews;
	/* Rotation between two Views */
	private int mRotation;
	/* Status of rotation */
	private boolean mRotationEnabled;
	/* Tanslation between two Views */
	private int mTranslate;
	/* Status of translatation */
	private boolean mTranslatateEnbabled;
	/* Number of internal Views */
	private int mHowManyViews;
	/* Size of internal Views */
	private float mChildSizeRatio;
	
	private int mAnimationTime;
	
	private int dip;

	/**
	 * Constructor for VerticalCarouselStyle
	 * @param context - Application context
	 * @param style - Pre-existing style to be applied.
	 */
	public VerticalCarouselStyle(Context context, int style) {
		dip = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) 1, context.getResources().getDisplayMetrics());
		mSetInactiveViewTransparency = 1.0f;
		mHowManyViews = 99;
		mChildSizeRatio = 0.6f;
		mAnimationTime = 200;
		setStyle(style);
	}
	
	/**
	 * Carousel style to be set.
	 * @param style
	 */
	private void setStyle(int style) {
		switch(style) {
		case STYLE_RIGHT_ALIGNED:
			mSpaceBetweenViews = 80 * dip;
			mRotation = 0;
			mRotationEnabled = false;
			mTranslate = 50;
			mTranslatateEnbabled = true;
			break;
		case STYLE_LEFT_ALIGNED:
			mSpaceBetweenViews = 80 * dip;
			mRotation = 0;
			mRotationEnabled = false;
			mTranslate = -50;
			mTranslatateEnbabled = true;
			break;
		case STYLE_RIGHT_ALIGNED_WITH_ROTATION:
			mSpaceBetweenViews = 80 * dip;
			mRotation = 30;
			mRotationEnabled = true;
			mTranslate = 50;
			mTranslatateEnbabled = true;
			break;
		case STYLE_LEFT_ALIGNED_WITH_ROTATION:
			mSpaceBetweenViews = 80 * dip;
			mRotation = -30;
			mRotationEnabled = true;
			mTranslate = -50;
			mTranslatateEnbabled = true;
			break;
		default:
			mSpaceBetweenViews = 50 * dip;
			mRotation = 0;
			mRotationEnabled = false;
			mTranslate = 0;
			mTranslatateEnbabled = false;
			break;
		}
	}

	//~--- set methods --------------------------------------------------------
	
	/**
	 * @param mSetInactiveViewTransparency
	 *            the mSetInactiveViewTransparency to set
	 */
	public void setInactiveViewTransparency(
			float mSetInactiveViewTransparency) {
		this.mSetInactiveViewTransparency = mSetInactiveViewTransparency;
	}
	
	/**
	 * Define height space in between 2 views
	 * @param spaceInPixel
	 */
	public void setSpaceBetweenViews(int spaceInPixel) {
		mSpaceBetweenViews = spaceInPixel * dip;
	}

	/**
	 * Define rotation between 2 views
	 * @param rotation
	 */
	public void setRotation(int rotation) {
		mRotationEnabled = true;
		mRotation = rotation;
	}

	/**
	 * Define translate between 2 views
	 * @param translate
	 */
	public void setTranslate(int translate) {
		mTranslatateEnbabled = true;
		mTranslate = translate;
	}

	/**
	 * Specify number of child to display (only odd number for this version)
	 * @param howMany
	 * @return
	 */
	public boolean setHowManyViews(int howMany) {
		if (howMany % 2 != 0) {
			return false;
		}
		mHowManyViews = howMany;
		return true;
	}

	/**
	 * Specify size ratio of all children
	 * @param parentPerCent
	 * @return
	 */
	public boolean setChildSizeRation(float parentPerCent) {
		if ((parentPerCent > 1f) && (parentPerCent < 1f)) {
			return false;
		}
		mChildSizeRatio = parentPerCent;
		return true;
	}
	
	/**
	 * @param mAnimationTime the mAnimationTime to set
	 */
	public void setAnimationTime(int mAnimationTime) {
		this.mAnimationTime = mAnimationTime;
	}

	//~--- get methods --------------------------------------------------------
	
	/**
	 * @return the mSetInactiveViewTransparency
	 */
	public float getInactiveViewTransparency() {
		return mSetInactiveViewTransparency;
	}

	/**
	 * @return the mSpaceBetweenViews
	 */
	public int getSpaceBetweenViews() {
		return mSpaceBetweenViews;
	}

	/**
	 * @return the mRotation
	 */
	public int getRotation() {
		return mRotation;
	}

	/**
	 * @return the mRotationEnabled
	 */
	public boolean isRotationEnabled() {
		return mRotationEnabled;
	}

	/**
	 * @return the mTranslate
	 */
	public int getTranslate() {
		return mTranslate;
	}

	/**
	 * @return the mTranslatateEnbabled
	 */
	public boolean isTranslatateEnbabled() {
		return mTranslatateEnbabled;
	}

	/**
	 * @return the mHowManyViews
	 */
	public int getHowManyViews() {
		return mHowManyViews;
	}

	/**
	 * @return the mChildSizeRatio
	 */
	public float getChildSizeRatio() {
		return mChildSizeRatio;
	}

	/**
	 * @return the mAnimationTime
	 */
	public int getAnimationTime() {
		return mAnimationTime;
	}
}
