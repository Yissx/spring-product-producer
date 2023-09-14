CREATE TABLE public.client(
    id id NOT NULL,
    "name" VARCHAR NOT NULL,
    lastname VARCHAR NOT NULL,
    cellphone VARCHAR NOT NULL,
    adress VARCHAR NOT NULL,
    CONSTRAINT client_pk PRIMARY KEY (id),
);

CREATE TABLE public.order(
    id id NOT NULL,
    client_id id NOT NULL,
    order_date DATE NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (id),
    CONSTRAINT client_id_fk FOREIGN KEY (client_id) REFERENCES public.client(id)
);

CREATE TABLE public.order_product(
    id id NOT NULL,
    product_id id NOT NULL,
    order_id id NOT NULL,
    CONSTRAINT order_product_pk PRIMARY KEY (id),
    CONSTRAINT product_id_fk FOREIGN KEY (product_id) REFERENCES public.product(id),
    CONSTRAINT order_fk FOREIGN KEY (order_id) REFERENCES public.order(id)
);