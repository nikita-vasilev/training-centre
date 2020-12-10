PGDMP     &            
        x         
   netcracker    13.1    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16394 
   netcracker    DATABASE     g   CREATE DATABASE netcracker WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE netcracker;
                postgres    false            �            1259    16431    Company    TABLE     h   CREATE TABLE public."Company" (
    "ID" bigint NOT NULL,
    "Name" character varying(300) NOT NULL
);
    DROP TABLE public."Company";
       public         heap    postgres    false            �            1259    16472    Company_ID_seq    SEQUENCE     �   ALTER TABLE public."Company" ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Company_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999
    CACHE 1
);
            public          postgres    false    201            �            1259    16451    EmpToProject    TABLE        CREATE TABLE public."EmpToProject" (
    "ID" bigint NOT NULL,
    "EmpID" bigint NOT NULL,
    "ProjectID" bigint NOT NULL
);
 "   DROP TABLE public."EmpToProject";
       public         heap    postgres    false            �            1259    16476    EmpToProject_ID_seq    SEQUENCE     �   ALTER TABLE public."EmpToProject" ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."EmpToProject_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999
    CACHE 1
);
            public          postgres    false    203            �            1259    16423    Employee    TABLE     �   CREATE TABLE public."Employee" (
    "ID" bigint NOT NULL,
    "Name" character varying(300) NOT NULL,
    "Department" character varying(300) NOT NULL
);
    DROP TABLE public."Employee";
       public         heap    postgres    false            �            1259    16468    Employee_ID_seq    SEQUENCE     �   ALTER TABLE public."Employee" ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Employee_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999999
    CACHE 1
);
            public          postgres    false    200            �            1259    16436    Project    TABLE     �   CREATE TABLE public."Project" (
    "ID" bigint NOT NULL,
    "CompanyID" bigint NOT NULL,
    "ManagerID" bigint NOT NULL,
    "Name" character varying(300) NOT NULL
);
    DROP TABLE public."Project";
       public         heap    postgres    false            �            1259    16474    Project_ID_seq    SEQUENCE     �   ALTER TABLE public."Project" ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Project_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999
    CACHE 1
);
            public          postgres    false    202            �          0    16431    Company 
   TABLE DATA           1   COPY public."Company" ("ID", "Name") FROM stdin;
    public          postgres    false    201   �       �          0    16451    EmpToProject 
   TABLE DATA           D   COPY public."EmpToProject" ("ID", "EmpID", "ProjectID") FROM stdin;
    public          postgres    false    203   T        �          0    16423    Employee 
   TABLE DATA           @   COPY public."Employee" ("ID", "Name", "Department") FROM stdin;
    public          postgres    false    200   �        �          0    16436    Project 
   TABLE DATA           K   COPY public."Project" ("ID", "CompanyID", "ManagerID", "Name") FROM stdin;
    public          postgres    false    202   !       �           0    0    Company_ID_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public."Company_ID_seq"', 5, true);
          public          postgres    false    205            �           0    0    EmpToProject_ID_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public."EmpToProject_ID_seq"', 7, true);
          public          postgres    false    207            �           0    0    Employee_ID_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public."Employee_ID_seq"', 5, true);
          public          postgres    false    204            �           0    0    Project_ID_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public."Project_ID_seq"', 3, true);
          public          postgres    false    206            8           2606    16435    Company Company_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public."Company"
    ADD CONSTRAINT "Company_pkey" PRIMARY KEY ("ID");
 B   ALTER TABLE ONLY public."Company" DROP CONSTRAINT "Company_pkey";
       public            postgres    false    201            >           2606    16455    EmpToProject EmpToProject_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public."EmpToProject"
    ADD CONSTRAINT "EmpToProject_pkey" PRIMARY KEY ("ID");
 L   ALTER TABLE ONLY public."EmpToProject" DROP CONSTRAINT "EmpToProject_pkey";
       public            postgres    false    203            6           2606    16430    Employee Employee_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public."Employee"
    ADD CONSTRAINT "Employee_pkey" PRIMARY KEY ("ID");
 D   ALTER TABLE ONLY public."Employee" DROP CONSTRAINT "Employee_pkey";
       public            postgres    false    200            :           2606    16440    Project Project_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public."Project"
    ADD CONSTRAINT "Project_pkey" PRIMARY KEY ("ID");
 B   ALTER TABLE ONLY public."Project" DROP CONSTRAINT "Project_pkey";
       public            postgres    false    202            <           2606    16471    Project UniqueName 
   CONSTRAINT     S   ALTER TABLE ONLY public."Project"
    ADD CONSTRAINT "UniqueName" UNIQUE ("Name");
 @   ALTER TABLE ONLY public."Project" DROP CONSTRAINT "UniqueName";
       public            postgres    false    202            ?           2606    16441    Project CompanyFK    FK CONSTRAINT     ~   ALTER TABLE ONLY public."Project"
    ADD CONSTRAINT "CompanyFK" FOREIGN KEY ("CompanyID") REFERENCES public."Company"("ID");
 ?   ALTER TABLE ONLY public."Project" DROP CONSTRAINT "CompanyFK";
       public          postgres    false    2872    201    202            A           2606    16456    EmpToProject EmployeeFK    FK CONSTRAINT     �   ALTER TABLE ONLY public."EmpToProject"
    ADD CONSTRAINT "EmployeeFK" FOREIGN KEY ("EmpID") REFERENCES public."Employee"("ID");
 E   ALTER TABLE ONLY public."EmpToProject" DROP CONSTRAINT "EmployeeFK";
       public          postgres    false    203    2870    200            @           2606    16446    Project ManagerFK    FK CONSTRAINT        ALTER TABLE ONLY public."Project"
    ADD CONSTRAINT "ManagerFK" FOREIGN KEY ("ManagerID") REFERENCES public."Employee"("ID");
 ?   ALTER TABLE ONLY public."Project" DROP CONSTRAINT "ManagerFK";
       public          postgres    false    202    200    2870            B           2606    16461    EmpToProject ProjectFK    FK CONSTRAINT     �   ALTER TABLE ONLY public."EmpToProject"
    ADD CONSTRAINT "ProjectFK" FOREIGN KEY ("ProjectID") REFERENCES public."Project"("ID");
 D   ALTER TABLE ONLY public."EmpToProject" DROP CONSTRAINT "ProjectFK";
       public          postgres    false    2874    203    202            �   G   x�3�	�2��ML��,�2���L.�/�O+�2�ί*K�J�L�2�t�Ȭ��/KTpO�I-������ Z|�      �   ,   x���  ��7�]��簏^��#)-ZӉ��W������      �   u   x�M�K
�@ �ur��@�w iWŮܸ�C��%���^�u��z�n��%F�SJ^��=q-�Х�,�u�c���ǭ�d����5�Ag^�m=G�7j�����E����"~?�-*      �   J   x�3�4�4���,K-*�,�T �\F�F@Q����������"������ĢT.cNNSNwg�`��=... �c     