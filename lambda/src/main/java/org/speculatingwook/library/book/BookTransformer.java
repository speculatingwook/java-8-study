package org.speculatingwook.library.book;

import org.speculatingwook.library.Book;

public interface BookTransformer <T>{
    T transform(Book book);
}
