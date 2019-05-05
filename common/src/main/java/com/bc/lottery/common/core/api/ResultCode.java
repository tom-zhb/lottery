/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bc.lottery.common.core.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务代码枚举
 *
 * @author Chill
 */
@Getter
@AllArgsConstructor
public enum ResultCode implements IResultCode {

	SUCCESS(0, "sucess"),

	FAILURE(1, "fail");

	/*// -------------------失败状态码----------------------
    // 参数错误
	PARAMS_IS_NULL(10001, "参数为空"),
	PARAMS_NOT_COMPLETE(10002, "参数不全"),
	PARAMS_TYPE_ERROR(1003, "参数类型错误"),
	PARAMS_IS_INVALID(10004, "参数无效"),

	// 用户错误
	USER_NOT_EXIST(20001, "用户不存在"),
	USER_NOT_LOGGED_IN(20002, "用户未登陆"),
	USER_ACCOUNT_ERROR(20003, "用户名或密码错误"),
	USER_ACCOUNT_FORBIDDEN(20004, "用户账户已被禁用"),
	USER_HAS_EXIST(20005, "参数为空"),

	// 业务错误
	BUSINESS_ERROR(30001, "系统业务出现问题"),

	// 系统错误
	SYSTEM_INNER_ERROR(40001, "系统内部错误"),

	// 数据错误
	DATA_NOT_FOUND(50001, "数据未找到"),
	DATA_IS_WRONG(50002, "数据有误"),
	DATA_ALREADY_EXISTED(50003, "数据已存在"),

	// 接口错误
	INTERFACE_INNER_INVOKE_ERROR(60001, "系统内部接口调用异常"),
	INTERFACE_OUTER_INVOKE_ERROR(60002, "系统外部接口调用异常"),
	INTERFACE_FORBIDDEN(60003, "接口禁止访问"),
	INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
	INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
	INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

	// 权限错误
	PERMISSION_NO_ACCESS(70001, "没有访问权限");*/

	/**
	 * code编码
	 */
	final int code;
	/**
	 * 中文信息描述
	 */
	final String message;

}
