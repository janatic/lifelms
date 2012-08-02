Liferay.Service.register("Liferay.Service.Lms", "com.liferay.lms.service", "liferaylms-portlet");

Liferay.Service.registerClass(
	Liferay.Service.Lms, "LearningActivity",
	{
		getLearningActivitiesOfGroup: true,
		deleteLearningactivity: true,
		getLearningActivity: true,
		addLearningActivity: true,
		modLearningActivity: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.Lms, "LearningActivityTry",
	{
		createLearningActivityTry: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.Lms, "TestAnswer",
	{
		getTestAnswersByQuestionId: true,
		getTestAnswer: true,
		modTestAnswer: true,
		addTestAnswer: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.Lms, "TestQuestion",
	{
		addQuestion: true,
		getQuestions: true,
		getQuestion: true
	}
);