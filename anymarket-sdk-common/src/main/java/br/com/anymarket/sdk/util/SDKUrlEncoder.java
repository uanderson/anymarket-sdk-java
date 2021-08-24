package br.com.anymarket.sdk.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SDKUrlEncoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(SDKUrlEncoder.class);
    private static final String DEFAULT_ENCODE = "UTF-8";

    /**
     * Método utilizado para codificar o parametro de URL utilizando o padrão de códigos informado
     *
     * @param parameterToEncode Parâmetro para codificação
     * @param characterEncoding Mapa de caracteres de codificação
     * @return String parâmetro codificado
     */
    public static String encodeParameter(final String parameterToEncode, final String characterEncoding) {
        try {
            return URLEncoder.encode(parameterToEncode, characterEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LOGGER.error("Não foi possível executar URLEncode no parêmetro {}. Erro: {}", parameterToEncode, e.getMessage());
            return parameterToEncode;
        }
    }

    /**
     * Método utilizado para codificar o parâmetro de URL utilizando o padrão UTF-8
     *
     * @param parameterToEncode Parâmetro para codificação
     * @return String parâmetro codificado
     */
    public static String encodeParameterToUTF8(final String parameterToEncode) {
        return encodeParameter(parameterToEncode, DEFAULT_ENCODE);
    }
}
