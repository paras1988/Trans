package com.Sample2.cache;

import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "request")
public class ParryCacheMap extends HashMap<String, Object> {

}
