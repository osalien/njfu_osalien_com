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

package com.osalien.njfu.framework.shiro.vo;

import com.osalien.njfu.framework.common.bean.ClientInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 登录用户Redis对象，后台使用
 *
 * @author Coding实验室
 * @date 2019-9-30
 **/
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class LoginSysUserRedisVo extends LoginSysUserVo {

    private static final long serialVersionUID = -3858850188055605806L;

    /**
     * 包装后的盐值
     */
    private String salt;

    /**
     * 登录ip
     */
    private ClientInfo clientInfo;

}