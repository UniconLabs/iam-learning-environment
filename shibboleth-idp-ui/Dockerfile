FROM centos:centos8 as download_ui

ARG ui_version=1.7.0

RUN idp_version=4.0.1; \
    ui_hash=36b13605d5bfa31727d87816500dfdd025ffd12647ea3253bcbb098b66aae49b; \
 curl -L https://github.internet2.edu/TIER/shib-idp-ui/releases/download/v${ui_version}/shibui-${ui_version}.war -o shibui.war \
 && echo "$ui_hash  shibui.war" | sha256sum -c -

FROM gcr.io/distroless/java

COPY --from=download_ui shibui.war shibui.war

EXPOSE 8080

ENTRYPOINT ["/usr/bin/java", "-jar", "shibui.war"]
