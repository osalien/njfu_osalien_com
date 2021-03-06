/*
 * Copyright 2020-2029 Coding实验室(https://osalien.com)
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

package com.osalien.njfu.generator.exception;

import com.osalien.njfu.framework.common.api.ApiCode;
import com.osalien.njfu.framework.common.exception.SpringBootPlusException;

/**
 * 代码生成异常
 *
 * @author Coding实验室
 * @date 2020/3/12
 */
public class GeneratorException extends SpringBootPlusException {
	private static final long serialVersionUID = 2556853577480934761L;

	public GeneratorException(String message) {
        super(message);
    }

    public GeneratorException(Integer errorCode, String message) {
        super(errorCode, message);
    }

    public GeneratorException(ApiCode apiCode) {
        super(apiCode);
    }
}
