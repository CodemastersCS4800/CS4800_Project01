CREATE TABLE Location (
	location_ID INT (6),
	PRIMARY KEY (location_ID),
	address VARCHAR(50) NOT NULL,
	size VARCHAR (10),
	maxCapacity INT (8) NOT NULL
);

CREATE TABLE KeyPoint (
	keypoint_ID INT (6),
    PRIMARY KEY (keypoint_ID),
    timeStart VARCHAR (7) NOT NULL,
    timeEnd VARCHAR (7) NOT NULL,
    description TEXT NOT NULL
);

CREATE TABLE TimeLine (
	timeline_ID INT (6) primary key not null,
    start_time VARCHAR (7),
    end_time VARCHAR (7),
    description TEXT
);

CREATE table timelineKeypoints (
	timeline_ID INT (6) not null,
	foreign key (timeline_ID) references Timeline(timeline_ID),
    keypoint_ID INT (6) not null,
    foreign key (keypoint_ID) references keypoint(keypoint_ID),
    primary key (timeline_ID, keypoint_ID)
);

create table organizationalEvent (
	organizationalEvent_ID INT (6) primary key,
    timeline_ID INT (6) not null,
    foreign key (timeline_ID) references Timeline(timeline_ID),
    location_ID INT (6) not null,
    foreign key (location_ID) references Location(location_ID),
    date VARCHAR (8),
    guestListPath VARCHAR (255),
    finalFilePath VARCHAR (255)
);

create table publicEvent (
	publicEvent_ID INT (6) primary key,
    timeline_ID INT (6) not null,
    foreign key (timeline_ID) references timeline(timeline_ID),
    location_ID INT (6) not null,
    foreign key (location_ID) references location(location_ID),
    date VARCHAR (8),
    finalFilePath VARCHAR (255)
);


