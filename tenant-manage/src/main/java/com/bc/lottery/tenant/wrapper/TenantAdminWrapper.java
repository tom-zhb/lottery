/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bc.lottery.tenant.wrapper;

import com.bc.lottery.common.domain.tenant.TenantAdmin;
import com.bc.lottery.common.enums.RoleEnum;
import com.bc.lottery.common.enums.StateEnum;
import com.bc.lottery.common.util.BeanUtils;
import com.bc.lottery.common.wrapper.BaseEntityWrapper;
import com.bc.lottery.tenant.vo.TenantAdminVO;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 包装类,返回视图层所需的字段
 *
 * @author Chill
 */
public class TenantAdminWrapper extends BaseEntityWrapper<TenantAdmin, TenantAdminVO> {

    @Override
    public TenantAdminVO entityVO(TenantAdmin tenantAdmin) {
        TenantAdminVO tenantAdminVO = BeanUtils.copy(tenantAdmin, TenantAdminVO.class);
        tenantAdminVO.setRoleName(getRoleName(tenantAdmin.getRole()));
        tenantAdminVO.setStateName(getStateName(tenantAdmin.getState()));
        tenantAdminVO.setPassword(null);
        return tenantAdminVO;
    }

    public List<TenantAdminVO> listEntityVO(List<TenantAdmin> list) {
        return list.stream().map(this::entityVO).collect(Collectors.toList());
    }

    private String getStateName(int state) {
        if (NumberUtils.compare(state, StateEnum.NORMAL.getRole()) == 0) {
            return RoleEnum.ADMINISTRATOR.getRoleName();
        } else if (NumberUtils.compare(state, StateEnum.FORBIDDEN.getRole()) == 0) {
            return RoleEnum.SUPER_ADMINISTRATOR.getRoleName();
        } else {
            return null;
        }
    }

    private String getRoleName(int role) {
        if (NumberUtils.compare(role, RoleEnum.ADMINISTRATOR.getRole()) == 0) {
            return RoleEnum.ADMINISTRATOR.getRoleName();
        } else if (NumberUtils.compare(role, RoleEnum.SUPER_ADMINISTRATOR.getRole()) == 0) {
            return RoleEnum.SUPER_ADMINISTRATOR.getRoleName();
        } else {
            return null;
        }
    }
}
