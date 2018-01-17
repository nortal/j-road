#!/bin/bash

if [[ $TRAVIS_PULL_REQUEST == "false" ]]; then
    mvn deploy --settings $DEPLOY_DIR/settings.xml -DperformRelease=true -DskipTests=true -q
    exit $?
fi
