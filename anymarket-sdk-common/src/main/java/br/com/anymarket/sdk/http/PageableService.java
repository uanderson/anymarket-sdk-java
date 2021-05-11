package br.com.anymarket.sdk.http;

import br.com.anymarket.sdk.paging.Page;

public interface PageableService<T> {

    Page<T> previousPageFrom(Page<T> current);

    Page<T> nextPageFrom(Page<T> current);

}
