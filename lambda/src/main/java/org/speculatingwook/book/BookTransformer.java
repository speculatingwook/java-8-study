package org.speculatingwook.book;

import org.speculatingwook.domain.Book;

public interface BookTransformer <T>{
    T transform(Book book);
}
