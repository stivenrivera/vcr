-- Dumped from database version 16.8
-- Dumped by pg_dump version 16.8

-- Started on 2025-04-02 23:50:57

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 16430)
-- Name: db_empresa; Type: SCHEMA; Schema: -
--

CREATE SCHEMA db_empresa;

--
-- TOC entry 7 (class 2615 OID 16452)
-- Name: db_seguridad; Type: SCHEMA; Schema: -
--

CREATE SCHEMA db_seguridad;

--
-- TOC entry 8 (class 2615 OID 16471)
-- Name: db_token; Type: SCHEMA; Schema: -
--

CREATE SCHEMA db_token;

--
-- TOC entry 10 (class 2615 OID 16559)
-- Name: dbemergency; Type: SCHEMA; Schema: -
--

CREATE SCHEMA dbemergency;

--
-- TOC entry 11 (class 2615 OID 16575)
-- Name: dbequipos; Type: SCHEMA; Schema: -
--

CREATE SCHEMA dbequipos;
create schema dbusers;
--
-- TOC entry 9 (class 2615 OID 16542)
-- Name: dbnotifica; Type: SCHEMA; Schema: -
--

CREATE SCHEMA dbnotifica;

--
-- TOC entry 13 (class 2615 OID 16631)
-- Name: dbpersonas; Type: SCHEMA; Schema: -
--

CREATE SCHEMA dbpersonas;
--
-- TOC entry 12 (class 2615 OID 16399)
-- Name: dbusers; Type: SCHEMA; Schema: -; Owner: postgres
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 16.8
-- Dumped by pg_dump version 16.8

-- Started on 2025-04-02 23:50:57


--
-- TOC entry 6 (class 2615 OID 16430)
-- Name: db_empresa; Type: SCHEMA; Schema: -
--

--
-- TOC entry 241 (class 1255 OID 16640)
-- Name: funcion_trigger_administrador(); Type: FUNCTION; Schema: db_empresa;
--

CREATE FUNCTION db_empresa.funcion_trigger_administrador() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
    -- Insertar en la tabla personas cuando se inserte un administrador
    INSERT INTO dbpersonas.personas (dni, primernombre, segundonombre, primerapellido, segundoapellido, telefono, mail)
    VALUES (NEW.dni, NEW.primernombre, NEW.segundonombre, NEW.primerapellido, NEW.segundoapellido, NEW.telefono, NEW.mail)
    ON CONFLICT (dni) DO NOTHING; -- Evita duplicados si ya existe

    RETURN NEW;
END;
$$;

--
-- TOC entry 242 (class 1255 OID 16642)
-- Name: insertar_persona_desde_administrador(); Type: FUNCTION; Schema: db_empresa;
--

CREATE FUNCTION db_empresa.insertar_persona_desde_administrador() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
    INSERT INTO dbpersonas.personas (dni, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, telefono, mail) 
    VALUES (NEW.dni, new.primer_nombre, new.segundo_nombre, new.primer_apellido, new.segundo_apellido, new.telefono, new.mail);
   RETURN NEW;
END;
$$;

--
-- TOC entry 228 (class 1259 OID 16438)
-- Name: administrador; Type: TABLE; Schema: db_empresa;
--

CREATE TABLE db_empresa.administrador (
    dni character varying(20) NOT NULL,
    primer_nombre character varying(50),
    segundo_nombre character varying(50),
    primer_apellido character varying(50),
    segundo_apellido character varying(50),
    telefono character varying(15),
    id SERIAL NOT NULL,
    mail character varying(255)
);

--
-- TOC entry 239 (class 1259 OID 16624)
-- Name: administrador_id_seq; Type: SEQUENCE; Schema: db_empresa;
--


--
-- TOC entry 227 (class 1259 OID 16431)
-- Name: empresa; Type: TABLE; Schema: db_empresa;
--

CREATE TABLE db_empresa.empresa (
    nombre character varying(100),
    direccion character varying(255),
    correo character varying(100),
    celular character varying(15),
    dni character varying(20) NOT NULL,
    director character varying(100),
    dni_director character varying(20),
    telefono_directo character varying(15)
);

--
-- TOC entry 231 (class 1259 OID 16462)
-- Name: guardias; Type: TABLE; Schema: db_seguridad; Owner: postgres
--

CREATE TABLE db_seguridad.guardias (
    dni character varying(20) NOT NULL,
    primer_apellido character varying(50),
    segundo_apellido character varying(50),
    primer_nombre character varying(50),
    segundo_nombre character varying(50),
    telefono character varying(15),
    fecha_de_nacimiento date,
    codigo_guardia character varying(50),
    record_militar character varying(100),
    id_guardia SERIAL NOT NULL,
    reg_auditoria timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    correo character varying(100)
);

--
-- TOC entry 239 (class 1259 OID 16624)
-- Name: guardias_id_guardia_seq; Type: SEQUENCE; Schema: db_seguridad;
--

--
-- TOC entry 229 (class 1259 OID 16453)
-- Name: seguridad; Type: TABLE; Schema: db_seguridad;
--

CREATE TABLE db_seguridad.seguridad (
    dni character varying(20) NOT NULL,
    nombre_comercial character varying(100),
    razon_social character varying(100),
    rep_legal character varying(100),
    direccion character varying(255),
    correo character varying(100),
    telefono character varying(15),
    reg_auditoria timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);

--
-- TOC entry 232 (class 1259 OID 16472)
-- Name: token; Type: TABLE; Schema: db_token;
--

CREATE TABLE db_token.token (
    token character varying(255) NOT NULL,
    reg_security text,
    reg_equipment text
);

--
-- TOC entry 236 (class 1259 OID 16561)
-- Name: emergency; Type: TABLE; Schema: dbemergency;
--

CREATE TABLE dbemergency.emergency (
    id_emergency SERIAL NOT NULL,
    id_usuario SERIAL,
    descripcion text,
    fecha timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);

--
-- TOC entry 235 (class 1259 OID 16560)
-- Name: emergency_id_emergency_seq; Type: SEQUENCE; Schema: dbemergency;
--


--
-- TOC entry 238 (class 1259 OID 16577)
-- Name: equipo; Type: TABLE; Schema: dbequipos;
--

CREATE TABLE dbequipos.equipo (
    id_equipo SERIAL NOT NULL,
    id_usuario SERIAL,
    android_id character varying(255),
    marca character varying(255),
    modelo character varying(255),
    version_os character varying(50),
    fecha_registro timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    imei character varying(15),
    num_telefono character varying(20)
);

--
-- TOC entry 237 (class 1259 OID 16576)
-- Name: equipo_id_equipo_seq; Type: SEQUENCE; Schema: dbequipos;
--


--
-- TOC entry 234 (class 1259 OID 16544)
-- Name: notifica; Type: TABLE; Schema: dbnotifica; Owner: postgres
--
-- Crear esquema dbnotifica

-- Crear tabla notifica
CREATE TABLE dbnotifica.notifica (
    id_notificacion SERIAL NOT NULL,
    id_usuario SERIAL,
    mensaje text,
    tipo character varying(20),
    fecha_envio timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT notifica_tipo_check CHECK (((tipo)::text = ANY ((ARRAY['alerta'::character varying, 'información'::character varying])::text[])))
);



-- Crear esquema dbpersonas


-- Crear tabla personas
CREATE TABLE dbpersonas.personas (
    dni character varying(15) NOT NULL,
    primer_nombre character varying(50),
    segundo_nombre character varying(50),
    primer_apellido character varying(50),
    segundo_apellido character varying(50),
    telefono character varying(20),
    mail character varying(100),
    fecha_registro timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);

-- Crear esquema dbusers


-- Crear tabla passwords
CREATE TABLE dbusers.passwords (
    id SERIAL NOT NULL,
    user_id SERIAL NOT NULL,
    password text NOT NULL,
    password_viejo text,
    reg_security text
);


-- Crear tabla users
CREATE TABLE dbusers.users (
    id SERIAL NOT NULL,
    username character varying(255) NOT NULL,
    reg_security text
);






-- Crear esquema db_seguridad



-- Crear esquema db_emergency




-- Crear esquema dbequipos



-- Crear esquema db_seguridad




-- Crear esquema dbemergency


-- Crear tabla emergency

-- Crear secuencia emergency_id_emergency_seq
-- Crear esquema dbequipos



-- Crear esquema dbpersonas

-- Crear esquema dbusers



-- Crear esquema db_empresa


-- Crear tabla administrador
-- Crear claves primarias y restricciones
ALTER TABLE ONLY db_empresa.administrador ADD CONSTRAINT administrador_pkey PRIMARY KEY (dni);
ALTER TABLE ONLY db_seguridad.guardias ADD CONSTRAINT guardias_pkey PRIMARY KEY (dni);
ALTER TABLE ONLY db_seguridad.seguridad ADD CONSTRAINT seguridad_pkey PRIMARY KEY (dni);
ALTER TABLE ONLY db_seguridad.guardias ADD CONSTRAINT guardias_id_guardia_key UNIQUE (id_guardia);
-- TOC entry 4778 (class 2606 OID 16478)
-- Name: token token_pkey; Type: CONSTRAINT; Schema: db_token;

ALTER TABLE ONLY db_token.token
    ADD CONSTRAINT token_pkey PRIMARY KEY (token);


-- TOC entry 4782 (class 2606 OID 16569)
-- Name: emergency emergency_pkey; Type: CONSTRAINT; Schema: dbemergency;

ALTER TABLE ONLY dbemergency.emergency
    ADD CONSTRAINT emergency_pkey PRIMARY KEY (id_emergency);


-- TOC entry 4784 (class 2606 OID 16587)
-- Name: equipo equipo_android_id_key; Type: CONSTRAINT; Schema: dbequipos;

ALTER TABLE ONLY dbequipos.equipo
    ADD CONSTRAINT equipo_android_id_key UNIQUE (android_id);


-- TOC entry 4786 (class 2606 OID 16585)
-- Name: equipo equipo_pkey; Type: CONSTRAINT; Schema: dbequipos;

ALTER TABLE ONLY dbequipos.equipo
    ADD CONSTRAINT equipo_pkey PRIMARY KEY (id_equipo);


-- TOC entry 4780 (class 2606 OID 16553)
-- Name: notifica notifica_pkey; Type: CONSTRAINT; Schema: dbnotifica;

ALTER TABLE ONLY dbnotifica.notifica
    ADD CONSTRAINT notifica_pkey PRIMARY KEY (id_notificacion);


-- TOC entry 4788 (class 2606 OID 16639)
-- Name: personas personas_mail_key; Type: CONSTRAINT; Schema: dbpersonas;

ALTER TABLE ONLY dbpersonas.personas
    ADD CONSTRAINT personas_mail_key UNIQUE (mail);


-- TOC entry 4790 (class 2606 OID 16637)
-- Name: personas personas_pkey; Type: CONSTRAINT; Schema: dbpersonas;

ALTER TABLE ONLY dbpersonas.personas
    ADD CONSTRAINT personas_pkey PRIMARY KEY (dni);


-- TOC entry 4764 (class 2606 OID 16421)
-- Name: passwords passwords_pkey; Type: CONSTRAINT; Schema: dbusers;

ALTER TABLE ONLY dbusers.passwords
    ADD CONSTRAINT passwords_pkey PRIMARY KEY (id);


-- TOC entry 4766 (class 2606 OID 16423)
-- Name: passwords passwords_user_id_key; Type: CONSTRAINT; Schema: dbusers;

ALTER TABLE ONLY dbusers.passwords
    ADD CONSTRAINT passwords_user_id_key UNIQUE (user_id);


-- TOC entry 4760 (class 2606 OID 16410)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: dbusers;

ALTER TABLE ONLY dbusers.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


-- TOC entry 4762 (class 2606 OID 16412)
-- Name: users users_user_key; Type: CONSTRAINT; Schema: dbusers;

ALTER TABLE ONLY dbusers.users
    ADD CONSTRAINT users_user_key UNIQUE (username);


-- TOC entry 4795 (class 2620 OID 16644)
-- Name: administrador trigger_administrador_personas; Type: TRIGGER; Schema: db_empresa;



-- TOC entry 4793 (class 2606 OID 16570)
-- Name: emergency emergency_id_usuario_fkey; Type: FK CONSTRAINT; Schema: dbemergency;

ALTER TABLE ONLY dbemergency.emergency
    ADD CONSTRAINT emergency_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES dbusers.users(id);


-- TOC entry 4794 (class 2606 OID 16588)
-- Name: equipo equipo_id_usuario_fkey; Type: FK CONSTRAINT; Schema: dbequipos;

ALTER TABLE ONLY dbequipos.equipo
    ADD CONSTRAINT equipo_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES dbusers.users(id);


-- TOC entry 4792 (class 2606 OID 16554)
-- Name: notifica notifica_id_usuario_fkey; Type: FK CONSTRAINT; Schema: dbnotifica;

ALTER TABLE ONLY dbnotifica.notifica
    ADD CONSTRAINT notifica_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES dbusers.users(id);


-- TOC entry 4791 (class 2606 OID 16424)
-- Name: passwords passwords_user_id_fkey; Type: FK CONSTRAINT; Schema: dbusers;

ALTER TABLE ONLY dbusers.passwords
    ADD CONSTRAINT passwords_user_id_fkey FOREIGN KEY (user_id) REFERENCES dbusers.users(id) ON DELETE CASCADE;


-- TOC entry 2094 (class 826 OID 16593)
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: db_empresa;

ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA db_empresa GRANT SELECT,INSERT,DELETE,UPDATE ON TABLES TO postgres;


-- Completed on 2025-04-02 23:50:58

-- PostgreSQL database dump complete

crear TRIGGER
CREATE OR REPLACE FUNCTION db_empresa.insertar_persona_desde_administrador()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO dbpersonas.personas (dni, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, telefono, mail) VALUES (NEW.dni, new.primer_nombre, new.segundo_nombre, new.primer_apellido, new.segundo_apellido, new.telefono, new.mail);
   RETURN NEW;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER trg_insertar_persona
AFTER INSERT ON db_empresa.administrador
FOR EACH ROW
EXECUTE FUNCTION db_empresa.insertar_persona_desde_administrador();
--insert into db_empresa.administrador (dni, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, telefono, id, mail) values ('0912412430', 'josue', 'josue', 'palma', 'palma', '0959845124', 12, 'stiven12@gmail.com')
--select * from db_empresa.administrador
--select * from dbpersonas.personas
--ALTER TABLE dbequipos.equipo
--ADD CONSTRAINT fk_equipo_persona  
--FOREIGN KEY (id_usuario)  
--REFERENCES dbpersonas.personas(id)
--ON DELETE CASCADE;
--ALTER TABLE dbpersonas.personas  
--ADD CONSTRAINT unique_personas_id UNIQUE (id);
--ALTER TABLE db_empresa.empresa
--ADD COLUMN id SERIAL PRIMARY KEY;