CREATE TABLE public.product (
    id id NOT NULL,
    "name" VARCHAR NOT NULL,
    price DECIMAL NOT NULL,
    description VARCHAR NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id),
);
