/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
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
package com.alibaba.nacos.api.naming;

import com.alibaba.nacos.api.exception.NacosException;

import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * Naming Factory
 *
 * @author nkorange
 */
public class NamingFactory {

    public static NamingService createNamingService(String serverList) throws NacosException {
        try {
            Class<?> driverImplClass = Class.forName("com.alibaba.nacos.client.naming.NacosNamingService");
            Constructor constructor = driverImplClass.getConstructor(String.class);
            NamingService vendorImpl = (NamingService) constructor.newInstance(serverList);
            return vendorImpl;
        } catch (Throwable e) {
            throw new NacosException(NacosException.CLIENT_INVALID_PARAM, e);
        }
    }

    public static NamingService createNamingService(String serverList, String apiVersion) throws NacosException {
        try {
            Class<?> driverImplClass = Class.forName("com.alibaba.nacos.client.naming.NacosNamingService");
            Constructor constructor = driverImplClass.getConstructor(String.class, String.class);
            NamingService vendorImpl = (NamingService) constructor.newInstance(serverList, apiVersion);
            return vendorImpl;
        } catch (Throwable e) {
            throw new NacosException(NacosException.CLIENT_INVALID_PARAM, e);
        }
    }

    public static NamingService createNamingService(Properties properties) throws NacosException {
        try {
            Class<?> driverImplClass = Class.forName("com.alibaba.nacos.client.naming.NacosNamingService");
            Constructor constructor = driverImplClass.getConstructor(Properties.class);
            NamingService vendorImpl = (NamingService) constructor.newInstance(properties);
            return vendorImpl;
        } catch (Throwable e) {
            throw new NacosException(NacosException.CLIENT_INVALID_PARAM, e);
        }
    }
}
