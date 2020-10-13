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

package com.osalien.njfu.framework.common.exception;

import com.osalien.njfu.framework.common.api.ApiCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * njfu-osalien-com配置异常
 *
 * @author Coding实验室
 * @date 2020/3/21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SpringBootPlusConfigException extends SpringBootPlusException {

    private static final long serialVersionUID = 8952028631871769425L;

    private Integer errorCode;
    private String message;

    public SpringBootPlusConfigException() {
        super();
    }

    public SpringBootPlusConfigException(String message) {
        super(message);
        this.message = message;
    }

    public SpringBootPlusConfigException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public SpringBootPlusConfigException(ApiCode apiCode) {
        super(apiCode.getMessage());
        this.errorCode = apiCode.getCode();
        this.message = apiCode.getMessage();
    }

    public SpringBootPlusConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpringBootPlusConfigException(Throwable cause) {
        super(cause);
    }

}
