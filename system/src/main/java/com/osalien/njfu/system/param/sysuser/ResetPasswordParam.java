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

package com.osalien.njfu.system.param.sysuser;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 管理员重置用户密码参数
 *
 * @author Coding实验室
 * @date 2020-3-8
 **/
@Data
@Accessors(chain = true)
@ApiModel("管理员重置用户密码参数")
public class ResetPasswordParam implements Serializable {

    private static final long serialVersionUID = 5364321420976152005L;

    @ApiModelProperty("用户id")
    @NotNull(message = "用户id不能为空")
    private Long userId;

    @ApiModelProperty("新密码")
    @NotEmpty(message = "新密码不能为空")
    private String newPassword;

    @ApiModelProperty("新密码")
    @NotEmpty(message = "确认密码不能为空")
    private String confirmPassword;

}