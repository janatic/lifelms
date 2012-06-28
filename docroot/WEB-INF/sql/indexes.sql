create index IX_A674914A on Lms_LearningActivity (groupId);
create index IX_A26B5373 on Lms_LearningActivity (groupId, typeId);
create index IX_A331EE54 on Lms_LearningActivity (uuid_);
create unique index IX_75B864D6 on Lms_LearningActivity (uuid_, groupId);

create index IX_4AEF2D40 on Lms_LearningActivityResult (actId);
create index IX_2E4B457A on Lms_LearningActivityResult (actId, userId);
create index IX_678F5817 on Lms_LearningActivityResult (userId);
create index IX_8B143A37 on Lms_LearningActivityResult (uuid_);

create index IX_AC65C30D on Lms_LearningActivityTry (uuid_);

create index IX_3596C509 on Lms_LearningType (uuid_);

create index IX_31C145A on Lms_TestAnswer (actId);
create index IX_558E7458 on Lms_TestAnswer (questionId);
create index IX_43412151 on Lms_TestAnswer (uuid_);

create index IX_8D95C0F2 on Lms_TestQuestion (actId);
create index IX_CDBACDE9 on Lms_TestQuestion (uuid_);