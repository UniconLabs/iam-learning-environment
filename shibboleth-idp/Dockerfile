FROM amazoncorretto:11 as download

ARG TOMCAT_VERSION=9.0.63

COPY keys/TOMCAT_PGP_KEYS /tmp/TOMCAT_PGP_KEYS

RUN yum update -y \
    && yum install -y tar gzip \
    && gpg --import /tmp/TOMCAT_PGP_KEYS

RUN curl -L https://downloads.apache.org/tomcat/tomcat-9/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz -o apache-tomcat-${TOMCAT_VERSION}.tar.gz \
    && curl -L https://downloads.apache.org/tomcat/tomcat-9/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz.asc -o apache-tomcat-${TOMCAT_VERSION}.tar.gz.asc \
    && gpg --verify apache-tomcat-${TOMCAT_VERSION}.tar.gz.asc apache-tomcat-${TOMCAT_VERSION}.tar.gz \
    && tar -zxvf apache-tomcat-${TOMCAT_VERSION}.tar.gz -C /opt \
    && rm apache-tomcat-${TOMCAT_VERSION}.tar.gz \
    && mv /opt/apache-tomcat-${TOMCAT_VERSION}/ /opt/tomcat \
    && rm -rf /opt/tomcat/webapps/

FROM amazoncorretto:11 as prod

COPY --from=download /opt/tomcat /opt/tomcat/
COPY image_files/shibboleth/ /opt/shibboleth-idp/
COPY image_files/tomcat/idp.xml /opt/tomcat/conf/Catalina/localhost/

RUN /opt/shibboleth-idp/bin/build.sh -Didp.noprompt=true -Didp.target.dir=/opt/shibboleth-idp/

ENTRYPOINT ["/opt/tomcat/bin/catalina.sh",  "run"]
