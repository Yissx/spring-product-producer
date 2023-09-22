ALTER TABLE public.orders ADD status VARCHAR NOT NULL;

CREATE TABLE public.stock(
    id uuid NOT NULL,
    product_id uuid NOT NULL,
    stock INT NOT NULL,
    CONSTRAINT stock_pk PRIMARY KEY (id),
    CONSTRAINT product_id_fk FOREIGN KEY (product_id) REFERENCES public.products(id)
);