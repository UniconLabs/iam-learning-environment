#!/bin/bash


function copy() {
	echo -e "Creating configuration directory under /etc/cas"
	mkdir -p /etc/cas/config

	echo -e "Copying configuration files from etc/cas to /etc/cas"
	cp -rfv etc/cas/* /etc/cas
}

function help() {
	echo "Usage: build.sh [copy|clean|package|run]"	
}

function clean() {
    rm -Rf *.log
    rm -Rf *.log.gz
	./gradlew clean "$@"
}

function package() {
	./gradlew clean build "$@"
}


function run() {
	package && java -Xdebug -Xrunjdwp:transport=dt_socket,address=5000,server=y,suspend=n -jar build/libs/cas-management.war 
}

if [ $# -eq 0 ]; then
    echo -e "No commands provided. Defaulting to [run]\n"
    run
    exit 0
fi


case "$1" in
"copy")
    copy 
    ;;
"clean")
	shift
    clean "$@"
    ;;
"package")
	shift
    package "$@"
    ;;
"run")
    run "$@"
    ;;
*)
    help
    ;;
esac

