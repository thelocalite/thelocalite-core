FROM openjdk:8-jdk-alpine

LABEL maintainer="@vatadepalli"

ENV version=docker_prod

# Database Related Stuff
ENV dbuser=${dbuser}
ENV dbpass=${dbpass}
ENV jdbcurl=${jdbcurl}

# Environment Selection
ENV SPRING_PROFILES_ACTIVE={SPRING_PROFILES_ACTIVE}

WORKDIR /usr/local/bin/

ADD ./target/core.jar .

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "core.jar" ]

############### Execution ###############
# docker build -t <img_name> .
# docker run -p <Ext_Port>:8080 <img_name>