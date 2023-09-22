CREATE TABLE public.clients(
    id uuid NOT NULL,
    "name" VARCHAR NOT NULL,
    lastname VARCHAR NOT NULL,
    cellphone VARCHAR NOT NULL,
    address VARCHAR NOT NULL,
    CONSTRAINT clients_pk PRIMARY KEY (id),
);

CREATE TABLE public.orders(
    id uuid NOT NULL,
    client_id uuid NOT NULL,
    order_date DATE NOT NULL,
    CONSTRAINT orders_pk PRIMARY KEY (id),
    CONSTRAINT client_id_fk FOREIGN KEY (client_id) REFERENCES public.clients(id)
);

CREATE TABLE public.order_product(
    id uuid NOT NULL,
    product_id uuid NOT NULL,
    order_id uuid NOT NULL,
    CONSTRAINT order_product_pk PRIMARY KEY (id),
    CONSTRAINT product_id_fk FOREIGN KEY (product_id) REFERENCES public.products(id),
    CONSTRAINT order_fk FOREIGN KEY (order_id) REFERENCES public.orders(id)
);