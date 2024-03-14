package com.example.demo.Util;

import org.hibernate.query.Query;

public class Paginator {

    public static Query paginate(Query query, int page, int pageSize) {
        query.setFirstResult((page - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query;
    }
}
