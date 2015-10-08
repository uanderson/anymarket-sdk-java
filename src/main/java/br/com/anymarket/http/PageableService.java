package br.com.anymarket.http;

import br.com.anymarket.paging.Page;

public interface PageableService<T> {

    Page<T> previousPageFrom(Page<T> current);

    Page<T> nextPageFrom(Page<T> current);

}
