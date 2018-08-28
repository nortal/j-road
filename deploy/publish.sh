#!/bin/bash

if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    openssl aes-256-cbc -K $encrypted_01d4f09c8171_key -iv $encrypted_01d4f09c8171_iv -in $DEPLOY_DIR/codesigning.asc.enc -out $DEPLOY_DIR/codesigning.asc -d
    gpg --fast-import $DEPLOY_DIR/signingkey.asc
    
    mvn deploy --settings $DEPLOY_DIR/settings.xml -DperformRelease=true -DskipTests=true
    exit $?
fi
