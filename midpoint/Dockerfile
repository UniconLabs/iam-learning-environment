FROM tier/midpoint:latest

MAINTAINER info@evolveum.com

ENV MP_DIR /opt/midpoint

VOLUME ${MP_DIR}/var

COPY container_files/mp-home/ ${MP_DIR}/var/

EXPOSE 8080
