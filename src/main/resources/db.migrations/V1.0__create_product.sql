CREATE TABLE public.products (
    id uuid NOT NULL,
    "name" VARCHAR NOT NULL,
    price DECIMAL NOT NULL,
    description VARCHAR NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);
