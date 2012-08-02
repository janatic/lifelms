create table Lms_LearningActivity (
	uuid_ VARCHAR(75) null,
	actId LONG not null primary key,
	companyId LONG,
	userId LONG,
	groupId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	title VARCHAR(75) null,
	description TEXT null,
	typeId INTEGER,
	startdate DATE null,
	enddate DATE null,
	precedence INTEGER,
	tries LONG
);

create table Lms_LearningActivityResult (
	uuid_ VARCHAR(75) null,
	larId LONG not null primary key,
	actId LONG,
	userId LONG,
	result LONG,
	startDate DATE null,
	endDate DATE null,
	latId LONG,
	comments TEXT null
);

create table Lms_LearningActivityTry (
	uuid_ VARCHAR(75) null,
	latId LONG not null primary key,
	actId LONG,
	userId LONG,
	startDate DATE null,
	result LONG,
	endDate DATE null,
	tryData VARCHAR(75) null,
	tryResultData VARCHAR(75) null,
	comments TEXT null
);

create table Lms_LearningType (
	uuid_ VARCHAR(75) null,
	typeId LONG not null primary key,
	name VARCHAR(75) null,
	className VARCHAR(75) null
);

create table Lms_TestAnswer (
	uuid_ VARCHAR(75) null,
	answerId LONG not null primary key,
	questionId LONG,
	actId LONG,
	precedence LONG,
	answer TEXT null,
	isCorrect BOOLEAN
);

create table Lms_TestQuestion (
	uuid_ VARCHAR(75) null,
	questionId LONG not null primary key,
	actId LONG,
	text_ TEXT null,
	questionType LONG
);