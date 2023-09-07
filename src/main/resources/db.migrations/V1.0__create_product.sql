CREATE TABLE public.product (
    id BIGINT NULL,
    "name" VARCHAR NULL,
    price DECIMAL NULL,
    description VARCHAR NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);
