PGDMP              
            w         
   contentSQL    11.2    11.2     +           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            ,           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            -           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            .           1262    16488 
   contentSQL    DATABASE     �   CREATE DATABASE "contentSQL" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE "contentSQL";
             postgres    false            �            1259    16525 
   course_seq    SEQUENCE     s   CREATE SEQUENCE public.course_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.course_seq;
       public       postgres    false            �            1259    16492    course    TABLE     �   CREATE TABLE public.course (
    id integer DEFAULT nextval('public.course_seq'::regclass) NOT NULL,
    name character varying(30) NOT NULL,
    description character varying(100) NOT NULL
);
    DROP TABLE public.course;
       public         postgres    false    200            �            1259    16530    course_room_seq    SEQUENCE     x   CREATE SEQUENCE public.course_room_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.course_room_seq;
       public       postgres    false            �            1259    16504    course_room    TABLE     �   CREATE TABLE public.course_room (
    id integer DEFAULT nextval('public.course_room_seq'::regclass) NOT NULL,
    "idRoom" integer NOT NULL,
    "idCourse" integer NOT NULL
);
    DROP TABLE public.course_room;
       public         postgres    false    201            �            1259    16533    room_seq    SEQUENCE     q   CREATE SEQUENCE public.room_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.room_seq;
       public       postgres    false            �            1259    16495    room    TABLE     �   CREATE TABLE public.room (
    amount integer NOT NULL,
    number integer NOT NULL,
    id integer DEFAULT nextval('public.room_seq'::regclass) NOT NULL
);
    DROP TABLE public.room;
       public         postgres    false    202            �            1259    16557    student_seq    SEQUENCE     t   CREATE SEQUENCE public.student_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.student_seq;
       public       postgres    false            �            1259    16489    student    TABLE     I  CREATE TABLE public.student (
    id integer DEFAULT nextval('public.student_seq'::regclass) NOT NULL,
    "firstName" character varying(30) NOT NULL,
    "lastName" character varying(30) NOT NULL,
    email character varying(40) NOT NULL,
    documentation character varying(10) NOT NULL,
    identification integer NOT NULL
);
    DROP TABLE public.student;
       public         postgres    false    204            �            1259    16560    teacher_seq    SEQUENCE     t   CREATE SEQUENCE public.teacher_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.teacher_seq;
       public       postgres    false            �            1259    16536    teacher    TABLE     I  CREATE TABLE public.teacher (
    id integer DEFAULT nextval('public.teacher_seq'::regclass) NOT NULL,
    "firstName" character varying(30) NOT NULL,
    "lastName" character varying(30) NOT NULL,
    email character varying(40) NOT NULL,
    documentation character varying(10) NOT NULL,
    identification integer NOT NULL
);
    DROP TABLE public.teacher;
       public         postgres    false    205                       0    16492    course 
   TABLE DATA               7   COPY public.course (id, name, description) FROM stdin;
    public       postgres    false    197   �        "          0    16504    course_room 
   TABLE DATA               ?   COPY public.course_room (id, "idRoom", "idCourse") FROM stdin;
    public       postgres    false    199   !       !          0    16495    room 
   TABLE DATA               2   COPY public.room (amount, number, id) FROM stdin;
    public       postgres    false    198   +!                 0    16489    student 
   TABLE DATA               d   COPY public.student (id, "firstName", "lastName", email, documentation, identification) FROM stdin;
    public       postgres    false    196   H!       &          0    16536    teacher 
   TABLE DATA               d   COPY public.teacher (id, "firstName", "lastName", email, documentation, identification) FROM stdin;
    public       postgres    false    203   e!       /           0    0    course_room_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.course_room_seq', 1, false);
            public       postgres    false    201            0           0    0 
   course_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.course_seq', 1, false);
            public       postgres    false    200            1           0    0    room_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('public.room_seq', 1, false);
            public       postgres    false    202            2           0    0    student_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.student_seq', 1, false);
            public       postgres    false    204            3           0    0    teacher_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.teacher_seq', 1, false);
            public       postgres    false    205            �
           2606    16499    course course_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.course DROP CONSTRAINT course_pkey;
       public         postgres    false    197            �
           2606    16508    course_room course_room_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.course_room
    ADD CONSTRAINT course_room_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.course_room DROP CONSTRAINT course_room_pkey;
       public         postgres    false    199            �
           2606    16503    room room_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.room DROP CONSTRAINT room_pkey;
       public         postgres    false    198            �
           2606    16529    student student_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.student DROP CONSTRAINT student_pkey;
       public         postgres    false    196            �
           2606    16556    teacher teacher_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.teacher
    ADD CONSTRAINT teacher_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.teacher DROP CONSTRAINT teacher_pkey;
       public         postgres    false    203            �
           2606    16509    course_room fk_idCourse    FK CONSTRAINT     |   ALTER TABLE ONLY public.course_room
    ADD CONSTRAINT "fk_idCourse" FOREIGN KEY ("idCourse") REFERENCES public.course(id);
 C   ALTER TABLE ONLY public.course_room DROP CONSTRAINT "fk_idCourse";
       public       postgres    false    199    2717    197            �
           2606    16514    course_room fk_idRoom    FK CONSTRAINT     v   ALTER TABLE ONLY public.course_room
    ADD CONSTRAINT "fk_idRoom" FOREIGN KEY ("idRoom") REFERENCES public.room(id);
 A   ALTER TABLE ONLY public.course_room DROP CONSTRAINT "fk_idRoom";
       public       postgres    false    199    198    2719                   x������ � �      "      x������ � �      !      x������ � �            x������ � �      &      x������ � �     