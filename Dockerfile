FROM maven:3.8.1-openjdk-17-slim AS build

RUN mkdir /home/ipljunstats
copy . /home/ipljunstats
RUN cd /home/ipljunstats && mvn package
RUN cp /home/ipljunstats/target/*.jar ipl-jun-stats.jar

ENTRYPOINT [ "java","-jar","ipl-jun-stats.jar" ]

EXPOSE 8081
