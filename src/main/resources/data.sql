--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.12
-- Dumped by pg_dump version 9.5.12

--
-- Data for Name: testbank_accounts; Type: TABLE DATA; Schema: public;
--

INSERT INTO public.testbank_accounts (id, name, type, overdraft, date, balance, address) VALUES (10, 'ORDER BY 11-- yhGx', 'nochange(,")()'')((', 12345, '10/2/2007', 100, 'UNION ALL SELECT NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL-- xiJl');
INSERT INTO public.testbank_accounts (id, name, type, overdraft, date, balance, address) VALUES (2, 'Gary Robinson', 'ISA', 2000, '8/5/2013', 300, '15 Main Street');
INSERT INTO public.testbank_accounts (id, name, type, overdraft, date, balance, address) VALUES (1, 'Gary Robinson', 'ISA', 2000, '8/10/2005', 300, '15 Main Street');
INSERT INTO public.testbank_accounts (id, name, type, overdraft, date, balance, address) VALUES (5, 'Mike Hunt', 'ISA', 2000, '5/7/2010', 4550, '15 Main Street');
INSERT INTO public.testbank_accounts (id, name, type, overdraft, date, balance, address) VALUES (7, 'Gary Robinson', 'ISA', 2000, '1/9/2013', 770, '15 Main Street');
INSERT INTO public.testbank_accounts (id, name, type, overdraft, date, balance, address) VALUES (6, 'Gary Robinson', 'ISA', 2000, '21/8/2008', 34, '15 Main Street');
INSERT INTO public.testbank_accounts (id, name, type, overdraft, date, balance, address) VALUES (9, 'Gary Robinson', 'ISA', 2000, '5/12/2015', 903, '15 Main Street');
INSERT INTO public.testbank_accounts (id, name, type, overdraft, date, balance, address) VALUES (8, 'Gary Robinson', 'ISA', 2000, '21/12/2011', 12400, '15 Main Street');
INSERT INTO public.testbank_accounts (id, name, type, overdraft, date, balance, address) VALUES (3, 'Gary Robinson', 'ISA', 2000, '1/4/2000', 2300, '15 Main Street');
INSERT INTO public.testbank_accounts (id, name, type, overdraft, date, balance, address) VALUES (4, 'Gary Robinson', 'ISA', 2000, '1/4/2000', 50, '15 Main Street');


--
-- Data for Name: testbank_config; Type: TABLE DATA; Schema: public;
--

INSERT INTO public.testbank_config (id, name, value, description) VALUES (5, 'Turkey-Logging-En', '414635', 'Is extra logging enabled for Turkey based transfers.');
INSERT INTO public.testbank_config (id, name, value, description) VALUES (1, 'Max-Overdraft-Limit', 'or2uyh6f6mhmq3l8jftp7h9h43x9pqgkxam', 'Maximum overdraft allowed.');
INSERT INTO public.testbank_config (id, name, value, description) VALUES (4, 'Two-Factor-Auth', '444447', 'Is 2FA required to conduct funds transfers.');
INSERT INTO public.testbank_config (id, name, value, description) VALUES (3, 'Dflt-Error-Msg', 'g4y3j9o17c2lia0it6swq2nh07tdlucotei', 'Message to display during Maintenance.');
INSERT INTO public.testbank_config (id, name, value, description) VALUES (7, 'Maintenance-URL', '801135', 'URL splashscreen to display during maintenance windows.');
INSERT INTO public.testbank_config (id, name, value, description) VALUES (6, 'Failover-URL', '952317', 'URL splashscreen to display during heavy load.');
INSERT INTO public.testbank_config (id, name, value, description) VALUES (2, 'Maintenance-Ctdown', '549064', 'Time, alert users to maintenance window.');


--
-- Data for Name: testbank_login; Type: TABLE DATA; Schema: public;
--

INSERT INTO public.testbank_login (id, name, role) VALUES (1, 'Richard', 'admin');
INSERT INTO public.testbank_login (id, name, role) VALUES (1, 'Steven', 'banker');
INSERT INTO public.testbank_login (id, name, role) VALUES (1, 'Mike', 'leadbanker');


--
-- Data for Name: testbank_setting; Type: TABLE DATA; Schema: public;
--

INSERT INTO public.testbank_setting (id, machine_name, setting, value) VALUES (1, 'host101.intranet.net', '/var disk space', '23%');
INSERT INTO public.testbank_setting (id, machine_name, setting, value) VALUES (2, 'host101.intranet.net', '/opt disk space', '7%');
INSERT INTO public.testbank_setting (id, machine_name, setting, value) VALUES (3, 'host101.intranet.net', '/mnt disk space', '54%');
INSERT INTO public.testbank_setting (id, machine_name, setting, value) VALUES (4, 'host101.intranet.net', 'Average CPU (5 mins)', '6%');
INSERT INTO public.testbank_setting (id, machine_name, setting, value) VALUES (5, 'host101.intranet.net', 'Average CPU (60 mins)', '5%');
INSERT INTO public.testbank_setting (id, machine_name, setting, value) VALUES (10, 'host102.intranet.net', 'Average CPU (60 mins)', '5%');
INSERT INTO public.testbank_setting (id, machine_name, setting, value) VALUES (6, 'host102.intranet.net', '/var disk space', '7%');
INSERT INTO public.testbank_setting (id, machine_name, setting, value) VALUES (7, 'host102.intranet.net', '/opt disk space', '7%');
INSERT INTO public.testbank_setting (id, machine_name, setting, value) VALUES (8, 'host102.intranet.net', '/mnt disk space', '34%');
INSERT INTO public.testbank_setting (id, machine_name, setting, value) VALUES (9, 'host102.intranet.net', 'Average CPU (5 mins)', '4%');
INSERT INTO public.testbank_setting (id, machine_name, setting, value) VALUES (11, 'loadbalancer.intranet.net', 'Requests per second (5 minutes)', '7');
INSERT INTO public.testbank_setting (id, machine_name, setting, value) VALUES (12, 'loadbalancer.intranet.net', 'Requests per second (60 minutes)', '10');
INSERT INTO public.testbank_setting (id, machine_name, setting, value) VALUES (13, 'loadbalancer.intranet.net', 'Average CPU (5 minutes)', '10');
INSERT INTO public.testbank_setting (id, machine_name, setting, value) VALUES (14, 'loadbalancer.intranet.net', 'Average CPU (60 minutes)', '8');


--
-- Data for Name: testbank_txns; Type: TABLE DATA; Schema: public;
--

INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Jayson Kingsberry', 46678781, 80, 'Deposit');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Jayson Kingsberry', 46678781, 10, 'Xfer acct 46611324');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Jayson Kingsberry', 46678781, 210, 'Pmt ref AccountMtly');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Jayson Kingsberry', 46678781, 15, 'Deposit');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Nola Sullins', 77215459, 320, 'Pmt ref George');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Nola Sullins', 77215459, 520, 'Deposit');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Nola Sullins', 77215459, 20, 'Deposit');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Nola Sullins', 77215459, 4300, 'Xfer acct 77271342');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Mariah Vandergrift', 79925467, 150, 'Deposit');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Mariah Vandergrift', 79925467, 100, 'Deposit');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Mariah Vandergrift', 79925467, 100, 'Deposit');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Shella Mrozek', 46678901, 90, 'Xfer acct 77215459');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Shella Mrozek', 46678901, 32, 'Pmt ref ZooFund');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Shella Mrozek', 46678901, 50, 'Pmt ref Holiday');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Shella Mrozek', 46678901, 1000, 'Deposit');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Eduardo Fife', 46672300, 15, 'Deposit');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Eduardo Fife', 46672300, 105, 'Deposit');
INSERT INTO public.testbank_txns (id, name, account, amount, type) VALUES (1, 'Eduardo Fife', 46672300, 10, 'Pmt ref Dog');


--
-- PostgreSQL database dump complete
--
