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

import com.alibaba.fastjson.JSON;
import com.bc.lottery.common.domain.tenant.TenantAdmin;
import com.bc.lottery.tenant.vo.TenantAdminVO;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
public class TenantAdminWrapperTest {

	@Test
	public void testEntityVO() {
        TenantAdminWrapper tenantAdminWrapper = new TenantAdminWrapper();
		System.out.println(JSON.toJSONString(tenantAdminWrapper.entityVO(createTenantAdmin())));
	}


    @Test
    public void testListEntityVO() {
        TenantAdminWrapper tenantAdminWrapper = new TenantAdminWrapper();
        List<TenantAdmin> list = Arrays.asList(createTenantAdmin(), createTenantAdmin());
        System.out.println(JSON.toJSONString(tenantAdminWrapper.listEntityVO(list)));
    }

    private TenantAdmin createTenantAdmin() {
        TenantAdmin tenantAdmin = new TenantAdmin();
        tenantAdmin.setEmail("1111");
        tenantAdmin.setId(1L);
        tenantAdmin.setMobile("15710073485");
        tenantAdmin.setNickname("我是谁");
        return tenantAdmin;
    }
}
