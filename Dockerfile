FROM ubuntu

MAINTAINER Erick Bogarin

# ADD JAVA repo
RUN apt-get update && apt-get install -y curl iputils-ping \
  python-software-properties \
  software-properties-common \
  && add-apt-repository ppa:webupd8team/java

RUN echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections \
 && echo debconf shared/accepted-oracle-license-v1-1 seen true | debconf-set-selections \
 && apt-get update && apt-get -y install oracle-java8-installer

#  install Tomcat
RUN mkdir -p /opt/tomcat \
 && curl -SL http://archive.apache.org/dist/tomcat/tomcat-8/v8.0.5/bin/apache-tomcat-8.0.5.tar.gz \
 | tar -xzC /opt/tomcat --strip-components=1 \
 && rm -Rf /opt/tomcat/webapps/docs /opt/tomcat/webapps/examples

# Expose tomcat
EXPOSE 8080

ENV JAVA_OPTS -server -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC \
  -Xms1G -Xmx2G -XX:PermSize=1G -XX:MaxPermSize=2G

COPY app/target/e-shopper.war /opt/tomcat/webapps/e-shopper.war

WORKDIR /opt/tomcat
CMD ["bin/catalina.sh","run"]
