/**
 * File: OutputModeValidator.java
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
package com.likethecolor.alchemy.api.validator;

import com.likethecolor.alchemy.api.Constants;

public class OutputModeValidator {
  public static void validate(final String outputMode) {
    if(outputMode == null || outputMode.trim().length() == 0) {
      throw new IllegalArgumentException("Output mode cannot be null/empty.");
    }

    if(!Constants.DEFAULT_OUTPUT_FORMAT.equals(outputMode)) {
      throw new IllegalArgumentException("Output mode unsupported [" + outputMode + "]  Supported: " + Constants.DEFAULT_OUTPUT_FORMAT);
    }
  }
}
