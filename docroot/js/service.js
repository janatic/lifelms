Liferay.Service.register("Liferay.Service.Lms", "com.liferay.lms.service", "liferaylms-portlet");

Liferay.Service.registerClass(
	Liferay.Service.Lms, "LearningActivityTry",
	{
		createLearningActivityTry: true
	}
);