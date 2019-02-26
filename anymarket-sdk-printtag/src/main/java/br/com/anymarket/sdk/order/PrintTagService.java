package br.com.anymarket.sdk.order;

import br.com.anymarket.sdk.SDKConstants;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.order.dto.PrintTagResource;
import com.google.common.base.Preconditions;

import static br.com.anymarket.sdk.http.restdsl.AnyMarketRestDSL.post;
import static com.google.common.base.Strings.isNullOrEmpty;

public class PrintTagService {

    private String apiEndPointForResource;

    public PrintTagService(String apiEndPoint) {
        this.apiEndPointForResource = !isNullOrEmpty(apiEndPoint) ? apiEndPoint :
            SDKConstants.ANYMARKET_HOMOLOG_API_ENDPOINT;
    }

    public Object getPrintTag(PrintTagResource printTag, PrintType printType, IntegrationHeader... headers) {
        return getPrintTag(printTag, printType, null, headers);
    }

    public Object getPrintTag(PrintTagResource printTag, PrintType printType, FileType file, IntegrationHeader... headers) {
        Preconditions.checkNotNull(printTag, "Erro ao emitir etiqueta: Dados não encontrados.");
        Preconditions.checkNotNull(printType, "Erro ao emitir etiqueta: Tipo não informado.");


        String url = apiEndPointForResource.concat("/printtag/").concat(printType.getName());
        if(file != null){
            url.concat("?file=").concat(file.getName());
        }
        return post(url)
            .body(printTag)
            .headers(headers)
            .getResponse()
            .to(Object.class);
    }
}
