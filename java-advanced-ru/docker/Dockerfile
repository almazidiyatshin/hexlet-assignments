FROM eclipse-temurin:20-jdk

# Указываем рабочую директорию внутри контейнера
WORKDIR /project

# Копируем проект в контейнер
COPY ./project .

# Установка Gradle
ARG GRADLE_VERSION=8.2
RUN apt-get update && apt-get install -yq make unzip \
    && wget -q https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip \
    && unzip gradle-${GRADLE_VERSION}-bin.zip \
    && rm gradle-${GRADLE_VERSION}-bin.zip \
    && mv gradle-${GRADLE_VERSION} /opt/gradle

# Настраиваем переменные среды для Gradle
ENV GRADLE_HOME=/opt/gradle
ENV PATH=$PATH:$GRADLE_HOME/bin

# Открываем порт для приложения
EXPOSE 8080

# Сборка и запуск приложения (если оно Java-приложение)
RUN gradle build
CMD ["java", "-jar", "/project/build/libs/*.jar"]