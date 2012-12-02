/**
 * File: KeywordParams.java
 * Original Author: Dan Brown <dan@likethecolor.com>
 * Copyright 2012 Dan Brown <dan@likethecolor.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.likethecolor.alchemy.api.params;

import com.likethecolor.alchemy.api.Constants;
import org.apache.commons.lang.StringUtils;

public class KeywordParams extends Params {
  private String baseUrl;
  private String constraintQuery;
  private String keywordExtractMode;
  private int maxRetrieve = Constants.DEFAULT_MAX_RETRIEVE;
  private boolean isShowSourceText;
  private boolean isShowSentiment;
  private String sourceText;
  private String xPath;

  public void setBaseUrl(String baseUrl) {
    if(baseUrl != null) {
      baseUrl = baseUrl.trim();
    }
    this.baseUrl = baseUrl;
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public void setConstraintQuery(String constraintQuery) {
    if(constraintQuery != null) {
      constraintQuery = constraintQuery.trim();
    }
    this.constraintQuery = constraintQuery;
  }

  public String getConstraintQuery() {
    return constraintQuery;
  }

  public void setKeywordExtractMode(String keywordExtractMode) {
    if(keywordExtractMode == null) {
      this.keywordExtractMode = null;
      return;
    }

    keywordExtractMode = keywordExtractMode.trim().toLowerCase();
    if(keywordExtractMode.equals(Constants.KEYWORD_EXTRACT_MODE_STRICT)) {
      this.keywordExtractMode = keywordExtractMode;
    }
  }

  public String getKeywordExtractMode() {
    return keywordExtractMode;
  }

  public void setSourceText(String sourceText) {
    if(StringUtils.isBlank(sourceText)) {
      this.sourceText = null;
      return;
    }
    sourceText = sourceText.trim().toLowerCase();
    if(Constants.SOURCE_TEXT_CLEANED_OR_RAW.equals(sourceText)
       || Constants.SOURCE_TEXT_CLEANED.equals(sourceText)
       || Constants.SOURCE_TEXT_CONSTRAINTS_QUERY.equals(sourceText)
       || Constants.SOURCE_TEXT_RAW.equals(sourceText)
       || Constants.SOURCE_TEXT_XPATH.equals(sourceText)) {
      this.sourceText = sourceText;
    }
  }

  public String getSourceText() {
    return sourceText;
  }

  public void setMaxRetrieve(int maxRetrieve) {
    if(maxRetrieve > Constants.MAX_MAX_RETRIEVE) {
      maxRetrieve = Constants.DEFAULT_MAX_RETRIEVE;
    }
    else if(maxRetrieve < Constants.MIN_MAX_RETRIEVE) {
      maxRetrieve = Constants.DEFAULT_MAX_RETRIEVE;
    }
    this.maxRetrieve = maxRetrieve;
  }

  public int getMaxRetrieve() {
    return maxRetrieve;
  }

  public void setIsShowSourceText(final boolean showSourceText) {
    this.isShowSourceText = showSourceText;
  }

  public boolean isShowSourceText() {
    return isShowSourceText;
  }

  public void setIsShowSentiment(boolean showSentiment) {
    this.isShowSentiment = showSentiment;
  }

  public boolean isShowSentiment() {
    return isShowSentiment;
  }

  public void setXPath(String xPath) {
    if(xPath != null) {
      xPath = xPath.trim();
    }
    this.xPath = xPath;
  }

  public String getXPath() {
    return xPath;
  }

  public String toString() {
    return new StringBuilder(super.toString())
        .append(createParam(Constants.PARAM_BASE_URL, encode(baseUrl)))
        .append(createParam(Constants.PARAM_CONSTRAINT_QUERY, encode(constraintQuery)))
        .append(createParam(Constants.PARAM_KEYWORD_EXTRACT_MODE, encode(keywordExtractMode)))
        .append(createParam(Constants.PARAM_MAX_RETRIEVE, maxRetrieve))
        .append(createParam(Constants.PARAM_SHOW_SENTIMENT,
            isShowSentiment ? 1 : 0))
        .append(createParam(Constants.PARAM_SHOW_SOURCE_TEXT,
            isShowSourceText ? 1 : 0))
        .append(createParam(Constants.PARAM_SOURCE_TEXT, sourceText))
        .append(createParam(Constants.PARAM_XPATH, encode(xPath)))
        .toString();
  }
}
