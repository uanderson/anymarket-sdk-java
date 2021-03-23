package br.com.anymarket.sdk.http.headers;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class AnymarketHeaderUtils {

    public static IntegrationHeader[] addModuleOriginHeader(IntegrationHeader[] headers, String moduleOrigin) {
        if (StringUtils.isNotBlank(moduleOrigin)) {
            return ArrayUtils.add(headers, new ModuleOriginHeader(moduleOrigin));
        }
        return headers;
    }

}
