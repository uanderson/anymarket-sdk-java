package br.com.anymarket.sdk.util;

import org.apache.commons.lang3.StringUtils;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.*;

public class StateCodes {
    private static final Map<String, String> STATES = new HashMap<String, String>() {
        {
            put("SAO PAULO","SP");
            put("ACRE","AC");
            put("ALAGOAS","AL");
            put("AMAPA","AP");
            put("AMAZONAS","AM");
            put("BAHIA","BA");
            put("CEARA","CE");
            put("BRASILIA","DF");
            put("DISTRITO FEDERAL","DF");
            put("ESPIRITO SANTO","ES");
            put("GOIAS","GO");
            put("MARANHAO","MA");
            put("MATO GROSSO","MT");
            put("MATO GROSSO DO SUL","MS");
            put("MINAS GERAIS","MG");
            put("PARA","PA");
            put("PARAIBA","PB");
            put("PARANA","PR");
            put("PERNAMBUCO","PE");
            put("PIAUI","PI");
            put("RIO DE JANEIRO","RJ");
            put("RIO GRANDE DO NORTE","RN");
            put("RIO GRANDE DO SUL","RS");
            put("RONDONIA","RO");
            put("RORAIMA","RR");
            put("SANTA CATARINA","SC");
            put("SERGIPE","SE");
            put("TOCANTINS","TO");
        }
    };

    public static String getStateCode(String name) {
        if(isNull(name)) {
            return null;
        } else {
            String state = StringUtils.stripAccents(name);
            return STATES.get(state.toUpperCase());
        }
    }

}
