#!/usr/bin/env sh
#!/bin/sh
# Launch the Gradle wrapper (this script delegates to the gradle wrapper jar)
progname="$0"
basedir=$(dirname "$progname")
# prefer invoking wrapper jar if present
if [ -f "$basedir/gradle/wrapper/gradle-wrapper.jar" ]; then
  exec java -jar "$basedir/gradle/wrapper/gradle-wrapper.jar" "$@"
fi
# fallback: try system gradle
exec gradle "$@"
