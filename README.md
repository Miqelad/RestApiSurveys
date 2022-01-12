# RestApiSurveys
Описание:
Создан проект на Sprint boot+spring rest+mysql
Для разворачивания и функционирования приложения потребуется:
Java 8+, mysql,обязательная зависимость devtools для локального запуска приложения
Проект создан с помощью сброки maven ипользуется devtools, без ручного
внедрения вебсервиса.
****************************************************************************************
Базы данных представлены, как сущности: src/main/java/com/survey/api/survey/entity
Настройки базы данных лежат по адресу:src/main/resources/application.properties
Обращение к базе данных CRUD репозиториев:src/main/java/com/survey/api/survey/repository
Логика заключена в сервисах:src/main/java/com/survey/api/survey/service
Модели, для вывода на экран:src/main/java/com/survey/api/survey/model
Контроллеры для управления REST:src/main/java/com/survey/api/survey/controller
****************************************************************************************
В Базе данных необходимо вперчую очередь создать учетную запись администратора, для
получения id=1, в будущем только с этим id можно будет проводить изменения.
База данных пользователей связана по отношению одинКоМногим к опросам,а опросы
этим же отношением к вопросам.

****************************************************************************************
создание пользователя, так же подойдет для админа.
--request GET http://localhost:8080/registration
--body {username,password}
****************************************************************************************
Узнать Пользователь вы или Админ
--request GET http://localhost:8080/who
--body {user}
****************************************************************************************
Создание опроса, только Админу
--request POST http://localhost:8080/survey/create
--params{ids=1}
--body{datastart,dataend,description}
****************************************************************************************
Удаление опроса, только Админу
--request DELETE http://localhost:8080/survey/delete/{id}
--params{ids=1}
--body{id}
****************************************************************************************
Обновление опроса, только Админу, так же соблюдение, без это не выполнится
survey.getDatastart()==null
                && survey.getDataend() !=null
                && survey.getId()!=0
                && survey.getDescription()!=null
--request PUT http://localhost:8080/survey/update
--params{ids=1}
--body{id,datastart,dataend,description}
****************************************************************************************
Создание вопроса к опросу, только Админу
--request POST http://localhost:8080/question
--params{ids=1,id-опроса}
--body{question,type}
****************************************************************************************
Удаление вопроса к опросу, только Админу
--request DELETE http://localhost:8080/question/delete/{id}
--params{ids=1}
--path id вопроса
****************************************************************************************
Обновление вопроса, только Админу, так же соблюдение, без это не выполнится
	&& question.getQuestion()!=null
        && question.getId()!=0
        && question.getType()!=null
--request PUT http://localhost:8080/question/update
--params{ids=1}
--body{id,question,type}