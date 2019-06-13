--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.12
-- Dumped by pg_dump version 9.5.12


--
-- Name: testbank_accounts; Type: TABLE; Schema: public;
--

CREATE TABLE public.testbank_accounts (
    id integer NOT NULL,
    name character varying(20) NOT NULL,
    type character varying(20) NOT NULL,
    overdraft integer NOT NULL,
    date character varying(20) NOT NULL,
    balance integer DEFAULT 300 NOT NULL,
    address character varying(80)
);


--
-- Name: testbank_config; Type: TABLE; Schema: public;
--

CREATE TABLE public.testbank_config (
    id integer NOT NULL,
    name character varying(20) NOT NULL,
    value character varying(40) NOT NULL,
    description character varying(60) NOT NULL
);


--
-- Name: testbank_login; Type: TABLE; Schema: public;
--

CREATE TABLE public.testbank_login (
    id integer NOT NULL,
    name character varying(10) NOT NULL,
    role character varying(10) NOT NULL
);


--
-- Name: testbank_setting; Type: TABLE; Schema: public;
--

CREATE TABLE public.testbank_setting (
    id integer NOT NULL,
    machine_name character varying(40) NOT NULL,
    setting character varying(60) NOT NULL,
    value character varying(60) NOT NULL
);


--
-- Name: testbank_txns; Type: TABLE; Schema: public;
--

CREATE TABLE public.testbank_txns (
    id integer NOT NULL,
    name character varying(20) NOT NULL,
    account integer NOT NULL,
    amount integer NOT NULL,
    type character varying(20) NOT NULL
);


--
-- PostgreSQL database dump complete
--
