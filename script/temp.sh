#!/usr/bin/env bash
echo $HOME
echo ${FlUTTER_HOME}
echo ${ANDROID_HOME}
source="${FlUTTER_HOME}/packages/flutter_tools/gradle/flutter.gradle"
cp  $source ./flutter.gradle.back