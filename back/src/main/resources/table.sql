create table public.tb_weather_data
(
    weather_id       integer                  default nextval('weather_data_weather_id_seq'::regclass) not null
        constraint weather_data_pkey
            primary key,
    location_id      integer,
    temperature      numeric(5, 2)                                                                     not null,
    condition        varchar(50)                                                                       not null,
    observation_time timestamp with time zone default CURRENT_TIMESTAMP
);

alter table public.tb_weather_data
    owner to root;

create table public.tb_users
(
    user_id  integer default nextval('users_user_id_seq'::regclass) not null
        constraint users_pkey
            primary key,
    username varchar(50)                                            not null
        constraint unique_username
            unique,
    chat_id  integer                                                not null
        constraint unique_chat_id
            unique
);

alter table public.tb_users
    owner to root;

create table public.tb_user_locations
(
    location_id   integer default nextval('user_locations_location_id_seq'::regclass) not null
        constraint user_locations_pkey
            primary key,
    user_id       integer,
    location_name varchar(100)                                                        not null,
    latitude      numeric(9, 6)                                                       not null,
    longitude     numeric(9, 6)                                                       not null
);

alter table public.tb_user_locations
    owner to root;

create table public.tb_telegram_bot_info
(
    bot_token varchar not null,
    chat_id   bigint  not null
);

alter table public.tb_telegram_bot_info
    owner to root;

create table public.tb_weather_area
(
    admdst_cd varchar(50) not null,
    stdg_ctpv varchar(50) not null,
    stdg_sgg  varchar(50) default NULL::character varying,
    stdg_emd  varchar(50) default NULL::character varying,
    grid_x    varchar(50) not null,
    grid_y    varchar(50) not null,
    lot_hr    varchar(50) not null,
    lot_mint  varchar(50) not null,
    lot_scnd  varchar(50) not null,
    lat_hr    varchar(50) not null,
    lat_mint  varchar(50) not null,
    lat_scnd  varchar(50) not null,
    lot_mlls  varchar(50) not null,
    lat_mlls  varchar(50) not null
);

comment on column public.tb_weather_area.admdst_cd is '행정 지역 코드';

comment on column public.tb_weather_area.stdg_ctpv is '시도';

comment on column public.tb_weather_area.stdg_sgg is '시, 군, 구';

comment on column public.tb_weather_area.stdg_emd is '읍, 면, 동';

comment on column public.tb_weather_area.grid_x is '그리드 X';

comment on column public.tb_weather_area.grid_y is '그리드 Y';

comment on column public.tb_weather_area.lot_hr is '경도 (시)';

comment on column public.tb_weather_area.lot_mint is '경도 (분)';

comment on column public.tb_weather_area.lot_scnd is '경도 (초)';

comment on column public.tb_weather_area.lat_hr is '위도 (시)';

comment on column public.tb_weather_area.lat_mint is '위도 (분)';

comment on column public.tb_weather_area.lat_scnd is '위도 (초)';

comment on column public.tb_weather_area.lot_mlls is '경도 (초/100)';

comment on column public.tb_weather_area.lat_mlls is '위도 (초/100)';

alter table public.tb_weather_area
    owner to root;

create table public.tb_notifications
(
    notification_id   integer default nextval('notifications_notification_id_seq'::regclass) not null
        constraint notifications_pkey
            primary key,
    user_id           integer,
    location_id       integer,
    notification_time time                                                                   not null
);

alter table public.tb_notifications
    owner to root;

